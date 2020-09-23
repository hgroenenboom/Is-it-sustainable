package com.hgroenenboom.sustainability.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Source extends SourceBase {
    public Source(String description, String url, String fallbackUrl, String notes, SourceState sourceState, SourceType sourceType) {
        super(description, url, fallbackUrl, notes, sourceState, sourceType);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    public Long getId() {
        return id;
    }

}
