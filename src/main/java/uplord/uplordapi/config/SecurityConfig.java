package uplord.uplordapi.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsUtils;
import uplord.uplordapi.common.JwtAccessDeniedHandler;
import uplord.uplordapi.common.JwtAuthenticationEntryPoint;
import uplord.uplordapi.common.filter.JwtFilter;

@Configuration
@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final JwtAuthenticationEntryPoint jwtAtuthenticationEntryPoint;
    private final JwtAccessDeniedHandler jwtAccessDeniedHandler;
    private final JwtFilter jwtFilter;

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    // Spring Security 룰을 무시하는 URL 규칙들 >> 기존 메서드에서 분리했습니다
    // http://www.praconfi.com/2021-11-25/swagger-(+-spring-security,-jwt-)
    @Override
    public void configure(WebSecurity web) {
        web.ignoring()
                .antMatchers("/sysManage/userManage")
                .antMatchers("/files/**")
                .antMatchers("/event/birthday/**")
                .antMatchers("/v2/api-docs", "/swagger-resources/**",
                        "/swagger-ui/**", "/webjars/**", "/swagger/**")
                .antMatchers("/profile")
                .antMatchers("/attendance/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .httpBasic().disable()

                /**401, 403 Exception 핸들링 */
                .exceptionHandling()
                .authenticationEntryPoint(jwtAtuthenticationEntryPoint)
                .accessDeniedHandler(jwtAccessDeniedHandler)

                /**세션 사용하지 않음*/
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                /**HttpServletRequest를 사용하는 요청들에 대한 접근 제한 설정*/
                .and()
                .authorizeRequests()
                .requestMatchers(CorsUtils::isPreFlightRequest).permitAll()
                .antMatchers("/oauth/kakao").permitAll()
//                .anyRequest().authenticated()

                /**JwtSecurityConfig 적용 */
                .and()
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
