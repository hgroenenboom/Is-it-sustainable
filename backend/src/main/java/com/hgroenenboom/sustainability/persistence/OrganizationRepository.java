package com.hgroenenboom.sustainability.persistence;

import com.hgroenenboom.sustainability.data.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface OrganizationRepository extends JpaRepository<Organization, Long> {
}
