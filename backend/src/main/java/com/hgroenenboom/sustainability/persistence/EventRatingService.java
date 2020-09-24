package com.hgroenenboom.sustainability.persistence;

import com.hgroenenboom.sustainability.data.EventRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EventRatingService {
    @Autowired
    private EventRatingRepository repository;

    public EventRatingService(EventRatingRepository repository) {
        this.repository = repository;
    }

    public EventRating save(EventRating e) {
        return repository.save(e);
    }

    public List<EventRating> findAll() {
        return repository.findAll();
    }
}
