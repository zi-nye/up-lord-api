package uplord.uplordapi.oauth.service;

import uplord.uplordapi.oauth.domain.DecodedToken;
import uplord.uplordapi.oauth.domain.Token;

import java.util.Map;

public interface TokenProvider {
    Token generateAccessToken(Map<String, String> customClaims);

    Token generateRefreshToken(Map<String, String> customClaims);

    boolean verify(String jsw);

    DecodedToken decode(String jsw);
}
