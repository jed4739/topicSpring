package com.example.topicSpring.config;


import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@EnableWebSecurity
@Configuration
@AllArgsConstructor
public class SecurityConfig {
    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        String password = passwordEncoder().encode("1234");
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("user")
                .password(password)
                .roles("USER")
                .build());
        manager.createUser(User.withUsername("admin")
                .password(password)
                .roles("ADMIN")
                .build());
        return manager;
    }

    /** resources security setting */
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().antMatchers("/resources/**");
    }

    /** Security Filter */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.httpBasic().disable() // 로그인 따로 만듦
                .csrf().disable() // csrf 보안 끔
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // JWT 인증으로 대체
                .and()
                .authorizeRequests()
                .antMatchers("/*/signUp","/*/signIn").permitAll() // 로그인 회원가입은 접근가능
                .anyRequest().hasRole("USER") // 그 외는 유저만 접근 가능
                .and()
                .formLogin();
        return http.build();
    }

    /** Password Encryption */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}