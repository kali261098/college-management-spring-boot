package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/register").allowedOrigins("http://localhost:8080");
                registry.addMapping("/login").allowedOrigins("http://localhost:8080");
                registry.addMapping("/addTecher").allowedOrigins("http://localhost:8080");
                registry.addMapping("/admin").allowedOrigins("http://localhost:8080");
                registry.addMapping("/user").allowedOrigins("http://localhost:8080");
                registry.addMapping("/viewStudent").allowedOrigins("http://localhost:8080");
                registry.addMapping("/approveStudent").allowedOrigins("http://localhost:8080");
            }
        };
    }

}
