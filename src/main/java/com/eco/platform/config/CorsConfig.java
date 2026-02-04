package com.eco.platform.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Дозволяємо всі шляхи
                .allowedOrigins("*") // Дозволяємо запити з будь-якого домену
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS");
    }
}
