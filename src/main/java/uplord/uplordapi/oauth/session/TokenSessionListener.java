package uplord.uplordapi.oauth.session;

import uplord.uplordapi.oauth.properties.AuthProperties;
import uplord.uplordapi.oauth.service.TokenAuthenticationConfigurer;
import uplord.uplordapi.oauth.service.impl.JwtResolver;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.Enumeration;

public class TokenSessionListener implements HttpSessionListener {

    private final Long sessionMaxInactiveTime;
    private final JwtResolver jwtResolver;
    private final TokenAuthenticationConfigurer authenticationConfigurer;

    public TokenSessionListener(AuthProperties properties, JwtResolver jwtResolver, TokenAuthenticationConfigurer authenticationConfigurer) {
        this.sessionMaxInactiveTime = properties.getTokenSessionMaxInactiveTime();
        this.jwtResolver = jwtResolver;
        this.authenticationConfigurer = authenticationConfigurer;
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession session = se.getSession();

        if (!isTokenSession(session)) {
            return;
        }

        Enumeration<String> attributes = session.getAttributeNames();

        while (attributes.hasMoreElements()) {
            String attribute = attributes.nextElement();

            if (isAttributeNameOfUsernameClaims(attribute)) {
                String jwt = String.valueOf(session.getAttribute(attribute));

                if (jwt == null) {
                    return;
                }

                String userId = jwtResolver.getUserId(jwt);
                authenticationConfigurer.onLogout(userId);
                return;
            }
        }
    }

    private boolean isTokenSession(HttpSession session) {
        return session != null && Integer.valueOf(session.getMaxInactiveInterval()).longValue() == sessionMaxInactiveTime;
    }

    private boolean isAttributeNameOfUsernameClaims(String attribute) {
        return attribute.contains(TokenSession.SESSION_KEY_SUFFIX);
    }
}