package uplord.uplordapi.sysManage.service;

import uplord.uplordapi.dto.UserDTO;

import java.util.List;
import uplord.uplordapi.dto.UserUpdateResultDTO;

public interface UserManageService {

    List<UserDTO> findList();


    // 테스트 하기 좋은 코드로 리팩토링했습니다.
    // 업데이트된 id 들과 useYn 결과를 모두 반환
    List<UserUpdateResultDTO> update(List<UserDTO> userList) throws Exception;
}
