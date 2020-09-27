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
    private State state;

    @ManyToMany
    private List<Organization> partners;

    @ManyToMany
    private List<OrganizationTags> organizationTags;

    public Organization(String name, String website, State state, List<Organization> partners, List<OrganizationTags> tags, List<OrganizationTags> organizationTags) {
        this.name = name;
        this.website = website;
        this.state = state;
        this.partners = partners;
        this.organizationTags = organizationTags;
    }

    protected Organization() {}

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

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public List<OrganizationTags> getOrganizationTags() {
        return organizationTags;
    }

    public void setOrganizationTags(List<OrganizationTags> organizationTags) {
        this.organizationTags = organizationTags;
    }
}
