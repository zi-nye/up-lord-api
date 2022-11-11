package uplord.uplordapi.common.filter;

import org.springframework.http.HttpMethod;
import org.springframework.util.PatternMatchUtils;
import org.springframework.web.HttpRequestMethodNotSupportedException;

import javax.servlet.*;
import javax.servlet.FilterConfig;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class HttpMethodGuardFilter implements Filter {

    private final String[] allowMethods = {
            HttpMethod.GET.name(),
            HttpMethod.POST.name(),
            HttpMethod.PUT.name(),
            HttpMethod.OPTIONS.name(),
            HttpMethod.TRACE.name(),
            HttpMethod.HEAD.name(),
    };

    @Override
    public void init(FilterConfig filterConfig) {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;

        if (isNotAllowHttpMethod(httpServletRequest.getMethod())) {
            throw new HttpRequestMethodNotSupportedException(httpServletRequest.getMethod());
        }

        chain.doFilter(request, response);
    }

    private boolean isNotAllowHttpMethod(String method) {
        return !PatternMatchUtils.simpleMatch(allowMethods, method);
    }

}