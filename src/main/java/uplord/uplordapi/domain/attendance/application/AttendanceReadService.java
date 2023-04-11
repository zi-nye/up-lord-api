package uplord.uplordapi.domain.attendance.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uplord.uplordapi.domain.attendance.dto.AttendanceRequestDto;
import uplord.uplordapi.domain.attendance.dto.AttendanceResponseDto;
import uplord.uplordapi.domain.attendance.entity.Attendance;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AttendanceReadService {

    public List<AttendanceResponseDto> getAttendance(AttendanceRequestDto attendanceRequestDto) {
        return null;
    }

    public AttendanceResponseDto toDto(Attendance attendance) {
        return new AttendanceResponseDto(
                attendance.getAttendanceId(),
                attendance.getMemberIdx(),
                attendance.getAttendanceYn(),
                attendance.getWriteDate(),
                attendance.getMemo(),
                attendance.getCompleteYn());
    }
}