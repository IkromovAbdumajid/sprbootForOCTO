package com.company.domi.service;

import com.company.domi.dto.product.DescriptionDTO;
import com.company.domi.entity.DescriptionEntity;
import com.company.domi.repository.DescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DescriptionService {
    @Autowired
    private DescriptionRepository descriptionRepository;

    public DescriptionDTO create(DescriptionDTO dto) {
        DescriptionEntity descriptionEntity = new DescriptionEntity();
        descriptionEntity.setRangi(dto.getRangi());
        descriptionEntity.setDiagonal(dto.getDiagonal());
        descriptionEntity.setФонарик(dto.getФонарик());
        descriptionEntity.setProtsessor(dto.getTip_protsessora());
        descriptionEntity.setАудио(dto.getАудио());
        descriptionEntity.setВес(dto.getВес());
        descriptionEntity.setСтандарт(dto.getСтандарт());

        descriptionRepository.save(descriptionEntity);
        dto.setId(descriptionEntity.getId());
        return dto;
    }

    public DescriptionEntity get(Integer id) {
        Optional<DescriptionEntity> optional = descriptionRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        throw new RuntimeException("not found");
    }
}
