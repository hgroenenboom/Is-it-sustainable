package com.hgroenenboom.sustainability.persistence;

import com.hgroenenboom.sustainability.data.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Long>
{
}
