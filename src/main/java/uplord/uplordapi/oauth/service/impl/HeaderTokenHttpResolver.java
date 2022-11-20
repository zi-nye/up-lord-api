package uplord.uplordapi.oauth.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Conditional;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import uplord.uplordapi.oauth.condition.DefaultOrHeaderTokenStrategyCondition;
import uplord.uplordapi.oauth.domain.Token;
import uplord.uplordapi.oauth.domain.TokenAuthentication;
import uplord.uplordapi.oauth.model.TokenResponse;
import uplord.uplordapi.oauth.service.TokenHttpResolver;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Component
@Slf4j
@Conditional(DefaultOrHeaderTokenStrategyCondition.class)
public class HeaderTokenHttpResolver implements TokenHttpResolver {

    @Override
    public Token getAccessToken() {
        String bearerToken = Optional.ofNullable(getRequest().getHeader("authorization")).orElse("");
        String jwt = bearerToken.replace("Bearer", "").trim();
        return new Token(jwt);
    }

    @Override
    public HttpHeaders makeResponseHeader(TokenAuthentication authentication) {
        return new HttpHeaders();
    }

    @Override
    public TokenResponse makeResponseBody(TokenAuthentication authentication) {
        return TokenResponse.builder()
                .accessToken(authentication.getAccessToken().getJwt())
                .refreshToken(authentication.getRefreshToken().getJwt())
                .claims(authentication.getClaims())
                .build();
    }

    private HttpServletRequest getRequest() {
        return HttpHelper.getHttpServletRequest();
    }

}