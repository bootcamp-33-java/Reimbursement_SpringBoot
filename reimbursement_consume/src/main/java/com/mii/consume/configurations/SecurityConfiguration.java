/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.consume.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 *
 * @author Insane
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
    
    @Autowired
    private UserDetailsService service;
    
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(service).passwordEncoder(NoOpPasswordEncoder.getInstance());
    }
    
    @Override
    protected void configure(HttpSecurity http)throws Exception{
        http
                .headers()
                .frameOptions().sameOrigin()
                .and()
                .authorizeRequests()
                .antMatchers("/resources/**").permitAll()
                .antMatchers("/").authenticated()
                .antMatchers("/home/**").authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/loginerror")
                .permitAll()
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login")
                .deleteCookies("my-remember-me-cookie")
                .permitAll()
                .and()
                .rememberMe()
                .rememberMeCookieName("my-remember-mre-cookie")
                .and()
                .exceptionHandling();
    }
    
}
