package uplord.uplordapi.domain.attendance.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uplord.uplordapi.domain.attendance.dao.AttendanceDao;
import uplord.uplordapi.domain.attendance.dto.AttendanceRequestDto;
import uplord.uplordapi.domain.attendance.dto.RegisterAttendanceCommand;
import uplord.uplordapi.domain.attendance.entity.Attendance;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AttendanceWriteService {

    final private AttendanceDao attendanceDao;
    public Boolean createAttendance(List<RegisterAttendanceCommand> command) {
        int result = 0;

        for (RegisterAttendanceCommand registerAttendanceCommand : command) {
            result += attendanceDao.createAttendance(registerAttendanceCommand);
        }

        return result == command.size();
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

}
