package com.hgroenenboom.sustainability.persistence;

import com.hgroenenboom.sustainability.data.SourceRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class SourceRatingService {
    @Autowired
    private SourceRatingRepository repository;

    public SourceRatingService(SourceRatingRepository r) {
        repository = r;
    }

    public void saveSourceRating(SourceRating newRating) {
        assert(repository != null);
        repository.save(newRating);
    }
}
