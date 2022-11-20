package uplord.uplordapi.oauth.properties;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import uplord.uplordapi.oauth.properties.domain.ExpireProperty;

@Getter
@ConstructorBinding
@ConfigurationProperties(prefix = "auth.token.access-token.expire")
public class AccessTokenExpireProperties extends ExpireProperty {

    public AccessTokenExpireProperties(Long days, Long hours, Long minutes, Long seconds) {
        super(days, hours, minutes, seconds);
    }
}