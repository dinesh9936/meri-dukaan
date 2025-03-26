package com.meridukaan.meri_dukaan.shopkeeper.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meridukaan.meri_dukaan.shopkeeper.entities.Shopkeeper;

import java.util.Optional;

public interface ShopkeeperRepository extends JpaRepository<Shopkeeper, Long> {
    Optional<Shopkeeper> findByMobile(String mobile);
}