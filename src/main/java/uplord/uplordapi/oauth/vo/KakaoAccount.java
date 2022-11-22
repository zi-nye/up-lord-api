package uplord.uplordapi.oauth.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class KakaoAccount {
    Boolean has_email;
    String email;
    Boolean has_gender;
    String gender;
}
