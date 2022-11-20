package uplord.uplordapi.oauth.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import uplord.uplordapi.oauth.properties.domain.ExpireProperty;
import uplord.uplordapi.oauth.properties.domain.TokenProperty;

@ConstructorBinding
@ConfigurationProperties(prefix = "auth.token.refresh-token")
public class RefreshTokenProperties extends TokenProperty {

    public RefreshTokenProperties(ExpireProperty expire) {
        super(expire);
    }

    @Override
    public String getName() {
        return "refreshToken";
    }

    @Override
    protected RefreshTokenExpireProperties getDefaultExpire() {
        return new RefreshTokenExpireProperties(null, 1L, null, null);
    }
}