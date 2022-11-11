package uplord.uplordapi.sysManange.service;

import uplord.uplordapi.sysManange.vo.AuthVO;

import java.util.List;

public interface AuthService {
    List<AuthVO> findAllAthList(AuthVO param);

    void create(AuthVO param);

    void update(AuthVO param);

    void createAthGp(AuthVO param);

    void deleteAthGp(AuthVO param);

    List<AuthVO> findNotAthGpList(AuthVO param);

    List<AuthVO> findAthGpList(AuthVO param);
}
