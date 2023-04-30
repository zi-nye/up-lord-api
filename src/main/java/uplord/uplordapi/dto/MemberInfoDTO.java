package uplord.uplordapi.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class MemberInfoDTO {
private Integer memberIdx;
private String memberName;
private Integer nthYear;
private String cellName;
private String gender;
private String memberBirth;
private Character useYn;
private Integer createdUid;
private LocalDateTime createdAt;
private String createdIp;
private Integer updatedUid;
private LocalDateTime updatedAt;
private String updatedIp;
}
