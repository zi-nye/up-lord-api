package uplord.uplordapi.common.advice;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import uplord.uplordapi.auth.exception.UnauthenticatedAccessException;
import uplord.uplordapi.auth.exception.UnauthenticatedException;
import uplord.uplordapi.common.model.ErrorResponse;
import uplord.uplordapi.common.service.ErrorService;

@RestControllerAdvice
@RequiredArgsConstructor
public class AuthenticationExceptionAdvice {

    private final ErrorService errorService;

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> unauthenticatedExceptionHandler(UnauthenticatedException e) {
        return errorService.record(e).response(e.getMessage(), e.getStatus());
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> unauthenticatedAccessExceptionHandler(UnauthenticatedAccessException e) {
        return errorService.record(e).response(e.getMessage(), e.getStatus());
    }

}