package com.hgroenenboom.sustainability.persistence;

import com.hgroenenboom.sustainability.data.Source;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SourceRepository extends JpaRepository<Source, Long>
{
}
