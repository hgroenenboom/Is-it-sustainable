package com.hgroenenboom.sustainability;

import com.hgroenenboom.sustainability.data.Source;
import com.hgroenenboom.sustainability.data.SourceState;
import com.hgroenenboom.sustainability.persistence.SourceRatingService;
import com.hgroenenboom.sustainability.persistence.SourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.PropertySource;

import com.hgroenenboom.sustainability.data.SourceRating;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping(path = "/add")
    public void saveDemo() {
        sourceRatingService.saveSourceRating(new SourceRating(0.5f
                , sourceService.saveSource(new Source("description", "www.source.nl", "www.source2.nl", "An example source", SourceState.PENDING))
                , "192.0.0.168")
        );
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
