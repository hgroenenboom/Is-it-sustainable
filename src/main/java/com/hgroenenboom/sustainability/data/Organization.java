package com.hgroenenboom.sustainability.data;

import javax.persistence.*;
import java.util.List;

@Entity
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String website;

    @ManyToMany
    private List<Organization> partners;

    public Organization(String name, String website, List<Organization> partners) {
        this.name = name;
        this.website = website;
        this.partners = partners;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public List<Organization> getPartners() {
        return partners;
    }

    public void setPartners(List<Organization> partners) {
        this.partners = partners;
    }
}
