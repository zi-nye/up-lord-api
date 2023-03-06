package uplord.uplordapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

import lombok.RequiredArgsConstructor;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
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

    @Override
    public void configure(HttpSecurity http) throws Exception {
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
                .antMatchers("/oauth/kakao").permitAll()
                .anyRequest().authenticated()

                /**JwtSecurityConfig 적용 */
                .and()
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
