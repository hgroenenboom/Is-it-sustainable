package com.hgroenenboom.sustainability.persistence;

import com.hgroenenboom.sustainability.data.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface OrganizationRepository extends JpaRepository<Organization, Long> {
    List<Organization> findByNameContainsOrderByNameAsc(String name);
    List<Organization> findAllByOrderByNameAsc();
}
