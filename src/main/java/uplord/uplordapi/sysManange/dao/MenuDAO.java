package uplord.uplordapi.sysManange.menu.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import uplord.uplordapi.sysManange.dto.MenuDTO;

import java.util.List;

@Mapper
@Repository
public interface MenuDAO {
	List<MenuDTO> findList(MenuDTO param);
}
