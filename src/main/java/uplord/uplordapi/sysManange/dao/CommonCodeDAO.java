package uplord.uplordapi.sysManange.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import uplord.uplordapi.sysManange.vo.CommonCodeVO;

import java.util.List;

@Mapper
@Repository
public interface CommonCodeDAO {
    int create(CommonCodeVO param);

    int update(CommonCodeVO param);

    List<CommonCodeVO> findList(CommonCodeVO param);
}
