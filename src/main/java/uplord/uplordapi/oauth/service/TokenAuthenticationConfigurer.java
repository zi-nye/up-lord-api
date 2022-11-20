package uplord.uplordapi.oauth.service;

import org.apache.commons.lang3.NotImplementedException;
import uplord.uplordapi.oauth.domain.AccountAuthentication;
import uplord.uplordapi.oauth.domain.Claims;

public interface TokenAuthenticationConfigurer {
    default boolean authenticate(AccountAuthentication authentication) {
        return true;
    };

    default Claims createCustomClaimsOnAuthenticateSuccess(AccountAuthentication authentication) {
        throw new NotImplementedException("[createCustomClaimsOnAuthenticateSuccess] Must be implement TokenAuthenticationConfigurer.");
    };

    default void onLogin(AccountAuthentication authentication) {};

    default void onLoginFailed(AccountAuthentication authentication) {};

    default void onLogout(String username) {};
}
