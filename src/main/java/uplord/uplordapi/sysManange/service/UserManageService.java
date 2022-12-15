package uplord.uplordapi.sysManange.service;

import uplord.uplordapi.dto.UserDTO;

import java.util.List;

public interface UserManageService {

    List<UserDTO> findList(UserDTO param);

    void update(UserDTO param);
}
