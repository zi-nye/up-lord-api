package uplord.uplordapi.sysManage.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uplord.uplordapi.dto.UserDTO;
import uplord.uplordapi.sysManage.dao.UserManageDAO;
import uplord.uplordapi.sysManage.service.UserManageService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserManageServiceImpl implements UserManageService {

    private final UserManageDAO dao;

    @Override
    public List<UserDTO> findList(UserDTO param) {
        return dao.findList(param);
    }

    @Override
    public void update(UserDTO param) {
        dao.update(param);
    }
}
