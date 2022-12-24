package uplord.uplordapi.sysManage.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import uplord.uplordapi.dto.UserDTO;

import java.util.List;

@Mapper
@Repository
public interface UserManageDAO {
    List<UserDTO> findList(UserDTO param);

    void update(UserDTO param);
}
