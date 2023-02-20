package uplord.uplordapi.sysManage.service.impl;

import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uplord.uplordapi.dto.UserDTO;
import uplord.uplordapi.dto.UserUpdateResultDTO;
import uplord.uplordapi.sysManage.dao.UserManageDAO;
import uplord.uplordapi.sysManage.service.UserManageService;

@Service
@RequiredArgsConstructor
public class UserManageServiceImpl implements UserManageService {

    private final UserManageDAO dao;

    @Override
    public List<UserDTO> findList() {
        return dao.findList();
    }

    // 테스트 하기 좋은 코드로 리팩토링했습니다.
    // 업데이트된 id 들을 모두 반환
    @Override
    public List<UserUpdateResultDTO> update(List<UserDTO> userList) throws Exception {
        try {
            userList.forEach(dao::update);
        } catch (Exception e) {
            throw new Exception("유저 권한 업데이트 오류");
        }

        List<UserUpdateResultDTO> updateResults = new ArrayList<>();
        userList.forEach(user -> updateResults.add(UserUpdateResultDTO.builder()
                                                      .userId(user.getUserId())
                                                      .useYn(user.getUseYn())
                                                      .build()));
        return updateResults;
    }
}
