package com.bookmymovie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class BookMyMovieApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookMyMovieApplication.class, args);
    }
}

@Configuration
class StaticResourceConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(@NonNull ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/image/**","/banner/**")
                .addResourceLocations("classpath:/image/")
                .addResourceLocations("classpath:/banner/");
    }
}
