package com.hgroenenboom.sustainability.data;

import javax.persistence.*;

@Entity
public class Source extends SourceBase {
    public Source(String description, String url, String fallbackUrl, String notes, SourceState sourceState, SourceType sourceType, Event event) {
        super(description, url, fallbackUrl, notes, sourceState, sourceType);
        this.event = event;
    }

    protected Source() { }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    private Event event;

    public Long getId() {
        return id;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
