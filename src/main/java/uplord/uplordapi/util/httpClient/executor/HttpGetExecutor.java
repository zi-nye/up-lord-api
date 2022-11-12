package uplord.uplordapi.util.httpClient.executor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import uplord.uplordapi.util.ThreadUtil;
import uplord.uplordapi.util.httpClient.HttpRestInfo;

import java.util.Arrays;
import java.util.Optional;

@Slf4j
public class HttpGetExecutor<T> implements HttpRestExecutor<T> {

    private final HttpRestInfo<T> info;
    private final HttpEntity<?> entity;

    public HttpGetExecutor(HttpRestInfo<T> info, HttpEntity<?> entity) {
        this.info = info;
        this.entity = entity;
    }

    @Override
    public ResponseEntity<T> execute() {
        String url = info.getUrl();
        Object[] uriVariables = Optional.ofNullable(info.getUriVariables()).orElse(new Object[]{});
        Class<T> responseType = info.getResponseType();

        try {
            return new RestTemplate().exchange(url, HttpMethod.GET, entity,  responseType, uriVariables);
        } catch (Exception e) {
            log.error(
                    "[{}] Failed HttpRestTemplate GET request. url: {}, uriVariables: {}. error message: {}",
                    ThreadUtil.getCurrentMethodName(),
                    url,
                    Arrays.toString(info.getUriVariables()),
                    e.getMessage()
            );
            throw e;
        }
    }

}