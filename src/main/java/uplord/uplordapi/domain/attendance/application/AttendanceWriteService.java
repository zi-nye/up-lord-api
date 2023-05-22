package uplord.uplordapi.domain.attendance.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uplord.uplordapi.domain.attendance.dao.AttendanceDao;
import uplord.uplordapi.domain.attendance.dto.AttendanceDto;
import uplord.uplordapi.domain.attendance.dto.AttendanceResponseDto;
import uplord.uplordapi.domain.attendance.dto.RegisterAttendanceCommand;
import uplord.uplordapi.domain.attendance.entity.Attendance;
import uplord.uplordapi.domain.attendance.exception.RegisterDupException;
import uplord.uplordapi.domain.member.application.MemberReadService;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AttendanceWriteService {

    final private AttendanceDao attendanceDao;
    final private AttendanceReadService attendanceReadService;
    final private MemberReadService memberReadService;

    public void updateAttendance(AttendanceDto requestDto) {
        attendanceDao.updateAttendanceToYN(requestDto);
    }

    public Boolean doAttendance(List<AttendanceDto> attendances) {
        int result = 0;

        for (AttendanceDto attendance : attendances) {
            result += attendanceDao.updateAttendanceToYN(attendance);
        }

        return result == attendances.size();
    }

    // 출석부를 생성한다.
    public List<AttendanceDto> registerAttendance(RegisterAttendanceCommand command) {
        try {
            LocalDate attendanceDate = command.getAttendanceDate();
            List<AttendanceResponseDto> dupCheck = attendanceReadService.findAttendance(attendanceDate);
            if (dupCheck.size() != 0) {
                throw new RegisterDupException();
            }

            List<Long> memberIdxs = memberReadService.findAllMemberIdx();
            List<Attendance> attendances = new ArrayList<>();
            memberIdxs.forEach(idxs -> {
                var attendance = Attendance.builder()
                        .attendanceId(null)
                        .memberIdx(idxs)
                        .attendanceYn('N')
                        .attendanceDate(command.getAttendanceDate())
                        .createdIp(null)
                        .createdAt(LocalDateTime.now())
                        .updatedIp(null)
                        .createdUid(1L)
                        .memo(null)
                        .build();
                attendances.add(new Attendance(attendanceDao.createAttendance(attendance), attendance));
            });

            return attendances.stream()
                    .map(attendanceReadService::toDto)
                    .collect(Collectors.toList());
        } catch (RegisterDupException e) {
            throw new RegisterDupException("[ERROR] 출석부가 중복 될 수 없습니다.");
        }
    }
}
