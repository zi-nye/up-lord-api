package uplord.uplordapi.domain.attendance.dao;

import org.apache.ibatis.annotations.Mapper;
import uplord.uplordapi.domain.attendance.dto.AttendanceDto;
import uplord.uplordapi.domain.attendance.dto.AttendanceResponseDto;
import uplord.uplordapi.domain.attendance.dto.RegisterAttendanceCommand;
import uplord.uplordapi.domain.attendance.entity.Attendance;

import java.util.List;
@Mapper
public interface AttendanceDao {
    Long createAttendance(Attendance registerAttendanceCommand);

    List<AttendanceResponseDto> findAttendanceByRequestDto(AttendanceDto AttendanceDto);

    int updateAttendanceToYN(AttendanceDto attendance);
}
