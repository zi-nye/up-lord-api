package uplord.uplordapi.dto;

import lombok.Getter;
import lombok.Setter;
import uplord.uplordapi.common.domain.UpdateDetect;

import java.util.List;

@Getter
@Setter
public class AuthDTO implements UpdateDetect {
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

    private List<AuthDTO> addedRowItems;   // 추가된 데이터
    private List<AuthDTO> editedRowItems;  // 수정된 데이터
    private List<AuthDTO> removedRowItems; // 삭제된 데이터
}
