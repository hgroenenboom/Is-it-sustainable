package com.hgroenenboom.sustainability.persistence;

import com.hgroenenboom.sustainability.data.OrganizationTags;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface OrganizationTagRepository extends JpaRepository<OrganizationTags, Long> {
    List<OrganizationTags> findByTagNameContainsOrderByTagNameAsc(String TagName);
    List<OrganizationTags> findAllByOrderByTagNameAsc();
}
