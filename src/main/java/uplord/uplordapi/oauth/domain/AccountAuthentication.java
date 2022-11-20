package uplord.uplordapi.oauth.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AccountAuthentication {
    String username;
    String password;
}