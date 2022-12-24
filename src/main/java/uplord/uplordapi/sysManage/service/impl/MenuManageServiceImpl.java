package uplord.uplordapi.sysManage.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uplord.uplordapi.sysManage.service.MenuManageService;
import uplord.uplordapi.dto.MenuDTO;

import java.util.List;

@Service @RequiredArgsConstructor public class MenuManageServiceImpl implements MenuManageService {
	private final uplord.uplordapi.sysManage.dao.MenuManageDAO dao;

	@Override public List<MenuDTO> findList(MenuDTO param) throws Exception {
		return dao.findList(param);
	}
}
