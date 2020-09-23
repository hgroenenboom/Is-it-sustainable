package com.hgroenenboom.sustainability.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Source {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String description;
    private String url;
    private String fallbackUrl;
    private String notes;

    private SourceState sourceState;

    public Source(String description, String url, String fallbackUrl, String notes, SourceState sourceState) {
        this.description = description;
        this.url = url;
        this.fallbackUrl = fallbackUrl;
        this.notes = notes;
        this.sourceState = sourceState;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFallbackUrl() {
        return fallbackUrl;
    }

    public void setFallbackUrl(String fallbackUrl) {
        this.fallbackUrl = fallbackUrl;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public SourceState getSourceState() {
        return sourceState;
    }

    public void setSourceState(SourceState sourceState) {
        this.sourceState = sourceState;
    }

}
