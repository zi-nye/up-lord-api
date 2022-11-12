package uplord.uplordapi.sysManange.menu.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uplord.uplordapi.sysManange.menu.dao.MenuDAO;
import uplord.uplordapi.sysManange.menu.service.MenuService;
import uplord.uplordapi.sysManange.menu.vo.MenuVo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService {

	private MenuDAO dao;

	@Override public List<MenuVo> findList(MenuVo param) {
		return dao.findList(param);
	}
}
