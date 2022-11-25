package uplord.uplordapi.sysManange.menu.service;

import uplord.uplordapi.sysManange.menu.dto.MenuDto;

import java.util.List;

public interface MenuService {
	List<MenuDto> findList(MenuDto param);
}
