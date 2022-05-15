package com.company.service;

import com.company.dto.ProfileDTO;
import com.company.entity.ProfileEntity;
import com.company.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProfileService {

    private final ProfileRepository profileRepository;

    public ProfileDTO toDto(ProfileEntity entity) {
        if (entity == null)
            return null;

        ProfileDTO dto = new ProfileDTO();

        dto.setName(entity.getName());
        dto.setSurname(entity.getSurname());
        dto.setPhone(entity.getPhone());
        dto.setLogin(entity.getLogin());
        dto.setPassword(entity.getPassword());
        dto.setStatus(entity.getStatus());
        dto.setId(entity.getId());
        dto.setCreatedAt(entity.getCreatedAt());

        return dto;
    }

    public ProfileDTO create(ProfileDTO dto) {

        if (profileRepository.existsByPhone(dto.getPhone())) {
            log.warn("Phone is already exists");
            throw new RuntimeException("Phone is already exists");
        }

        String password = DigestUtils.md5Hex(dto.getPassword());

        ProfileEntity entity = new ProfileEntity();
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setPhone(dto.getPhone());
        entity.setLogin(dto.getLogin());
        entity.setPassword(password);

        entity.setStatus(dto.getStatus());

        profileRepository.save(entity);
        dto.setId(entity.getId());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setPassword(password);
        log.debug("New User signed up: {}", dto);
        return dto;
    }

    public void test() {

    }


}
