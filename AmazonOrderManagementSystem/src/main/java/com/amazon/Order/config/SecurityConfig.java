//package com.amazon.Order.config;
//
//import com.amazon.Order.filter.JWTAuthenticationFilter;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//@EnableWebSecurity
//@Configuration
//public class SecurityConfig {
//
//    private final JWTAuthenticationFilter jwtAuthenticationFilter;
//
//    public SecurityConfig(
//            JWTAuthenticationFilter jwtAuthenticationFilter
//    ) {
//        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
//    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(
//            HttpSecurity http
//    ) throws Exception {
//
//        http
//
//                // Disable CSRF because we are building a stateless REST API
//                .csrf(AbstractHttpConfigurer::disable)
//
//                // JWT-based authentication should not create HTTP sessions
//                .sessionManagement(session ->
//                        session.sessionCreationPolicy(
//                                SessionCreationPolicy.STATELESS
//                        )
//                )
//
//                // Configure authorization
//                .authorizeHttpRequests(authorize ->
//                        authorize
//                                .anyRequest()
//                                .authenticated()
//                )
//
//                // Add our JWT filter before Spring's authentication filter
//                .addFilterBefore(
//                        jwtAuthenticationFilter,
//                        UsernamePasswordAuthenticationFilter.class
//                );
//
//        return http.build();
//    }
//}
