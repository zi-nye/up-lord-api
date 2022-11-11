package uplord.uplordapi.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import uplord.uplordapi.common.filter.HttpMethodGuardFilter;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<HttpMethodGuardFilter> httpMethodGuardFilter() {
        FilterRegistrationBean<HttpMethodGuardFilter> bean = new FilterRegistrationBean<>();
        bean.setFilter(new HttpMethodGuardFilter());
        bean.addUrlPatterns("/**");
        bean.setOrder(1);
        return bean;
    }

}