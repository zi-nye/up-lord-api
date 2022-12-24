package uplord.uplordapi.sysManage.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import uplord.uplordapi.dto.MenuDTO;

import java.util.List;

@Mapper
@Repository
public interface MenuManageDAO {
	List<MenuDTO> findList(MenuDTO param);
}
