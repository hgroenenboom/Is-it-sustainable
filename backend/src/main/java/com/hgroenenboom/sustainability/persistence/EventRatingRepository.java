package com.hgroenenboom.sustainability.persistence;

import com.hgroenenboom.sustainability.data.EventRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRatingRepository extends JpaRepository<EventRating, Long>
{
}
