package com.snow.spring_practice1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;

@Configuration
@EnableWebSecurity // Habilita la seguridad web
public class SecurityConfig {
    @Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests(a -> a
        .requestMatchers(new MvcRequestMatcher(null, "/api/*")).hasRole("API_USER")
        .anyRequest().authenticated())
    .formLogin(l -> l.loginPage("/login").permitAll())
    .logout(out -> out.logoutUrl("/").permitAll());
    return http.build();
}




    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user1 = User.builder().username("granJefe")
        .password(passwordEncoder().encode("ssshhh"))
        .roles("USER", "API_USER").build();
        UserDetails user2 = User.builder().username("employee")
        .password(passwordEncoder().encode("blabla"))
        .roles("USER").build();
        return new InMemoryUserDetailsManager(user1, user2);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
