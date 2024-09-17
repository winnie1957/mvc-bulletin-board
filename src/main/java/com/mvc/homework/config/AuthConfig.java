package com.mvc.homework.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mvc.homework.util.BCryptPasswordEncoder;
import com.mvc.homework.util.PasswordEncoder;

@Configuration
public class AuthConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
