package uplord.uplordapi.sysManange.menu.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import uplord.uplordapi.sysManange.menu.vo.MenuVo;

import java.util.List;

@Mapper
@Repository
public interface MenuDAO {
	List<MenuVo> findList(MenuVo param);
}