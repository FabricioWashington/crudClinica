// package com.fabriciodev.config;

// import org.springframework.context.annotation.Configuration;
// import org.springframework.web.servlet.config.annotation.CorsRegistry;
// import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// @Configuration
// public class CorsConfig implements WebMvcConfigurer {

// @Override
// public void addCorsMappings(CorsRegistry registry) {
// registry.addMapping("/**")
// .allowedOriginPatterns(
// "https://crud-clinica-frontend-hiiwfflfz-fabriciowashingtons-projects.vercel.app",
// "https://crud-clinica-frontend-git-main-fabriciowashingtons-projects.vercel.app",
// "http://localhost:4200")
// .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
// .allowedHeaders("*")
// .allowCredentials(true);
// }
// }