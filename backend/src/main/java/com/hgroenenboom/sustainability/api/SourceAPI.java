package com.hgroenenboom.sustainability.api;

import com.hgroenenboom.sustainability.data.*;
import com.hgroenenboom.sustainability.persistence.EventService;
import com.hgroenenboom.sustainability.persistence.SourceRatingService;
import com.hgroenenboom.sustainability.persistence.SourceService;
import org.apache.commons.math3.util.Pair;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("/source")
public class SourceAPI {
    private SourceService sourceService;
    private SourceRatingService sourceRatingService;
    private EventService eventService;

    public SourceAPI(SourceService sourceService, SourceRatingService sourceRatingService, EventService eventService) {
        this.sourceService = sourceService;
        this.sourceRatingService = sourceRatingService;
        this.eventService = eventService;
    }

    @GetMapping("/addRating")
    public SourceRating addRating() {
        List<Source> sources = sourceService.findAll();
        Source src = sources.size() > 0 ? sources.get(new Random().nextInt(sources.size())) : null;
        if(src == null)
            return null;

        final String randomIP = new Random().nextInt(256) + "." + new Random().nextInt(256) + "." + new Random().nextInt(256) + "." + new Random().nextInt(256);

        SourceRating sR = new SourceRating(new Random().nextFloat(), src, randomIP);
        return sourceRatingService.saveSourceRating( sR );
    }

    @GetMapping("/addRatings")
    public ArrayList<SourceRating> addRatings() {
        ArrayList<SourceRating> ratings = new ArrayList<>();
        for(int i =0; i < 100; i++)
            ratings.add(addRating());
        return ratings;
    }

    @GetMapping("/add")
    public Source addEvent() {
        List<Event> events = eventService.findAll();
        Event evnt = events.size() > 0 ? events.get(new Random().nextInt(events.size())) : null;
        if(evnt == null)
            return null;

        return sourceService.saveSource(new Source("desc", "url1", "url2", "notes", State.PENDING, SourceType.Website, evnt));
    }

    @GetMapping("/getCredibility")
    public ArrayList<Pair<Source, Float>> getCredibility() {
        ArrayList<Pair<Source, Float>> sourceCredList = new ArrayList<>();
        List<Source> sources = sourceService.findAll();

        for(Source s : sources) {
            List<SourceRating> ratings = sourceRatingService.findBySource(s);

            Float f = 0.0f;
            if(ratings.size() > 0) {
                for (SourceRating r : ratings)
                    f += r.getCredibility();

                f /= ratings.size();
                f *= sigmoid((float)Math.sqrt(ratings.size()));
            }

            sourceCredList.add(new Pair<>(s, f));
        }

        return sourceCredList;
    }

    final float sigmoid(float x) { return x / (1.0f + x); }
}
