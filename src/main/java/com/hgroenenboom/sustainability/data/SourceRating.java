package com.hgroenenboom.sustainability.data;

import javax.persistence.*;

@Entity
public class SourceRating extends Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Source source;

    private float credibility;

    public SourceRating(float credibility, Source source, String ipAdress) {
        super(ipAdress);
        this.credibility = credibility;
        this.source = source;
    }

    public Long getId() {
        return id;
    }

    public float getCredibility() {
        return credibility;
    }

    public void setCredibility(float credibility) {
        this.credibility = credibility;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }
}
