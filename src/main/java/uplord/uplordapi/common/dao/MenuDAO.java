package uplord.uplordapi.common.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import uplord.uplordapi.dto.MenuDTO;

import java.util.List;
@Mapper
@Repository
public interface MenuDAO {

    List<MenuDTO> findUseMenus();
}
