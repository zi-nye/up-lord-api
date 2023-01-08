package uplord.uplordapi.enums;

public enum LoginStatus {
    LOGIN("I"),
    LOGOUT("O"),
    FAIL("F");

    private final String code;

    LoginStatus(String code) {
        this.code = code;
    }

    public String getValue() {
        return code;
    }

}