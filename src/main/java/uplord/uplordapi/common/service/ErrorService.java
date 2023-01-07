package uplord.uplordapi.common.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uplord.uplordapi.auth.service.impl.HttpHelper;
import uplord.uplordapi.common.dao.ErrorDAO;
import uplord.uplordapi.common.model.ErrorResponse;
import uplord.uplordapi.dto.ErrorDTO;

import javax.servlet.http.HttpServletRequest;

@Service
@RequiredArgsConstructor
public class ErrorService {

    private final ErrorDAO errorDao;

    public ErrorService record(Exception e) {
        saveErrorLog(e);
        return this;
    }

    public ResponseEntity<ErrorResponse> response(String message, HttpStatus httpStatus) {
        return new ResponseEntity<>(new ErrorResponse(message), httpStatus);
    }

    private synchronized void saveErrorLog(Exception e) {
        Long errorlogId = errorDao.nextIdx();
        ErrorDTO param = ErrorDTO.of(errorlogId, getRequest(), e);
        errorDao.create(param);
    }

    private HttpServletRequest getRequest() {
        return HttpHelper.getHttpServletRequest();
    }

}