package com.example.topicSpring.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * 보안 담당 class
 * Bean -> webSecurityCustomizer, filterChain, passwordEncoder
 * */
@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    /*
     * resources security setting
     * resources 의 해당하는 모든 경로의 파일은 필터를 거치지 않는다.
     * */
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().antMatchers("/resources/**");
    }

    /*
     * Password Encryption
     * BCrypt 는 password 에 솔트를 더해 여러번 해쉬한다. -> default strength = 10
     * */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /*
     * Security Filter
     * url 의 보안을 담당하는 메소드
     * USER 권한이 없을 시 모든 페이지 접근 거부
     * */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/user/login","/user/signup")
                .permitAll()
//                .antMatchers("/**").hasRole("USER")
                .and()
                .formLogin()
                .loginPage("/user/login")
                .defaultSuccessUrl("/board/list")
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
                .logoutSuccessUrl("/board/list")
                .invalidateHttpSession(true);
        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

}