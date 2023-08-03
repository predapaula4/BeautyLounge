package com.example.BeautyLounge.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/bootstrap/**").permitAll()
                        .requestMatchers(toH2Console()).permitAll()
                        .requestMatchers("/login").permitAll()
                        .requestMatchers("/logout").permitAll()
                        .requestMatchers("/register/**").permitAll()
                        .requestMatchers("/index").hasAnyRole("USER", "ADMIN")
                        .requestMatchers("/register").hasAnyRole("USER", "ADMIN")
                        .requestMatchers("/shop").hasAnyRole("USER", "ADMIN")
                        .requestMatchers("/shop-single").hasAnyRole("USER", "ADMIN")
                        .requestMatchers("/cart").hasAnyRole("USER", "ADMIN")
                        .requestMatchers("/pharmacyOverview").hasAnyRole( "ADMIN")
                        .requestMatchers("/pharmacyForm").hasAnyRole("ADMIN")
                        .requestMatchers("/pillOverview").hasAnyRole("ADMIN")
                        .requestMatchers("/pillForm").hasAnyRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .headers(headers -> headers.frameOptions().disable())
                .csrf(csrf -> csrf.ignoringRequestMatchers(toH2Console()))
                .formLogin((form) -> form
                        .loginPage("/login")
                        .loginProcessingUrl("/login")
                        .defaultSuccessUrl("/index")
                        .permitAll()
                )
                .logout((logout) -> logout.permitAll())
                .exceptionHandling().accessDeniedPage("/access-denied");
        return http.build();
    }
}
