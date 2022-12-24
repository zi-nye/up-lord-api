package uplord.uplordapi.sysManage.enums;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum CommonCodeDiv {
    SYSTEM_CODE_DIV("S"),
    USER_CODE_DIV("U");

    private final String code;

    CommonCodeDiv(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    private static final Map<String, CommonCodeDiv> BY_CODE =
            Stream.of(CommonCodeDiv.values()).collect(Collectors.toMap(CommonCodeDiv::getCode, Function.identity()));

    public static CommonCodeDiv valueOfCode(String code) {
        return BY_CODE.get(code);
    }
}
