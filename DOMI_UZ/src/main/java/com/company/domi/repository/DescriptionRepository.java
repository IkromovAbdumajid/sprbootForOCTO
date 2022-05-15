package com.company.domi.repository;

import com.company.domi.entity.DescriptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DescriptionRepository extends JpaRepository<DescriptionEntity,Integer> {
}
