package uplord.uplordapi.sysManage.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uplord.uplordapi.dto.HolidayDTO;
import uplord.uplordapi.sysManage.dao.HolidayManageDAO;
import uplord.uplordapi.sysManage.service.HolidayManageService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HolidayManageServiceImpl implements HolidayManageService {
    private final HolidayManageDAO dao;

    @Override
    public List<HolidayDTO> findHolidayList(HolidayDTO param) {
        return dao.findHolidayList(param);
    }

    @Override
    public int create(HolidayDTO param) {
        return dao.create(param);
    }

    @Override
    public int update(HolidayDTO param) {
        return dao.update(param);
    }

}
