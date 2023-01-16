package uplord.uplordapi.enums;

public enum CommandType {
    NONE,
    INSERT,
    UPDATE,
    DELETE;

    private CommandType() {
    }

    public String getValue() {
        return this.name();
    }

    public boolean isNotNone() {
        return this != NONE;
    }
}