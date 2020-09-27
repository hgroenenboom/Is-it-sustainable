package com.hgroenenboom.sustainability.persistence;

import com.hgroenenboom.sustainability.data.OrganizationTags;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrganizationTagService {
    @Autowired
    private OrganizationTagRepository repository;

    public OrganizationTagService(OrganizationTagRepository repository) {
        this.repository = repository;
    }

    public Optional<OrganizationTags> findById(Long id) {
        return this.repository.findById(id);
    }

    public void save(OrganizationTags tag) {
        this.repository.save(tag);
    }

    public List<OrganizationTags> findSimilar(String name) {
        return this.repository.findByTagNameContainsOrderByTagNameAsc(name);
    }

    public List<OrganizationTags> getAll() {
        return this.repository.findAllByOrderByTagNameAsc();
    }
}
