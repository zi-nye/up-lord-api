package uplord.uplordapi.cellManage.service;

import uplord.uplordapi.dto.AttendanceDTO;

import java.util.List;

public interface AttendanceService {
    List<AttendanceDTO> findAttendanceList(AttendanceDTO param);

    void create(AttendanceDTO param);

    void update(AttendanceDTO param);
}
