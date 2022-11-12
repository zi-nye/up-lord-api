package uplord.uplordapi.util.httpClient.executor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import uplord.uplordapi.util.ThreadUtil;
import uplord.uplordapi.util.httpClient.HttpRestInfo;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.Arrays;
import java.util.Optional;

@Slf4j
public class HttpPostExecutor<T> implements HttpRestExecutor<T> {

    private final HttpRestInfo<T> info;
    private final HttpEntity<?> entity;

    public HttpPostExecutor(HttpRestInfo<T> info, HttpEntity<?> entity) {
        this.info = info;
        this.entity = entity;
    }

    @Override
    public ResponseEntity<T> execute() {
        String url = info.getUrl();
        Object[] uriVariables = Optional.ofNullable(info.getUriVariables()).orElse(new Object[]{});
        Class<T> responseType = info.getResponseType();

        try {
            return new RestTemplate(requestFactoryForProxy()).exchange(url, HttpMethod.POST, entity, responseType, uriVariables);
        } catch (Exception e) {
            log.error(
                    "[{}] Failed HttpRestTemplate POST request. body: {}, url: {}, uriVariables: {}. error message: {}",
                    ThreadUtil.getCurrentMethodName(),
                    info,
                    url,
                    Arrays.toString(info.getUriVariables()),
                    e.getMessage()
            );
            throw e;
        }
    }

    // TODO fiddler [WIP] 사용 옵션 설정 시 적용. 외부 의존성으로 분리.
    private SimpleClientHttpRequestFactory requestFactoryForProxy() {
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("127.0.0.1", 8888));
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setProxy(proxy);
        return requestFactory;
    }

}