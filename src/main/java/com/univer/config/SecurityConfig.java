package com.univer.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@PropertySource("classpath:application.properties")
public class SecurityConfig {



    @Autowired
    Environment environment;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

                httpSecurity.authorizeHttpRequests()
                .requestMatchers("/").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/")
  //              .failureUrl("/login-error")
                .loginProcessingUrl("/login").permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login").deleteCookies("JSESSIONID")
                .permitAll()
                .and()
                .csrf().disable();
        return httpSecurity.build();

//        //old authorizedRequsest
//        //antMatcher - requestMatcher
//        httpSecurity.authorizeHttpRequests()
//                .requestMatchers("/api/**").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .loginProcessingUrl("/perform-login")
//                .usernameParameter("username")
//                .passwordParameter("password")
//                .defaultSuccessUrl("/index").permitAll()
//                .and()
//                .logout()
//                .logoutUrl("/logout")
//                .logoutSuccessUrl("/login").deleteCookies("JSESSIONID")
//                .permitAll()
//                .and()
//                .csrf().disable();
//
//
//        return httpSecurity.build();
    }

}