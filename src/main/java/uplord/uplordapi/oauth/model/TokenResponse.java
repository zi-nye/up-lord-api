package uplord.uplordapi.oauth.model;

import lombok.Builder;
import lombok.Getter;
import uplord.uplordapi.oauth.domain.Claims;

@Getter
@Builder
public class TokenResponse {
    private String accessToken;
    private String refreshToken;
    private Claims claims;
}