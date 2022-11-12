package uplord.uplordapi.sysManange.service;

import uplord.uplordapi.sysManange.vo.MenuVo;

import java.util.List;

public interface MenuService {
	List<MenuVo> findList(MenuVo param);

}
