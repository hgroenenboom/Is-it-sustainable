package com.hgroenenboom.sustainability.persistence;

import com.hgroenenboom.sustainability.data.Organization;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrganizationService {
    private OrganizationRepository repository;

    public OrganizationService(OrganizationRepository repository) {
        this.repository = repository;
    }

    public List<Organization> getAll() {
        return this.repository.findAllByOrderByNameAsc();
    }

    public Organization save(Organization o) {
        return this.repository.save(o);
    }

    public Optional<Organization> findById(Long i) { return this.repository.findById(i); }

    public List<Organization> findByName(String name) {
        return this.repository.findByNameContainsOrderByNameAsc(name);
    }
}
