package uplord.uplordapi.domain.attendance.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uplord.uplordapi.domain.attendance.dao.AttendanceDao;
import uplord.uplordapi.domain.attendance.dto.AttendanceDto;
import uplord.uplordapi.domain.attendance.dto.AttendanceResponseDto;
import uplord.uplordapi.domain.attendance.entity.Attendance;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AttendanceReadService {

    final private AttendanceDao attendanceDao;

    public AttendanceDto toDto(Attendance attendance) {
        return AttendanceDto.builder()
                .attendanceId(attendance.getAttendanceId())
                .memberIdx(attendance.getMemberIdx())
                .attendanceYn(attendance.getAttendanceYn())
                .attendanceDate(attendance.getAttendanceDate())
                .memo(attendance.getMemo())
                .build();
    }

    public List<AttendanceResponseDto> findAttendanceByRequestDto(AttendanceDto attendanceDto) {
        var attendances = attendanceDao.findAttendanceByRequestDto(attendanceDto);

        return attendances;
    }
}