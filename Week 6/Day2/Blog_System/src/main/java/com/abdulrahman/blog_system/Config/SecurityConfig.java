package com.abdulrahman.blog_system.Config;

import com.abdulrahman.blog_system.MyUser.MyUserDetailedService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Service;

@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final MyUserDetailedService myUserDetailedService;

    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(myUserDetailedService);
        daoAuthenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder());
        return daoAuthenticationProvider;
    }
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED).
                and().
                authenticationProvider(authenticationProvider()).
                authorizeHttpRequests().requestMatchers(HttpMethod.POST,"/api/v1/register").permitAll().
                requestMatchers(HttpMethod.POST,"/api/v2/login").hasAuthority("ADMIN").anyRequest().authenticated().
                and().logout().logoutUrl("/api/v1/auth/logout/").deleteCookies("JSESSIONID").invalidateHttpSession(true).and().httpBasic();
        return http.build();
    }

}
