package uplord.uplordapi.common.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uplord.uplordapi.common.dao.MenuDAO;
import uplord.uplordapi.common.service.MenuService;
import uplord.uplordapi.dto.MenuDTO;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService {
    private final MenuDAO dao;

    @Override
    public List<MenuDTO> getMenus() {
        return dao.findUseMenus();
    }
}
