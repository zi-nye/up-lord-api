package uplord.uplordapi.domain.attendance.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uplord.uplordapi.domain.attendance.dao.AttendanceDao;
import uplord.uplordapi.domain.attendance.dto.AttendanceRequestDto;
import uplord.uplordapi.domain.attendance.dto.AttendanceResponseDto;
import uplord.uplordapi.domain.attendance.dto.RegisterAttendanceCommand;
import uplord.uplordapi.domain.attendance.entity.Attendance;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AttendanceReadService {

    final private AttendanceDao attendanceDao;

    public AttendanceResponseDto toDto(Attendance attendance) {
        return new AttendanceResponseDto(
                attendance.getAttendanceId(),
                attendance.getMemberIdx(),
                attendance.getAttendanceYn(),
                attendance.getAttendanceDate(),
                attendance.getMemo());
    }

    public List<AttendanceResponseDto> findAttendanceByRequestDto(AttendanceRequestDto attendanceRequestDto) {
        var attendances = attendanceDao.findAttendanceByRequestDto(attendanceRequestDto);

        return attendances.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public Object registerAttendance(RegisterAttendanceCommand requestDto) {
    }
}