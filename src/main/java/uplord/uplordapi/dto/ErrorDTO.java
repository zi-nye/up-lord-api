package uplord.uplordapi.dto;

import lombok.Builder;
import lombok.Getter;
import org.apache.commons.lang3.exception.ExceptionUtils;

import javax.servlet.http.HttpServletRequest;
@Getter
@Builder
public class ErrorDTO {
    private Long errorlogId;
    private String url;
    private String exception;
    private String message;
    private String stackTrace;

    public static ErrorDTO of(Long id, HttpServletRequest request, Exception e) {
        return ErrorDTO.builder()
                .errorlogId(id)
                .url(request.getRequestURI())
                .exception(e.getClass().getSimpleName())
                .message(getErrorMessage(e))
                .stackTrace(getErrorStackTrace(e))
                .build();
    }

    private static String getErrorMessage(Exception e) {
        String message = e.getMessage();
        if (message == null) {
            return null;
        }
        return message.length() > 3000 ? message.substring(0, 3000) : message;
    }

    private static String getErrorStackTrace(Exception e) {
        String stackTrace = ExceptionUtils.getStackTrace(e);
        return stackTrace.length() > 3000 ? stackTrace.substring(0, 3000) : stackTrace;
    }
}
