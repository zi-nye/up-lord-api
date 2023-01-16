package uplord.uplordapi.sysManage.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import uplord.uplordapi.dto.HolidayDTO;

import java.util.List;

@Mapper
@Repository
public interface HolidayManageDAO {

    List<HolidayDTO> findHolidayList(HolidayDTO param);
    int create(HolidayDTO param);
    int update(HolidayDTO param);

}
