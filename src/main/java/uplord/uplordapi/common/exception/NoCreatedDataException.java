package uplord.uplordapi.common.exception;

import org.springframework.http.HttpStatus;

public class NoCreatedDataException extends BaseException {

    public NoCreatedDataException() {
        this(HttpStatus.INTERNAL_SERVER_ERROR, "error.sql.noCreatedData");
    }

    public NoCreatedDataException(String messageCode) {
        this(HttpStatus.INTERNAL_SERVER_ERROR, messageCode);
    }

    public NoCreatedDataException(HttpStatus status, String messageCode) {
        super(status, messageCode);
    }

}