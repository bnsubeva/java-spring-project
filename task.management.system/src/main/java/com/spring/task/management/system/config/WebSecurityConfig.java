package com.spring.task.management.system.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@Slf4j
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeRequests()
/*            .antMatchers(GET, "/api/users").hasAnyRole("ADMIN")
            .antMatchers(POST, "/**").hasAnyRole("USER", "ADMIN")
            .antMatchers(PUT, "/**").hasAnyRole("USER", "ADMIN")
            .antMatchers(DELETE, "/**").hasRole("ADMIN")*/
            //.antMatchers("/**").hasAnyRole("ADMIN")
            .antMatchers("/**").permitAll();
/*            .and()
            .formLogin()
            .loginPage("/auth/login")
            .and()
            .httpBasic();*/
/*            .and()
            .httpBasic();*/
    }

}
/*    @Bean
    public UserDetailsService userDetailsService(UserService users) {
        return username -> {
            try {
                UserDetails found = users.getUserByUsername(username);
                log.debug(">>> User authenticated for username: {} is {}", username, found);
                return found;
            } catch (EntityNotFoundException ex) {
                throw new UsernameNotFoundException(ex.getMessage(), ex);
            }
        };
    }*/
