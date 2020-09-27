package com.hgroenenboom.sustainability.persistence;

import com.hgroenenboom.sustainability.data.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EventService {
    @Autowired
    private EventRepository repository;

    public EventService(EventRepository repository) {
        this.repository = repository;
    }

    public Event save(Event e) {
        return repository.save(e);
    }

    public List<Event> findAll() {
        return repository.findAll();
    }
}
