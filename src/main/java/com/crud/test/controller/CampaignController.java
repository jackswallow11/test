package com.crud.test.controller;

import com.crud.test.entity.Campaign;
import com.crud.test.service.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CampaignController {

    @Autowired
    private CampaignService service;

    @PostMapping("/addCampaign")
    public Campaign addCampaign(@RequestBody Campaign campaign) {
        return service.saveCampaign(campaign);
    }

    @PostMapping("/addCampaigns")
    public List<Campaign> addCampaigns(@RequestBody List<Campaign> campaigns) {
        return service.saveCampaigns(campaigns);
    }

    @GetMapping("/campaigns")
    public List<Campaign> findAllCampaign() {
        return service.getCampaigns();
    }

    @GetMapping("/campaignById/{id}")
    public Campaign findCampaignById(@PathVariable int id) {
        return service.getCampaignById(id);
    }

    @GetMapping("/campaign/{name}")
    public Campaign findCampaignByName(@PathVariable String name) {
        return service.getCampaignByName(name);
    }

    @PutMapping("/update")
    public Campaign updateCampaign(@RequestBody Campaign campaign) {
        return service.updateCampaign(campaign);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCampaign(@PathVariable int id) {
        return service.deleteCampaign(id);
    }
}


 