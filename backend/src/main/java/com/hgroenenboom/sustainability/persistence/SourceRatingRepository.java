package com.hgroenenboom.sustainability.persistence;

import com.hgroenenboom.sustainability.data.Source;
import com.hgroenenboom.sustainability.data.SourceRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SourceRatingRepository extends JpaRepository<SourceRating, Long>
{
//    @Query("SELECT * FROM `source_rating` WHERE source_id = ?1.id")
    List<SourceRating> findBySourceId(Long sourceId);
}
