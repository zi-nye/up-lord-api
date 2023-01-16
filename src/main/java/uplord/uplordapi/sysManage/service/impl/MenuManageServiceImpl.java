package uplord.uplordapi.sysManage.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uplord.uplordapi.sysManage.dao.MenuManageDAO;
import uplord.uplordapi.sysManage.service.MenuManageService;
import uplord.uplordapi.dto.MenuDTO;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuManageServiceImpl implements MenuManageService {

    private final MenuManageDAO dao;

    @Override
    public List<MenuDTO> findList(MenuDTO param) throws Exception {
        return dao.findList(param);
    }

    @Override
    public void updateMenu(MenuDTO param) throws Exception {
        dao.updateMenu(param);
    }

    @Override
    public boolean updateValidationCheck(MenuDTO param) throws Exception {
        // todo: 나머지 유효성 검사할 것들 > param.getMenuOrd();
        return menuCodeCheck(param.getMenuCd()) == 1 || menuNameCheck(param.getMenuNm()) == 0
                || menuUrlCheck(param.getMenuUrl()) == 0;
    }

    private int menuCodeCheck(String menuCD) throws Exception {
        int result = dao.menuCodeCheck(menuCD);
        if (result != 1) {
            throw new Exception("Menu Update Error : Invalid menu code");
        }
        return result;
    }

    private int menuNameCheck(String menuNM) throws Exception {
        int result = dao.menuCodeCheck(menuNM);
        if (result != 0) {
            throw new Exception("Menu Update Error : Duplicate menu name");
        }
        return result;
    }

    private int menuUrlCheck(String menuURL) throws Exception {
        int result = dao.menuCodeCheck(menuURL);
        if (result != 0) {
            throw new Exception("Menu Update Error : Duplicate menu url");
        }
        return result;
    }
}
