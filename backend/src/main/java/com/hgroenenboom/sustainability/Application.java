package com.hgroenenboom.sustainability;

import com.hgroenenboom.sustainability.data.SourceType;
import com.hgroenenboom.sustainability.data.State;
import com.hgroenenboom.sustainability.persistence.SourceRatingService;
import com.hgroenenboom.sustainability.persistence.SourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {
        SecurityAutoConfiguration.class})
@PropertySource(value = "file:./application.properties")
@RestController
public class Application {
    @Autowired
    private SourceRatingService sourceRatingService;
    private SourceService sourceService;

    public Application(SourceRatingService sourceRatingService, SourceService sourceService) {
        this.sourceRatingService = sourceRatingService;
        this.sourceService = sourceService;
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("*").allowedOrigins("*");
            }
        };
    }

    @GetMapping(path = "/getSourceStates", produces = MediaType.APPLICATION_JSON_VALUE)
    public final String[] getSourceStates() {
        return new String[]{State.PENDING.name(), State.APPROVED.name(), State.DENIED.name()};
    }

    @GetMapping(path = "/getSourceTypes", produces = MediaType.APPLICATION_JSON_VALUE)
    public final ArrayList<String> getSourceTypes() {
        return SourceType.getTypes();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
