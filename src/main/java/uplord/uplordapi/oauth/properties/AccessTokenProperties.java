package uplord.uplordapi.oauth.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import uplord.uplordapi.oauth.properties.domain.TokenProperty;

@ConstructorBinding
//@ConfigurationProperties(prefix = "auth.token.access-token")
public class AccessTokenProperties extends TokenProperty {

    public AccessTokenProperties(AccessTokenExpireProperties expire) {
        super(expire);
    }

    @Override
    public String getName() {
        return "accessToken";
    }

    @Override
    protected AccessTokenExpireProperties getDefaultExpire() {
        return new AccessTokenExpireProperties(null, null, 30L, null);
    }
}