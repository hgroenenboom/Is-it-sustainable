package com.hgroenenboom.sustainability.data;

import org.joda.time.DateTime;

import javax.persistence.*;

@Entity
public class SourceUpdate extends SourceBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private DateTime dateTime;

    private SourceUpdateState state;

    @ManyToOne
    private Source sourceToUpdate;

    public SourceUpdate(String description, String url, String fallbackUrl, String notes, SourceState sourceState, SourceType sourceType, DateTime dateTime, SourceUpdateState state, Source sourceToUpdate) {
        super(description, url, fallbackUrl, notes, sourceState, sourceType);
        this.dateTime = dateTime;
        this.state = state;
        this.sourceToUpdate = sourceToUpdate;
    }

    public Long getId() {
        return id;
    }

    public DateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(DateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Source getSourceToUpdate() {
        return sourceToUpdate;
    }

    public void setSourceToUpdate(Source sourceToUpdate) {
        this.sourceToUpdate = sourceToUpdate;
    }

    public SourceUpdateState getState() {
        return state;
    }

    public void setState(SourceUpdateState state) {
        this.state = state;
    }
}
