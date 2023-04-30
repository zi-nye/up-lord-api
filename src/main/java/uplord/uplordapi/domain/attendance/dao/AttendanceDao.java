package uplord.uplordapi.domain.attendance.dao;

import uplord.uplordapi.domain.attendance.dto.AttendanceDto;
import uplord.uplordapi.domain.attendance.dto.RegisterAttendanceCommand;
import uplord.uplordapi.domain.attendance.entity.Attendance;

import java.util.List;

public interface AttendanceDao {
    Long createAttendance(Attendance registerAttendanceCommand);

    List<Attendance> findAttendanceByRequestDto(AttendanceDto AttendanceDto);

    int updateAttendanceToYN(AttendanceDto attendance);
}
