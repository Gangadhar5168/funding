package com.learning.funding.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
}
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.csrf(csrf -> csrf.disable())
       // authorisation added using roles.
        .authorizeHttpRequests(auth -> auth
            .requestMatchers(HttpMethod.GET,"/api/staff").hasAnyRole("ADMIN","EMPLOYEE")
            .requestMatchers(HttpMethod.POST,"/api/staff").hasRole("ADMIN")
            .requestMatchers(HttpMethod.POST,"/api/crew/**").hasRole("ADMIN")
            .requestMatchers(HttpMethod.POST,"/api/crew").hasRole("ADMIN")
            .requestMatchers(HttpMethod.GET,"/api/transactions").hasAnyRole("ADMIN","EMPLOYEE")
            .requestMatchers(HttpMethod.GET,"/api/transactions/**").hasAnyRole("ADMIN","EMPLOYEE")
            .requestMatchers("/swagger-ui/**","/v3/api-docs/**").permitAll()
            .anyRequest().authenticated()
        )
        .httpBasic(Customizer.withDefaults());
    


        return http.build();
    }
}
