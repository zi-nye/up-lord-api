package uplord.uplordapi.dto;

import lombok.Getter;
import lombok.Setter;
import uplord.uplordapi.common.domain.UpdateDetect;

@Getter
@Setter
public class ComboDTO {
    private String value;
    private String label;
    private String level;
}
