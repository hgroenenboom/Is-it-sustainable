package com.hgroenenboom.sustainability.data;

import javax.persistence.*;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private SustainabilityType type;
    private State state;

    private int startYear;
    private int endYear;
    // TODO - location

    @ManyToOne
    private Organization organization;

    public Event(String name, String description, SustainabilityType type, State state, int startYear, int endYear, Organization organization) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.state = state;
        this.startYear = startYear;
        this.endYear = endYear;
        this.organization = organization;
    }

    protected Event() {}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public SustainabilityType getType() {
        return type;
    }

    public void setType(SustainabilityType type) {
        this.type = type;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public int getEndYear() {
        return endYear;
    }

    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }
}
