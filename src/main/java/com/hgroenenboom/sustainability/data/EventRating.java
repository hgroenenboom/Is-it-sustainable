package com.hgroenenboom.sustainability.data;

import javax.persistence.*;

@Entity
public class EventRating extends Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Event event;

    private float impact;
    private float sustainable;

    public EventRating(String ipAdress, Event event, float impact, float sustainable) {
        super(ipAdress);
        this.event = event;
        this.impact = impact;
        this.sustainable = sustainable;
    }

    public Long getId() {
        return id;
    }

    public float getImpact() {
        return impact;
    }

    public void setImpact(float impact) {
        this.impact = impact;
    }

    public float getSustainable() {
        return sustainable;
    }

    public void setSustainable(float sustainable) {
        this.sustainable = sustainable;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
