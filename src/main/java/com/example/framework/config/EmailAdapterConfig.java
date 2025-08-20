package com.example.framework.config;

import com.example.application.core.port.out.EmailPortOut;
import com.example.application.usecase.EmailUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmailAdapterConfig {
    @Bean
    public EmailUseCase emailUseCase(EmailPortOut portOut) {
        return new EmailUseCase(portOut);
    }
}