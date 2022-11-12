package uplord.uplordapi.util.httpClient;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestClientException;
import uplord.uplordapi.util.ThreadUtil;
import uplord.uplordapi.util.httpClient.executor.HttpRestExecutor;

@Slf4j
public class HttpRestTemplate {

    public <T> T request(HttpRestExecutor<T> executor) {
        ResponseEntity<T> responseEntity = executor.execute();
        assertSuccessRequest(responseEntity);
        return responseEntity.getBody();
    }

    private void assertSuccessRequest(ResponseEntity<?> responseEntity) {
        HttpStatus status = responseEntity.getStatusCode();

        if (isSuccess(status)) {
            log.info("[{}] Success HttpRestTemplate Request. http status: {}.", ThreadUtil.getCurrentMethodName(), status);
            return;
        }

        log.error("[{}] Failed HttpResTemplate Request. http status: {}, response body: {}.", ThreadUtil.getCurrentMethodName(), status, responseEntity.getBody());

        if (isClientError(status)) {
            throw new HttpClientErrorException(status);
        }
        if (isServerError(status)) {
            throw new HttpServerErrorException(status);
        }

        throw new RestClientException(responseEntity.toString());
    }

    private boolean isSuccess(HttpStatus status) {
        return status.series() == HttpStatus.Series.SUCCESSFUL;
    }

    private boolean isClientError(HttpStatus status) {
        return status.series() == HttpStatus.Series.CLIENT_ERROR;
    }

    private boolean isServerError(HttpStatus status) {
        return status.series() == HttpStatus.Series.SERVER_ERROR;
    }

}