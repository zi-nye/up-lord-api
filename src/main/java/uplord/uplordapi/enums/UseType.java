package uplord.uplordapi.enums;

public enum UseType {
    Y,
    N;

    public static UseType get(boolean isValid) {
        return isValid ? UseType.Y : UseType.N;
    }

}