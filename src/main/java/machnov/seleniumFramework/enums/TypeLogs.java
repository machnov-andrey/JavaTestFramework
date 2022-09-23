package machnov.seleniumFramework.enums;

public enum TypeLogs {
    DEBUG("DEBUG"),
    INFO("INFO"),
    WARN("WARN"),
    ERROR("ERROR"),
    FATAL("FATAL");

    private final String TYPE;

    TypeLogs(String type) {
        this.TYPE = type;
    }

    public String getLogType() {
        return TYPE;
    }
}
