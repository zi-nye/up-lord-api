package uplord.uplordapi.domain.attendance.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uplord.uplordapi.domain.attendance.dao.AttendanceDao;
import uplord.uplordapi.domain.attendance.dto.AttendanceRequestDto;
import uplord.uplordapi.domain.attendance.dto.AttendanceResponseDto;
import uplord.uplordapi.domain.attendance.dto.RegisterAttendanceCommand;
import uplord.uplordapi.domain.attendance.entity.Attendance;
import uplord.uplordapi.domain.member.application.MemberReadService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AttendanceWriteService {

    final private AttendanceDao attendanceDao;
    final private AttendanceReadService attendanceReadService;
    final private MemberReadService memberReadService;
    public Boolean updateAttendance(List<AttendanceRequestDto> requestDtos) {
        int result = 0;

        for (AttendanceRequestDto requestDto : requestDtos) {
            result += attendanceDao.createAttendance(requestDto);
        }

        return result == requestDtos.size();
    }

    public Boolean cancelAttendance(List<AttendanceRequestDto> attendances) {
        int result = 0;

        for (AttendanceRequestDto attendance : attendances) {
            result += attendanceDao.updateAttendanceToYN(attendance);
        }


        return result == attendances.size();
    }

    public Boolean doAttendance(List<AttendanceRequestDto> attendances) {
        int result = 0;

        for (AttendanceRequestDto attendance : attendances) {
            result += attendanceDao.updateAttendanceToYN(attendance);
        }


        return result == attendances.size();
    }

    // 출석부를 생성한다.
    public List<AttendanceResponseDto> registerAttendance(RegisterAttendanceCommand requestDto) {
        // 1. 출석부에 날짜는 중복될수 없다. -> 중복체크
        List<Long> memberIdxs = memberReadService.findAllMemberIdx();
        memberIdxs.forEach(
               idxs -> {

                   attendanceDao.createAttendance(requestDto)
               }
        );

        int result = ;

    }
}
