package uplord.uplordapi.oauth.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import uplord.uplordapi.oauth.properties.domain.ExpireProperty;

@ConstructorBinding
@ConfigurationProperties(prefix = "auth.token.refresh-token.expire")
public class RefreshTokenExpireProperties extends ExpireProperty {

    public RefreshTokenExpireProperties(Long days, Long hours, Long minutes, Long seconds) {
        super(days, hours, minutes, seconds);
    }
}