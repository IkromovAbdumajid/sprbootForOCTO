package com.company.service;

import com.company.dto.AuthDTO;
import com.company.dto.ProfileDTO;
import com.company.entity.ProfileEntity;
import com.company.entity.enums.ProfileStatus;
import com.company.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService {

    private final ProfileRepository profileRepository;

    public ProfileDTO registration(ProfileDTO dto) {

        if (profileRepository.existsByPhone(dto.getPhone())) {
            log.warn("Phone is already registrated");
            throw new RuntimeException("Phone is already registrated");
        }


        ProfileEntity entity = new ProfileEntity();
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setPhone(dto.getPhone());
        entity.setLogin(dto.getLogin());
        entity.setRole(dto.getRole());
        entity.setPassword(dto.getPassword());
        entity.setStatus(ProfileStatus.ACTIVE);
        profileRepository.save(entity);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        entity.setPassword(encoder.encode(dto.getPassword()));

        dto.setId(entity.getId());
        dto.setCreatedAt(entity.getCreatedAt());
        log.debug("New User signed up: {}", dto);
        return dto;
    }

    public ProfileDTO login(AuthDTO dto) {

        return null;
    }

}
