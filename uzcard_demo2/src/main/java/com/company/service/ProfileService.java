package com.company.service;

import com.company.entity.ProfileEntity;
import com.company.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ProfileService {
    @Autowired
    private ProfileRepository profileRepository;

    public void create(ProfileEntity entity) {
        entity.setCreatedDate(LocalDateTime.now());
        profileRepository.save(entity);
    }

    public ProfileEntity get(Integer id) {
        return this.profileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Profile Not found"));
    }
}
