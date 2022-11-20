package uplord.uplordapi.oauth.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Conditional;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Component;
import uplord.uplordapi.oauth.condition.CookieTokenStrategyCondition;
import uplord.uplordapi.oauth.domain.Token;
import uplord.uplordapi.oauth.domain.TokenAuthentication;
import uplord.uplordapi.oauth.model.TokenResponse;
import uplord.uplordapi.oauth.properties.AuthProperties;
import uplord.uplordapi.oauth.properties.CookieProperties;
import uplord.uplordapi.oauth.properties.domain.TokenProperty;
import uplord.uplordapi.oauth.service.TokenHttpResolver;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Optional;

@Component
@Conditional(CookieTokenStrategyCondition.class)
@RequiredArgsConstructor
public class CookieTokenHttpResolver implements TokenHttpResolver {

    private final AuthProperties properties;

    private String getAccessTokenName() {
        return properties.getAccessToken().getName();
    }

    @Override
    public Token getAccessToken() {
        return new Token(findTokenInCookies(getRequest().getCookies(), getAccessTokenName()));
    }

    private String findTokenInCookies(Cookie[] cookies, String cookieName) {
        return Arrays.stream(Optional.ofNullable(cookies).orElseGet(() -> new Cookie[0]))
                .filter(cookie -> cookieName.equals(cookie.getName()))
                .map(Cookie::getValue)
                .findAny()
                .orElse(null);
    }

    @Override
    public HttpHeaders makeResponseHeader(TokenAuthentication authentication) {
        HttpHeaders httpHeaders = new HttpHeaders();
        ResponseCookie accessTokenCookie = makeResponseCookie(properties.getAccessToken(), authentication.getAccessToken());
        httpHeaders.add(HttpHeaders.SET_COOKIE, accessTokenCookie.toString());
        return httpHeaders;
    }

    private ResponseCookie makeResponseCookie(TokenProperty tokenProperty, Token token) {
        CookieProperties cookieProperties = properties.getCookie();
        return ResponseCookie
                .from(getAccessTokenName(), token.getJwt())
                .maxAge(tokenProperty.getExpire().getMaxAge())
                .secure(cookieProperties.isSecure())
                .sameSite(cookieProperties.getSameSite().getValue())
                .httpOnly(cookieProperties.isHttpOnly())
                .path(cookieProperties.getPath())
                .build();
    }

    @Override
    public TokenResponse makeResponseBody(TokenAuthentication authentication) {
        return TokenResponse.builder()
                .refreshToken(authentication.getRefreshToken().getJwt())
                .claims(authentication.getClaims())
                .build();
    }

    private HttpServletRequest getRequest() {
        return HttpHelper.getHttpServletRequest();
    }

}