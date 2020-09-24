package com.hgroenenboom.sustainability.data;

import javax.persistence.*;
import java.util.Date;

@Entity
public class SourceUpdate extends SourceBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date date;

    private SourceUpdateState state;

    @ManyToOne
    private Source sourceToUpdate;

    public SourceUpdate(String description, String url, String fallbackUrl, String notes, SourceState sourceState, SourceType sourceType, Date date, SourceUpdateState state, Source sourceToUpdate) {
        super(description, url, fallbackUrl, notes, sourceState, sourceType);
        this.date = date;
        this.state = state;
        this.sourceToUpdate = sourceToUpdate;
    }

    public Long getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
