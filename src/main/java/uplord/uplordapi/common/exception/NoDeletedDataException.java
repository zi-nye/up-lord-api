package uplord.uplordapi.common.exception;

import org.springframework.http.HttpStatus;

public class NoDeletedDataException extends BaseException {

    public NoDeletedDataException() {
        this(HttpStatus.INTERNAL_SERVER_ERROR, "error.sql.noDeletedData");
    }

    public NoDeletedDataException(String messageCode) {
        this(HttpStatus.INTERNAL_SERVER_ERROR, messageCode);
    }

    public NoDeletedDataException(HttpStatus status, String messageCode) {
        super(status, messageCode);
    }

}