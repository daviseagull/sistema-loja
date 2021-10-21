package br.com.roseai.sistemaloja.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();

        http.authorizeRequests()
                .antMatchers("/v3/api-docs/**",
                        "/configuration/ui",
                        "/swagger-resources/**",
                        "/swagger-ui/**",
                        "/webjars/**").permitAll()
                .antMatchers("/**").authenticated()
                .and().httpBasic();
    }
}
