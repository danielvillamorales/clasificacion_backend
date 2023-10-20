package com.kostazul.clasificacion.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer{

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:4200",
                        "http://10.10.6.128:8001",
                        "http://jasperka.kostazul.com:8001",
                        "http://3.211.118.213:8001",
                        "http://localhost:8085")
                .allowedMethods("GET")
                .allowedHeaders("*");
    }

}
