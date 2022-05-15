package com.company.domi.service;

import com.company.domi.dto.LikeDTO;

import com.company.domi.entity.LikeEntity;
import com.company.domi.entity.ProductEntity;
import com.company.domi.entity.ProfileEntity;
import com.company.domi.exception.ItemNotFoundException;
import com.company.domi.repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LikeService {
    @Autowired
    private LikeRepository likeRepository;
    @Autowired
    private ProfileService profileService;
    @Autowired
    ProductService productService;

    public LikeEntity toEntity(LikeDTO dto) {
        LikeEntity entity = new LikeEntity();
        ProfileEntity profile = profileService.get(dto.getProfileId());

        ProductEntity productEntity=productService.get(dto.getProductId());

        entity.setId(dto.getId());
        entity.setProfile(profile);
        entity.setCreatedDate(dto.getCreatedDate());
        entity.setProductEntity(productEntity);

        return entity;
    }

    public LikeDTO toDto(LikeEntity entity) {
        LikeDTO dto = new LikeDTO();

        dto.setId(entity.getId());
        dto.setProfileId(entity.getProfile().getId());
        dto.setCreatedDate(entity.getCreatedDate());
        dto.setProductId(entity.getProductEntity().getId());

        return dto;
    }

    public LikeDTO createLike(LikeDTO dto) {
        dto.setCreatedDate(LocalDateTime.now());
        dto.setProfileId(dto.getProfileId());
        dto.setProductId(dto.getProductId());

        LikeEntity entity = toEntity(dto);
        likeRepository.save(entity);
        dto.setId(entity.getId());

        return dto;
    }

    public void deleteById(Long id) {
        likeRepository.deleteById(id);
    }

    public LikeEntity get(Long id) {
        return likeRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException("Like not Found"));
    }


}
