package uplord.uplordapi.oauth.domain;

import lombok.Getter;

@Getter
public class TokenAuthentication {
    private final Token accessToken;
    private final Token refreshToken;
    private final Claims claims;

    public TokenAuthentication(Token accessToken, Token refreshToken, Claims claims) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.claims = claims;
    }
}