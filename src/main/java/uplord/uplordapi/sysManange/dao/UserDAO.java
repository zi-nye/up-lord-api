package uplord.uplordapi.sysManange.dao;

import uplord.uplordapi.sysManange.dto.UserDTO;

import java.util.List;

public interface UserDAO {
    List<UserDTO> findList(UserDTO param);

    void update(UserDTO param);
}
