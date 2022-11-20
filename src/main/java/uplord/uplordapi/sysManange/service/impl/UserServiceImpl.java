package uplord.uplordapi.sysManange.service.impl;

import lombok.RequiredArgsConstructor;
import uplord.uplordapi.sysManange.dao.UserDAO;
import uplord.uplordapi.sysManange.dto.UserDTO;
import uplord.uplordapi.sysManange.service.UserService;

import java.util.List;

@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDAO dao;

    @Override
    public List<UserDTO> findList(UserDTO param) {
        return dao.findList(param);
    }

    @Override
    public void update(UserDTO param) {
        dao.update(param);
    }
}
