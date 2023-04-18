package uplord.uplordapi.domain.attendance.dao;

import uplord.uplordapi.domain.attendance.dto.AttendanceRequestDto;
import uplord.uplordapi.domain.attendance.dto.RegisterAttendanceCommand;
import uplord.uplordapi.domain.attendance.entity.Attendance;

import java.util.List;

public interface AttendanceDao {
    int createAttendance(RegisterAttendanceCommand registerAttendanceCommand);

    List<Attendance> findAttendanceByRequestDto(AttendanceRequestDto attendanceRequestDto);

    int updateAttendanceToYN(AttendanceRequestDto attendance);
}
