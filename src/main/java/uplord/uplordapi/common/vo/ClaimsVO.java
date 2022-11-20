package uplord.uplordapi.common.vo;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ClaimsVO {

    private String userId;
    private String cellCd;
    private String userNm;
    private AuthorityVO authority;
    private boolean superUser;

}