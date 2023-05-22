package uplord.uplordapi.domain.attendance.exception;

public class RegisterDupException extends RuntimeException {
    public RegisterDupException() {
    }

    public RegisterDupException(String message) {
        super(message);
    }

    public RegisterDupException(String message, Throwable cause) {
        super(message, cause);
    }

    public RegisterDupException(Throwable cause) {
        super(cause);
    }

    public RegisterDupException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
