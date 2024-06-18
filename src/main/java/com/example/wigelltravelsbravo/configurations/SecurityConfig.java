package com.example.wigelltravelsbravo.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity


public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers("/api/v2/updatedestination/{id}").hasRole("ADMIN")
                        .requestMatchers("/api/v2/add-destination").hasRole("ADMIN")
                        .requestMatchers("/api/v2/deletedestination/{id}").hasRole("ADMIN")
                        .requestMatchers("/api/v2/cusotmers").hasRole("ADMIN")
                        .requestMatchers("/api/v2/trips").hasRole("USER")
                        .requestMatchers("/api/v2/booktrip").hasRole("USER")
                        .requestMatchers("/api/v2/mybookings").hasRole("USER")
                        .requestMatchers("/api/v2/updatetrip/{id}").hasRole("USER")
                        .anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults())
                .formLogin(Customizer.withDefaults())
                .csrf(csrf -> csrf.disable());
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails userDetails = User.withDefaultPasswordEncoder()
                .username("bravoUser")
                .password("1234")
                .roles("USER")
                .build();
        UserDetails adminDetails = User.withDefaultPasswordEncoder()
                .username("bravoAdmin")
                .password("1234")
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(userDetails, adminDetails);
    }
}
