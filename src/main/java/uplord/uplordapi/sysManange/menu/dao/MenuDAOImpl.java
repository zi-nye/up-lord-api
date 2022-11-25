package uplord.uplordapi.sysManange.menu.dao;

import org.apache.ibatis.session.SqlSession;
import uplord.uplordapi.sysManange.menu.dto.MenuDto;

import java.util.ArrayList;
import java.util.List;


public class MenuDAOImpl implements MenuDAO {
	private SqlSession sqlSession;

	@Override public List<MenuDto> findList(MenuDto param) throws Exception {

	}
}
