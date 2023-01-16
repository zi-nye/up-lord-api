package uplord.uplordapi.common.advice;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import uplord.uplordapi.common.message.MessageUtil;
import uplord.uplordapi.common.model.ErrorResponse;
import uplord.uplordapi.common.service.ErrorService;

import javax.validation.ConstraintViolationException;
import java.util.stream.Collectors;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class GeneralExceptionAdvice {
    
    private final ErrorService errorService;
    
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> httpClientErrorExceptionHandler(HttpClientErrorException e) {
        return errorService.record(e).response(e.getStatusText(), e.getStatusCode());
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> IllegalArgumentException(IllegalArgumentException e) {
        return errorService.record(e).response(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> NullPointerException(NullPointerException e) {
        return errorService.record(e).response(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> httpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        String message = MessageUtil.getMessage("http.error.notAllowMethod");
        return errorService.record(e).response(message, HttpStatus.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> methodArgumentNotValidException(MethodArgumentNotValidException e) {
        String message = e.getBindingResult().getFieldErrors().stream()
                .map(fieldError -> "" + fieldError.getField() +"" + MessageUtil.getMessage("common.is") + " " + fieldError.getDefaultMessage() + ".")
                .collect(Collectors.joining(", "));
        return errorService.record(e).response(message, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> constraintViolationException(ConstraintViolationException e) {
        return errorService.record(e).response(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> exceptionHandler(Exception e) {
        String message = MessageUtil.getMessage("error.default");
        return errorService.record(e).response(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}