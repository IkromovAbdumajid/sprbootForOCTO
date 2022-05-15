package com.company.domi.repository;

import com.company.domi.entity.PurchasedProductsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchasedProductsRepository extends JpaRepository<PurchasedProductsEntity,Integer> {
}
