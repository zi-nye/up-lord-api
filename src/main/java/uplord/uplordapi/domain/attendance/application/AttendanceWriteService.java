package uplord.uplordapi.domain.attendance.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uplord.uplordapi.domain.attendance.dao.AttendanceDao;
import uplord.uplordapi.domain.attendance.dto.RegisterAttendanceCommand;
import uplord.uplordapi.domain.attendance.entity.Attendance;

@Service
@RequiredArgsConstructor
public class AttendanceWriteService {

    final private AttendanceDao attendanceDao;
    public Attendance create(RegisterAttendanceCommand command) {
        attendanceDao.create(command);
        return attendance;
    }
}
