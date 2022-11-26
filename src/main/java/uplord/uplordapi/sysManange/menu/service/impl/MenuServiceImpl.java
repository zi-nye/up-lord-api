package uplord.uplordapi.sysManange.menu.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uplord.uplordapi.sysManange.menu.dao.MenuDAO;
import uplord.uplordapi.sysManange.menu.service.MenuService;
import uplord.uplordapi.sysManange.menu.dto.MenuDto;

import java.util.List;

@Service @RequiredArgsConstructor public class MenuServiceImpl implements MenuService {
	private final MenuDAO menuDAO;

	@Override public List<MenuDto> findList(MenuDto param) throws Exception {
		return menuDAO.findList(param);
	}
}
