package uplord.uplordapi.auth.exception;

import org.springframework.http.HttpStatus;

public class UnauthenticatedAccessException extends AuthBaseException {

    public UnauthenticatedAccessException() {
        this(HttpStatus.FORBIDDEN, "auth.error.unauthorizedAccess");
    }

    public UnauthenticatedAccessException(String messageCode) {
        this(HttpStatus.FORBIDDEN, messageCode);
    }

    public UnauthenticatedAccessException(HttpStatus status, String messageCode) {
        super(status, messageCode);
    }
}
