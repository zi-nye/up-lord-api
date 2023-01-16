package uplord.uplordapi.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UpdateDetectDTO {

    private String owner;
    private String tableName;
    private String conditionClause;

    private String createdUid;
    private String createdAt;
    private String createdIp;
    private String updatedUid;
    private String updatedAt;
    private String updatedIp;
}