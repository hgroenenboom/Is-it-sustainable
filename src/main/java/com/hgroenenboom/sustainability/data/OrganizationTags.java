package com.hgroenenboom.sustainability.data;

import javax.persistence.*;
import java.util.List;

@Entity
public class OrganizationTags {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tagName;

    @ManyToMany
    private List<Organization> organizations;

    public OrganizationTags(String tagName, List<Organization> organizations) {
        this.tagName = tagName;
        this.organizations = organizations;
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

    public List<Organization> getOrganizations() {
        return organizations;
    }

    public void setOrganizations(List<Organization> organizations) {
        this.organizations = organizations;
    }
}
