package com.hgroenenboom.sustainability.persistence;

import com.hgroenenboom.sustainability.data.Source;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SourceService {
    @Autowired private SourceRepository repository;

    public SourceService(SourceRepository repository) {
        this.repository = repository;
    }

    public Source saveSource(Source source) {
        return repository.save(source);
    }

    public List<Source> findAll() {
        return repository.findAll();
    }
}
