package com.company.repository;

import com.company.entity.ProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfileRepository extends JpaRepository<ProfileEntity, Long> {

    Optional<ProfileEntity> findByPhone(String phone);

    Optional<ProfileEntity> findByLogin(String login);

    boolean existsByPhone(String phone);

}
