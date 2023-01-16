
package uplord.uplordapi.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import uplord.uplordapi.common.domain.UpdateDetect;

@Getter
@Setter
@ToString
public class MenuDTO implements UpdateDetect {
	private String menuCd;
	private String hirMenuCd;
	private String menuUrl;
	private String menuNm;
	private String menuOrd;
	private String menuDesc;
	private String useYn;
}
