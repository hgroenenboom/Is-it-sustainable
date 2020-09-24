package com.hgroenenboom.sustainability.api;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/organization")
public class OrganizationAPI {
    @GetMapping("/getAll")
    String getAll() {
        return "test";
    }
}
