package uplord.uplordapi.oauth.properties;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import uplord.uplordapi.oauth.domain.TokenStrategyProperty;
import uplord.uplordapi.oauth.properties.domain.TokenProperty;

@Getter
@ConstructorBinding
@ConfigurationProperties(prefix = "auth.token")
public class TokenProperties {
    private final String defaultSecret = "secret-key";
    private final String defaultIssuer = "lims";
    private final String secret;
    private final String issuer;
    private final TokenProperty accessToken;
    private final TokenProperty refreshToken;
    private final CookieProperties cookie;
    private final TokenStrategyProperty strategy;

    public TokenProperties(String secret, String issuer, AccessTokenProperties accessToken, RefreshTokenProperties refreshToken, CookieProperties cookie, TokenStrategyProperty strategy) {
        this.secret = secret == null ? defaultSecret : secret;
        this.issuer = issuer == null ? defaultIssuer : issuer;
        this.accessToken = accessToken == null ? new AccessTokenProperties(null) : accessToken;
        this.refreshToken = refreshToken == null ? new RefreshTokenProperties(null) : refreshToken;
        this.cookie = cookie == null ? new CookieProperties(null, null, null, null) : cookie;
        this.strategy = strategy == null ? getDefaultStrategy() : strategy;
    }

    private TokenStrategyProperty getDefaultStrategy() {
        return TokenStrategyProperty.HEADER;
    }
}