package uplord.uplordapi.common.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import uplord.uplordapi.common.message.MessageUtil;

@Getter
public class BaseException extends RuntimeException {
    private final HttpStatus status;
    private final String messageCode;
    private final String message;

    public BaseException(HttpStatus status, String messageCode) {
        this.status = status;
        this.messageCode = messageCode;
        this.message = MessageUtil.getMessage(messageCode);
    }
}