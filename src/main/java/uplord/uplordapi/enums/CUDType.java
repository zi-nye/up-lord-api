package uplord.uplordapi.enums;

public enum CUDType {
    C(CommandType.INSERT),
    U(CommandType.UPDATE),
    D(CommandType.DELETE);

    private final CommandType commandType;

    CUDType(CommandType commandType) {
        this.commandType = commandType;
    }

    public static CUDType of(CommandType commandType) {
        for (CUDType type : CUDType.values()) {
            if (type.commandType == commandType) {
                return type;
            }
        }
        return null;
    }
}