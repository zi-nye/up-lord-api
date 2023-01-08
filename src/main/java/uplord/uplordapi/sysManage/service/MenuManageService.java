package uplord.uplordapi.sysManage.service;

import uplord.uplordapi.dto.MenuDTO;

import java.util.List;

public interface MenuManageService {

    List<MenuDTO> findList(MenuDTO param) throws Exception;

    void updateMenu(MenuDTO param) throws Exception;

    boolean updateValidationCheck(MenuDTO param) throws Exception;
}
