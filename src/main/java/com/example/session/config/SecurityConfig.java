package com.example.session.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("admin").password("password").roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
//                .httpBasic()
//                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/secure")
                .and()
                .authorizeRequests()
                .antMatchers("/login*").permitAll()
                .antMatchers("/secure").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .logout().deleteCookies("JSESSIONID","SESSION").invalidateHttpSession(true).clearAuthentication(true)
                .and()
                .rememberMe().tokenValiditySeconds(360)
                .and()
                .sessionManagement()
                .invalidSessionUrl("/login")
                .maximumSessions(1);

    }
}