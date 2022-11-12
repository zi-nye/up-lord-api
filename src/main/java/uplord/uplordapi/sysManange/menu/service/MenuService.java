package uplord.uplordapi.sysManange.menu.service;

import uplord.uplordapi.sysManange.menu.vo.MenuVo;

import java.util.List;

public interface MenuService {
	List<MenuVo> findList(MenuVo param);

}
