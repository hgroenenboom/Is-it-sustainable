package com.hgroenenboom.sustainability.api;

import com.hgroenenboom.sustainability.data.Organization;
import com.hgroenenboom.sustainability.data.OrganizationTags;
import com.hgroenenboom.sustainability.persistence.OrganizationService;
import com.hgroenenboom.sustainability.persistence.OrganizationTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/organization")
public class OrganizationAPI {
    @Autowired
    private OrganizationService organizationService;
    private OrganizationTagService organizationTagService;

    public OrganizationAPI(OrganizationService organizationService, OrganizationTagService organizationTagService) {
        this.organizationService = organizationService;
        this.organizationTagService = organizationTagService;
    }

    @GetMapping("/getAll")
    List<Organization> getAll() {
        return organizationService.getAll();
    }

    @PostMapping("/save")
    void save(@RequestBody Organization o) throws Exception {
        // Add unsaved tags
        for(OrganizationTags tag : o.getOrganizationTags())
            if(tag != null)
               if(tag.getId() == null || organizationTagService.findById(tag.getId()).isEmpty())
                   organizationTagService.save(tag);

        organizationService.save(o);
    }

    @GetMapping("/getById")
    Organization getById(@RequestParam("id") Long i) {
        return organizationService.findById(i).get();
    }

    @GetMapping("/getNameById")
    String getNameById(@RequestParam("id") Long id) {
        return getById(id).getName();
    }

    @GetMapping("/getNamesByIds")
    String[] getNamesById(@RequestParam("ids") Long[] ids) {
        String[] names = new String[ids.length];
        for(int i = 0; i < ids.length; i++)
            names[i] = getNameById(ids[i]);
        return names;
    }

    @GetMapping("/findByName")
    List<Organization> findByName(@RequestParam("name") String name) {
        return this.organizationService.findByName(name);
    }

    @GetMapping("/getTags")
    List<OrganizationTags> getAllTags() {
        return this.organizationTagService.getAll();
    }

    @GetMapping("/findTagByTagName")
    List<OrganizationTags> findTagByTagName(@RequestParam("name") String name) {
        List<OrganizationTags> s = this.organizationTagService.findSimilar(name);
        return s;
    }
}
