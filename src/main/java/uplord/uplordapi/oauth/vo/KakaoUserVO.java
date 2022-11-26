package uplord.uplordapi.oauth.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// 필요한 것만 해놓음
// TODO restTemplate HttpConverter로 camelCase로 변경할 수 있도록 구현해야 함 - 다른 이슈로 스킵중
@Getter
@Setter
@ToString
public class KakaoUserVO {
    Long id;
    String connected_at;
    KaKaoProperties properties;
    KakaoAccount kakao_account;
}

