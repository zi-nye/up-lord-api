package uplord.uplordapi.sysManange.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import uplord.uplordapi.dto.UserDTO;

import java.util.List;

@Mapper
@Repository
public interface UserDAO {
    List<UserDTO> findList(UserDTO param);

    void update(UserDTO param);
}
