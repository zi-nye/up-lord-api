package uplord.uplordapi.dto;

import lombok.Getter;
import lombok.Setter;
import uplord.uplordapi.common.domain.UpdateDetect;

@Getter
@Setter
public class CommonDetailCodeDTO implements UpdateDetect {
    private String hirCd;
    private String dtlCd;
    private String dtlCdNm;
    private String dtlCdEn;
    private String dtlCdAbbr;
    private String dtlCdOrd;
    private String useYn;
    private String dtlCdRmk;
    private String createdUid;
    private String createdAt;
    private String createdIp;
    private String updatedUid;
    private String updatedAt;
    private String updatedIp;
}
