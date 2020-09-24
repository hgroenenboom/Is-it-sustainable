package com.hgroenenboom.sustainability.data;

import javax.persistence.*;

@MappedSuperclass
public class SourceBase {
    private String description;
    private String url;
    private String fallbackUrl;
    private String notes;

    private SourceState sourceState;
    private SourceType sourceType;

    protected SourceBase() {}

    public SourceBase(String description, String url, String fallbackUrl, String notes, SourceState sourceState, SourceType sourceType) {
        this.description = description;
        this.url = url;
        this.fallbackUrl = fallbackUrl;
        this.notes = notes;
        this.sourceState = sourceState;
        this.sourceType = sourceType;
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

    public SourceType getSourceType() {
        return sourceType;
    }

    public void setSourceType(SourceType sourceType) {
        this.sourceType = sourceType;
    }
}
