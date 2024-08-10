package com.taimur.ToDo.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(authz -> authz.requestMatchers("/signup",
                "login").permitAll().anyRequest().authenticated())
                .formLogin(login -> login.loginPage("/login"))
                .logout(logout -> logout.logoutSuccessUrl("/login?logout=true").permitAll()).build();

    }
}
