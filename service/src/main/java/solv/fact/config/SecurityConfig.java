package solv.fact.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final JwtFilter jwtFilter;

    @Value("${boot.security.user}")
    private String bootUser;

    @Value("${boot.security.password}")
    private String bootPassword;

    @Value("${boot.security.role}")
    private String bootRole;

    final String API = "/api/0.0.1";
    final String LOGIN          = API + "/login";
    final String SURVEYS        = API + "/surveys";
    final String SURVEYS_ANSWER = API + "/surveys/{^[\\d]$}/answer/{^[\\d]$}/user/{^[\\d]$}";
    final String SURVEYS_USER   = API + "/surveys/user/{^[\\d]$}";

    final String SURVEYS_ID     = API + "/surveys/{^[\\d]$}";

    final String QUESTION       = API + "/surveys/{^[\\d]$}/question";
    final String QUESTION_ID    = API + "/surveys/{^[\\d]$}/question/{^[\\d]$}";

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic().disable()
                .csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                    .and()
                        .authorizeRequests()
                        .antMatchers( // /api/0.0.1/login
                                HttpMethod.POST,
                                LOGIN).permitAll()
                        .antMatchers( // /api/0.0.1/surveys
                                HttpMethod.GET,
                                SURVEYS).hasRole("USER")
                        .antMatchers( // /api/0.0.1/surveys/{surveyId}/answer/{questionId}/user/{personId}
                                HttpMethod.POST,
                                SURVEYS_ANSWER).hasRole("USER")
                        .antMatchers( // /api/0.0.1/surveys/user/{personId}
                                HttpMethod.GET,
                                SURVEYS_USER).hasRole("USER")
                        .antMatchers( // /api/0.0.1/surveys
                                HttpMethod.POST,
                                SURVEYS).hasRole("ADMIN")
                        .antMatchers( // /api/0.0.1/surveys/{id}
                                HttpMethod.PATCH,
                                SURVEYS_ID).hasRole("ADMIN")
                        .antMatchers( // /api/0.0.1/surveys/{id}
                                HttpMethod.DELETE,
                                SURVEYS_ID).hasRole("ADMIN")
                        .antMatchers( // /api/0.0.1/surveys/{id}/question
                                HttpMethod.POST,
                                QUESTION).hasRole("ADMIN")
                        .antMatchers( // /api/0.0.1/surveys/{surveyId}/question/{questionId}
                                HttpMethod.PATCH,
                                QUESTION_ID).hasRole("ADMIN")
                        .antMatchers( // api/0.0.1/surveys/{surveyId}/question/{questionId}
                                HttpMethod.DELETE,
                                QUESTION_ID).hasRole("ADMIN")
                        .anyRequest().authenticated()
                    .and()
                        .addFilterAfter(jwtFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser(bootUser)
                .password(bootPassword)
                .roles(bootRole);
    }

}
