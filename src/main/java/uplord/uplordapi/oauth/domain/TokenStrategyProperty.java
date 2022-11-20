package uplord.uplordapi.oauth.domain;

public enum TokenStrategyProperty {
    COOKIE,
    HEADER;

    public boolean equals(String value) {
        return value != null && this.name().equals(value.toUpperCase());
    }
}