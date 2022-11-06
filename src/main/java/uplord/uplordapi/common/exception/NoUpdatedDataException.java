package uplord.uplordapi.common.exception;

import org.springframework.http.HttpStatus;

public class NoUpdatedDataException extends BaseException {

    public NoUpdatedDataException() {
        this(HttpStatus.INTERNAL_SERVER_ERROR, "error.sql.noUpdatedData");
    }

    public NoUpdatedDataException(String messageCode) {
        this(HttpStatus.INTERNAL_SERVER_ERROR, messageCode);
    }

    public NoUpdatedDataException(HttpStatus status, String messageCode) {
        super(status, messageCode);
    }

}