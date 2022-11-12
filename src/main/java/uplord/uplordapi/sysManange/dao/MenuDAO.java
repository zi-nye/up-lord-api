package uplord.uplordapi.sysManange.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import uplord.uplordapi.sysManange.vo.MenuVo;

import java.util.List;

@Mapper
@Repository
public interface MenuDAO {
	List<MenuVo> findList(MenuVo param);
}
