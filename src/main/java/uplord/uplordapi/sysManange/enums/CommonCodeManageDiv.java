package uplord.uplordapi.sysManange.enums;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum CommonCodeManageDiv {
    SYSTEM_CODE_DIV("S"),
    USER_CODE_DIV("U");

    private final String code;

    CommonCodeManageDiv(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    private static final Map<String, CommonCodeManageDiv> BY_CODE =
            Stream.of(CommonCodeManageDiv.values()).collect(Collectors.toMap(CommonCodeManageDiv::getCode, Function.identity()));

    public static CommonCodeManageDiv valueOfCode(String code) {
        return BY_CODE.get(code);
    }
}
