package uplord.uplordapi.sysManange.service;

import uplord.uplordapi.sysManange.dto.MenuDTO;

import java.util.List;

public interface MenuService {
	List<MenuDTO> findList(MenuDTO param) throws Exception;
}
