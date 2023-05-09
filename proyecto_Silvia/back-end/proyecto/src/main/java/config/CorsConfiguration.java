/*
package config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("http://localhost:8080/fisioSilvia/client/getClients")
                .allowedOrigins("http://localhost:4200")
                .allowedMethods("GET");

        registry.addMapping("/otherPath")
                .allowedOrigins("http://localhost:4200", "http://example.com")
                .allowedMethods("GET", "POST");


    }
}
*/