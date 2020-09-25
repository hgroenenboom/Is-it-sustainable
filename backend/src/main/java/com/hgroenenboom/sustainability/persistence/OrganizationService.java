package com.hgroenenboom.sustainability.persistence;

import com.hgroenenboom.sustainability.data.Organization;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationService {
    private OrganizationRepository repository;

    public OrganizationService(OrganizationRepository repository) {
        this.repository = repository;
    }

    public List<Organization> getAll() {
        return this.repository.findAll();
    }

    public Organization save(Organization o) {
        return this.repository.save(o);
    }
}
