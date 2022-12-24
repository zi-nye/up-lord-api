package uplord.uplordapi.sysManage.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import uplord.uplordapi.dto.CellDTO;

import java.util.List;

@Mapper
@Repository
public interface CellManageDAO {
    List<CellDTO> findList(CellDTO param);

    int create(CellDTO param);

    int update(CellDTO param);
}
