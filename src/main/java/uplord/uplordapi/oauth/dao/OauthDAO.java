package uplord.uplordapi.oauth.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import uplord.uplordapi.dto.UserDTO;

@Mapper
@Repository
public interface OauthDAO {
    void createUser(UserDTO user);

    UserDTO findUserByUserId(String userId);

    UserDTO findUserBySnsId(String snsId);

}
