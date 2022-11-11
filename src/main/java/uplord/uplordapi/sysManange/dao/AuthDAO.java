package uplord.uplordapi.sysManange.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import uplord.uplordapi.sysManange.vo.AuthVO;

import java.util.List;

@Mapper
@Repository
public interface AuthDAO {

    List<AuthVO> findAuthList(AuthVO param);

    int update(AuthVO param);

    int create(AuthVO param);

    int deleteAthGp(AuthVO param);

    int createAthGp(AuthVO param);

    List<AuthVO> findNotAthGpList(AuthVO param);

    List<AuthVO> findAthGpList(AuthVO param);
}
