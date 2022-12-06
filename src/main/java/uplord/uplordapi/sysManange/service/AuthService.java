package uplord.uplordapi.sysManange.service;

import uplord.uplordapi.dto.AuthDTO;

import java.util.List;

public interface AuthService {
    List<AuthDTO> findAllAthList(AuthDTO param);

    void create(AuthDTO param);

    void update(AuthDTO param);

    void createAthGp(AuthDTO param);

    void deleteAthGp(AuthDTO param);

    List<AuthDTO> findNotAthGpList(AuthDTO param);

    List<AuthDTO> findAthGpList(AuthDTO param);
}
