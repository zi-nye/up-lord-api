package uplord.uplordapi.common.service;

import uplord.uplordapi.dto.ComboDTO;
import uplord.uplordapi.dto.UserDTO;

import java.util.List;

public interface ComboService {
    List<ComboDTO> getUserList();

    List<ComboDTO> getAuthList();

    List<ComboDTO> getAllMenuList();

    List<ComboDTO> getUpperMenuList();

    List<ComboDTO> getLowerMenuList();

    List<ComboDTO> getCellList();

    List<ComboDTO> getCellListByLevel(ComboDTO param);

    List<ComboDTO> getCommonCode(ComboDTO param);
}
