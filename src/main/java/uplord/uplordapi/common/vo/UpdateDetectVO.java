package uplord.uplordapi.common.vo;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UpdateDetectVO {
    private String owner;
    private String tableName;
    private String conditionClause;

    private String crtIp;
    private String crtUid;
    private String udtIp;
    private String udtUid;
}
