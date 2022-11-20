package uplord.uplordapi.oauth.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import uplord.uplordapi.oauth.domain.TokenStrategyProperty;
import uplord.uplordapi.oauth.properties.domain.AuthStrategyProperty;
import uplord.uplordapi.oauth.properties.domain.ExpireProperty;
import uplord.uplordapi.oauth.properties.domain.TokenProperty;

@ConstructorBinding
@ConfigurationProperties(prefix = "auth")
public class AuthProperties {
    private final AuthStrategyProperty strategy;
    private final TokenProperties token;

    public AuthProperties(AuthStrategyProperty strategy, TokenProperties token) {
        this.strategy = strategy == null ? AuthStrategyProperty.TOKEN : strategy;
        this.token = token == null ? getDefaultToken() : token;
    }

    private TokenProperties getDefaultToken() {
        return new TokenProperties(null, null, null, null, null, null);
    }

    public AuthStrategyProperty getAuthStrategy() {
        return strategy;
    }

    public TokenProperties getToken() {
        return token;
    }

    public String getSecret() {
        return getToken().getSecret();
    }

    public String getIssuer() {
        return getToken().getIssuer();
    }

    public CookieProperties getCookie() {
        return getToken().getCookie();
    }

    public TokenStrategyProperty getTokenStrategy() {
        return getToken().getStrategy();
    }

    public TokenProperty getAccessToken() {
        return getToken().getAccessToken();
    }

    public ExpireProperty getAccessTokenExpire() {
        return getAccessToken().getExpire();
    }

    public TokenProperty getRefreshToken() {
        return getToken().getRefreshToken();
    }

    public ExpireProperty getRefreshTokenExpire() {
        return getRefreshToken().getExpire();
    }

    public Long getTokenSessionMaxInactiveTime() {
        return getRefreshTokenExpire().getMaxAge();
    }
}