package uplord.uplordapi.common.domain;

import com.google.gson.Gson;
import uplord.uplordapi.common.vo.ClaimsVO;
import uplord.uplordapi.oauth.domain.Claims;

public class TokenClaims {

    public static final String CLAIM_NAME_USER_ID = "userId";
    public static final String CLAIM_NAME_DPT_CODE = "cellCd";
    public static final String CLAIM_NAME_USER_NM = "userNm";
    public static final String CLAIM_NAME_AUTHORITY = "authority";
    public static final String CLAIM_NAME_SUPER_USER = "isSuperUser";

    public Claims create(ClaimsVO claimsVO) {
        Claims claims = new Claims();
        claims.put(CLAIM_NAME_USER_ID, claimsVO.getUserId());
        claims.put(CLAIM_NAME_DPT_CODE, claimsVO.getCellCd());
        claims.put(CLAIM_NAME_USER_NM, claimsVO.getUserNm());
        claims.put(CLAIM_NAME_AUTHORITY, toJson(claimsVO.getAuthority()));
        claims.put(CLAIM_NAME_SUPER_USER, String.valueOf(claimsVO.isSuperUser()));
        return claims;
    }

    private String toJson(Object arg) {
        return new Gson().toJson(arg);
    }

}