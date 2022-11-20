package uplord.uplordapi.oauth.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import uplord.uplordapi.common.domain.TokenClaims;
import uplord.uplordapi.oauth.domain.Claims;
import uplord.uplordapi.oauth.domain.DecodedToken;
import uplord.uplordapi.oauth.service.TokenProvider;
import uplord.uplordapi.oauth.session.TokenSession;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class JwtResolver {

    private final TokenProvider tokenProvider;

    public Claims getCustomClaims(String jwt) {
        DecodedToken decodedToken = Optional.ofNullable(tokenProvider.decode(jwt)).orElse(new DecodedToken());
        return decodedToken.getClaims();
    }

    public String getCustomClaim(String jwt, String claimName) {
        DecodedToken decodedToken = Optional.ofNullable(tokenProvider.decode(jwt)).orElse(new DecodedToken());
        return Optional.ofNullable(decodedToken.getClaims()).orElse(new Claims()).get(claimName);
    }

    public String getUsername(String jwt) {
        return getCustomClaim(jwt, TokenSession.SESSION_KEY_IN_CLAIMS);
    }

    public String getUserId(String jwt) {
        return getCustomClaim(jwt, TokenClaims.CLAIM_NAME_USER_ID);
    }

    public String getCellCd(String jwt) {
        return getCustomClaim(jwt, TokenClaims.CLAIM_NAME_DPT_CODE);
    }

    public String getUserNm(String jwt) {
        return getCustomClaim(jwt, TokenClaims.CLAIM_NAME_USER_NM);
    }

    public boolean isExpiresAtInfinitely(String jwt) {
        DecodedToken decodedToken = Optional.ofNullable(tokenProvider.decode(jwt)).orElse(new DecodedToken());
        return decodedToken.getJwt() != null && decodedToken.getExpiresAt() == null;
    }

}