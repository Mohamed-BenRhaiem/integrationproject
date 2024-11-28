package com.projet.location.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // CORS pour toutes les routes
                .allowedOrigins("http://localhost:3000")  // Autoriser l'URL du frontend
                .allowedMethods("GET", "POST", "PUT", "DELETE")  // Méthodes autorisées
                .allowedHeaders("*")  // Accepter tous les en-têtes
                .allowCredentials(true);  // Autoriser l'envoi d'informations d'authentification
    }
}