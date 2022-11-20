package uplord.uplordapi.oauth.service;

import org.springframework.http.HttpHeaders;
import uplord.uplordapi.oauth.domain.Token;
import uplord.uplordapi.oauth.domain.TokenAuthentication;
import uplord.uplordapi.oauth.model.TokenResponse;

public interface TokenHttpResolver {

    Token getAccessToken();

    HttpHeaders makeResponseHeader(TokenAuthentication authentication);

    TokenResponse makeResponseBody(TokenAuthentication authentication);

}