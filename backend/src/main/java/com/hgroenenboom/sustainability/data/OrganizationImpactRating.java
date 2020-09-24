package com.hgroenenboom.sustainability.data;

import javax.persistence.*;

@Entity
public class OrganizationImpactRating extends Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Organization organization;

    private float worldWideImpact;

    public OrganizationImpactRating(String ipAdress, Organization organization, float worldWideImpact) {
        super(ipAdress);
        this.organization = organization;
        this.worldWideImpact = worldWideImpact;
    }

    public Long getId() {
        return id;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public float getWorldWideImpact() {
        return worldWideImpact;
    }

    public void setWorldWideImpact(float worldWideImpact) {
        this.worldWideImpact = worldWideImpact;
    }
}
