package com.Sena_Market.cors;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.List;


@Component
public class CustomCorsConfiguration implements CorsConfigurationSource {
    @Override
    public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(List.of("https://angels-front.vercel.app",
                "http://34.217.67.249:80",
                "http://34.217.67.249",
                "http://localhost:4200"));
        config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE","OPTIONS"));
        config.setAllowedHeaders(List.of("*"));
        config.setExposedHeaders(List.of(
                "Cache-Control",
                "Content-Language",
                "Content-Type",
                "Expires",
                "Last-Modified",
                "Pragma"
        ));
        config.setAllowCredentials(false);
        config.setMaxAge(0L); // Deshabilita el cache de preflight
        return config;
    }
}


