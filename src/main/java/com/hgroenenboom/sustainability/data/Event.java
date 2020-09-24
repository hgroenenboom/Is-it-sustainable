package com.hgroenenboom.sustainability.data;

import javax.persistence.*;
import java.util.List;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private SustainabilityType type;
    // TODO - date
    // TODO - location

    @ManyToOne
    private Organization organization;

    public Event(String name, String description, SustainabilityType type, Organization organization) {
        this.name = name;
        this.description = description;
        this.type = type;
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
}
