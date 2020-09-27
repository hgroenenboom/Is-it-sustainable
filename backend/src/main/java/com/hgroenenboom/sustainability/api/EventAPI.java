package com.hgroenenboom.sustainability.api;

import com.hgroenenboom.sustainability.data.Event;
import com.hgroenenboom.sustainability.data.EventRating;
import com.hgroenenboom.sustainability.data.State;
import com.hgroenenboom.sustainability.data.SustainabilityType;
import com.hgroenenboom.sustainability.persistence.EventRatingService;
import com.hgroenenboom.sustainability.persistence.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/event")
public class EventAPI {
    @Autowired
    private EventService eventService;
    @Autowired
    private EventRatingService eventRatingService;

    public EventAPI(EventService eventService, EventRatingService eventRatingService) {
        this.eventService = eventService;
        this.eventRatingService = eventRatingService;
    }

    @GetMapping("/addRating")
    public EventRating addRating() {
        List<Event> events = eventService.findAll();
        EventRating eR = new EventRating("192.0.0.124", events.get(new Random().nextInt(events.size())), new Random().nextFloat(), new Random().nextFloat());
        return eventRatingService.save( eR );
    }

    @GetMapping("/add")
    public Event addEvent() {
        return eventService.save(new Event("name", "descr", SustainabilityType.Animals, State.PENDING, 1995, 2012, null));
    }
}
