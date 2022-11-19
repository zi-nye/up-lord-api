package uplord.uplordapi.sysManange.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import uplord.uplordapi.sysManange.dto.AuthDTO;

import java.util.List;

@Mapper
@Repository
public interface AuthDAO {

    List<AuthDTO> findAuthList(AuthDTO param);

    int update(AuthDTO param);

    int create(AuthDTO param);

    int deleteAthGp(AuthDTO param);

    int createAthGp(AuthDTO param);

    List<AuthDTO> findNotAthGpList(AuthDTO param);

    List<AuthDTO> findAthGpList(AuthDTO param);
}
