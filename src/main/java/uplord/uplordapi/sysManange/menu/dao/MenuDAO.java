package uplord.uplordapi.sysManange.menu.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import uplord.uplordapi.sysManange.menu.dto.MenuDto;

import java.util.List;

@Mapper
@Repository
public interface MenuDAO {
	List<MenuDto> findList(MenuDto param) throws Exception;
}
