package uplord.uplordapi.sysManange.dto;

import lombok.Getter;
import lombok.Setter;
import uplord.uplordapi.common.domain.UpdateDetect;

@Getter
@Setter
public class UserDTO implements UpdateDetect {
    private String userId;
    private String userName;
    private String userEmail;
    private String password;
    private String userPhone;
    private String userBirth;
    private String userNickname;
    private String gender;
    private String snsType;
    private String snsId;
    private String authCd;
    private String cellCd;
    private String useYn;
}
