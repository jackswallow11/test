package com.crud.test.service;

import com.crud.test.entity.Campaign;
import com.crud.test.repository.CampaignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampaignService {
    @Autowired
    private CampaignRepository repository;
    public Campaign saveCampaign(Campaign campaign) {
        return repository.save(campaign);
    }

    public List<Campaign> saveCampaigns(List<Campaign> campaigns) {
        return repository.saveAll(campaigns);
    }

    public List<Campaign> getCampaigns() {
        return repository.findAll();
    }

    public Campaign getCampaignById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Campaign getCampaignByName(String name) {
        return repository.findByName(name);
    }

    public String deleteCampaign(int id) {
        repository.deleteById(id);
        return "campaign removed !! " + id;
    }
    public Campaign updateCampaign(Campaign campaign) {
        Campaign existingCampaign = repository.findById(campaign.getId()).orElse(null);
        existingCampaign.setName(campaign.getName());
        existingCampaign.setDescription(campaign.getDescription());
        existingCampaign.setFund_target(campaign.getFund_target());
        return repository.save(existingCampaign);
    }


}
