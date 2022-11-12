package uplord.uplordapi.oauth.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import uplord.uplordapi.oauth.vo.UserVO;

@Mapper
@Repository
public interface OauthDAO {
    void createUser(UserVO user);

    UserVO findUserByUserId(String userId);

    UserVO findUserBySnsId(String snsId);

}
