package uplord.uplordapi.sysManange.service;

import uplord.uplordapi.sysManange.vo.AuthVO;

import java.util.List;

public interface AuthService {
    List<AuthVO> findList(AuthVO param);

    void create(AuthVO param);

    void update(AuthVO param);
}
