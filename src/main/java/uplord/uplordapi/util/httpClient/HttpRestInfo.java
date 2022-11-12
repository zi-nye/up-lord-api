package uplord.uplordapi.util.httpClient;

import lombok.Builder;
import lombok.Getter;

import java.util.Arrays;

@Getter
@Builder
public class HttpRestInfo<T> {

    private String protocol;
    private String host;
    private String path;
    private Class<T> responseType;
    private Object[] uriVariables;

    public String getUrl() {
        return protocol + host + path;
    }

    @Override
    public String toString() {
        return "HttpRestInfo{" +
                "protocol='" + protocol + '\'' +
                ", host='" + host + '\'' +
                ", path='" + path + '\'' +
                ", responseType=" + responseType +
                ", uriVariables=" + Arrays.toString(uriVariables) +
                '}';
    }
}