package com.mobigen.lecture.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "My Spring Boot Application",
        version = "1.0",
        description = "API documentation for My Spring Boot Application"
    )
)
public class OpenApiConfig {
    
}
