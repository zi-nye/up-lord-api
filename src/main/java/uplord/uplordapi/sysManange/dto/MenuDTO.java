
package uplord.uplordapi.sysManange.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MenuDTO {
	private String menuCd;
	private String hirMenuCd;
	private String menuUrl;
	private String menuNm;
	private String menuOrd;
	private String menuDesc;
	private String useYn;
}
