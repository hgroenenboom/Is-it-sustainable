package com.hgroenenboom.sustainability.persistence;

import com.hgroenenboom.sustainability.data.Source;
import com.hgroenenboom.sustainability.data.SourceRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class SourceRatingService {
    @Autowired
    private SourceRatingRepository repository;

    public SourceRatingService(SourceRatingRepository r) {
        repository = r;
    }

    public SourceRating saveSourceRating(SourceRating newRating) {
        assert(repository != null);
        repository.save(newRating);
        return newRating;
    }

    public List<SourceRating> findAll() {
        return repository.findAll();
    }

    public List<SourceRating> findBySource(Source source) {
        return repository.findBySourceId(source.getId());
    }
}
