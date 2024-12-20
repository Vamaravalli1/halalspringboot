package com.Halal.Believer;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/lays/**")
                .allowedOrigins("http://localhost:3000", "http://<flutter-app-url>")
                .allowedMethods("GET", "POST", "PUT", "DELETE");
    

}}
