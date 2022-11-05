package uplord.uplordapi.sysManange.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import uplord.uplordapi.sysManange.vo.CellVO;

import java.util.List;

@Mapper
@Repository
public interface CellDAO {
    List<CellVO> findList(CellVO param);
}
