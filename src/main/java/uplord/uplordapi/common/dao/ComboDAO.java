package uplord.uplordapi.common.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import uplord.uplordapi.dto.ComboDTO;

import java.util.List;

@Repository
@Mapper
public interface ComboDAO {
    List<ComboDTO> getUserList();

    List<ComboDTO> getAuthList();

    List<ComboDTO> getAllMenuList();

    List<ComboDTO> getUpperMenuList();

    List<ComboDTO> getLowerMenuList();

    List<ComboDTO> getCellList();

    List<ComboDTO> getCellListByLevel(ComboDTO param);

    List<ComboDTO> getCommonCode(ComboDTO param);
}
