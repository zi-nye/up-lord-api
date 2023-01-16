package uplord.uplordapi.dto;

import lombok.Getter;
import lombok.Setter;
import uplord.uplordapi.common.domain.UpdateDetect;

@Getter
@Setter
public class CommonCodeDTO implements UpdateDetect {
    private String hirCd;
    private String cdDivSu;
    private String hirCdNm;
    private String hirCdOrd;
    private String hirCdDesc;
    private String useYn;
    private String createdUid;
    private String createdAt;
    private String createdIp;
    private String updatedUid;
    private String updatedAt;
    private String updatedIp;
}
