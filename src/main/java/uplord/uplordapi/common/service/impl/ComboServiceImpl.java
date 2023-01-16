package uplord.uplordapi.common.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uplord.uplordapi.common.dao.ComboDAO;
import uplord.uplordapi.common.service.ComboService;
import uplord.uplordapi.dto.ComboDTO;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ComboServiceImpl implements ComboService {

    private final ComboDAO dao;

    @Override
    public List<ComboDTO> getUserList() {
        return dao.getUserList();
    }

    @Override
    public List<ComboDTO> getAuthList() {
        return dao.getAuthList();
    }

    @Override
    public List<ComboDTO> getAllMenuList() {
        return dao.getAllMenuList();
    }

    @Override
    public List<ComboDTO> getUpperMenuList() {
        return dao.getUpperMenuList();
    }

    @Override
    public List<ComboDTO> getLowerMenuList() {
        return dao.getLowerMenuList();
    }

    @Override
    public List<ComboDTO> getCellList() {
        return dao.getCellList();
    }

    @Override
    public List<ComboDTO> getCellListByLevel(ComboDTO param) {
        return dao.getCellListByLevel(param);
    }

    @Override
    public List<ComboDTO> getCommonCode(ComboDTO param) {
        return dao.getCommonCode(param);
    }
}
