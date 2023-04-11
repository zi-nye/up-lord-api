package uplord.uplordapi.domain.attendance.dao;

import uplord.uplordapi.domain.attendance.dto.RegisterAttendanceCommand;

public interface AttendanceDao {
    Long create(RegisterAttendanceCommand command);
}
