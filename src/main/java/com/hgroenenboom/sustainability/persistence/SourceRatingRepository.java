package com.hgroenenboom.sustainability.persistence;

import com.hgroenenboom.sustainability.data.SourceRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface SourceRatingRepository extends JpaRepository<SourceRating, Long>
{
}
