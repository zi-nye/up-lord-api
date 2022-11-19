package uplord.uplordapi.sysManange.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uplord.uplordapi.sysManange.dao.MenuDAO;
import uplord.uplordapi.sysManange.service.MenuService;
import uplord.uplordapi.sysManange.dto.MenuDTO;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService {

	private MenuDAO dao;

	@Override public List<MenuDTO> findList(MenuDTO param) {
		return dao.findList(param);
	}
}
