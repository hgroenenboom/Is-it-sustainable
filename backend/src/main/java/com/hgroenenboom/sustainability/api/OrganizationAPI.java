package com.hgroenenboom.sustainability.api;

import com.hgroenenboom.sustainability.data.Organization;
import com.hgroenenboom.sustainability.persistence.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/organization")
public class OrganizationAPI {
    @Autowired
    private OrganizationService organizationService;

    public OrganizationAPI(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @GetMapping("/getAll")
    List<Organization> getAll() {
        return organizationService.getAll();
    }

    @PostMapping("/save")
    void save(@RequestBody Organization o) {

        organizationService.save(o);
    }
}
