package uplord.uplordapi.dto;

import lombok.Getter;
import lombok.Setter;
import uplord.uplordapi.common.domain.UpdateDetect;

@Getter
@Setter
public class CellDTO implements UpdateDetect {
    private String cellCd;
    private String cellLeaderUid;
    private String hirCellCd;
    private String cellNm;
    private String cellFeeIdx;
    private String cellGroupPlace;
    private String cellConcept;
    private String cellNote;
    private String cellYear;
    private String useYn;
    private String createdUid;
    private String createdAt;
    private String createdIp;
    private String updatedUid;
    private String updatedAt;
    private String updatedIp;

    private String cellLeaderNm;
}
