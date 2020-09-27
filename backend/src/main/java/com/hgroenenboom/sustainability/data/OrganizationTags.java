package com.hgroenenboom.sustainability.data;

import javax.persistence.*;
import java.util.List;

@Entity
public class OrganizationTags {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tagName;

    public OrganizationTags() { }

    public OrganizationTags(String tagName) {
        this.tagName = tagName;
    }

    public Long getId() {
        return id;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }
}
