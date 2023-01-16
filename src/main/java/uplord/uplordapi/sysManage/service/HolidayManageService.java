package uplord.uplordapi.sysManage.service;

import uplord.uplordapi.dto.HolidayDTO;

import java.util.List;

public interface HolidayManageService {
    List<HolidayDTO> findHolidayList(HolidayDTO param);

    int create(HolidayDTO param);

    int update(HolidayDTO param);
}
