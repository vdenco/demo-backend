package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.query.spi.EvaluationContextExtension;

@Configuration
public class SecurityConfiguration {

    @Bean
    EvaluationContextExtension evaluationContextExtension(){
      return new SecurityEvaluationContextExtension();
    }

}
