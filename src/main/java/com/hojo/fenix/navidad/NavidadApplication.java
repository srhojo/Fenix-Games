package com.hojo.fenix.navidad;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;


//@EnableWebSecurity
@SpringBootApplication
public class NavidadApplication {

// extends WebSecurityConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(NavidadApplication.class, args);
    }


    @Value("${navidad.admin.user}")
    private String user;

    @Value("${navidad.admin.pwd}")
    private String pwd;

   /* @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser(user)
                .password("{noop}"+pwd)
                .roles("ADMIN");

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //http.authorizeRequests().anyRequest().authenticated().and().antMatcher("/navidad/**").httpBasic();
        http
                .authorizeRequests().antMatchers("/private/**")
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }*/
}
