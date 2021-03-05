package com.crud.test.repository;

import com.crud.test.entity.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampaignRepository extends JpaRepository<Campaign,Integer> {
    Campaign findByName(String name);
}
