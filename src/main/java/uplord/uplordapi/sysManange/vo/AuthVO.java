package uplord.uplordapi.sysManange.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthVO {
    private String authCd;
    private String authNm;
    private String authDesc;
    private String ord;
    private String useYn;
    private String createdUid;
    private String createdAt;
    private String createdIp;
    private String updatedUid;
    private String updatedAt;
    private String updatedIp;
    private String menuCd;
}
