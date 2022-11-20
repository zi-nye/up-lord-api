package uplord.uplordapi.common.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class AuthorityVO {

    private String athCd;
    private List<String> myMenus = new ArrayList<>();

}