package com.meridukaan.meri_dukaan.shopkeeper.services;

import com.meridukaan.meri_dukaan.shopkeeper.dtos.LoginRequest;
import com.meridukaan.meri_dukaan.shopkeeper.dtos.RegisterRequest;
import com.meridukaan.meri_dukaan.shopkeeper.entities.Shopkeeper;
import com.meridukaan.meri_dukaan.shopkeeper.repositories.ShopkeeperRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ShopkeeperService {
    private final ShopkeeperRepository repository;
    private final BCryptPasswordEncoder passwordEncoder;

    public ShopkeeperService(ShopkeeperRepository repository, BCryptPasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public String registerShopkeeper(RegisterRequest request) {
        if (repository.findByMobile(request.getMobile()).isPresent()) {
            return "Mobile number already registered!";
        }

        Shopkeeper shopkeeper = new Shopkeeper();
        shopkeeper.setName(request.getName());
        shopkeeper.setMobile(request.getMobile());
        shopkeeper.setAddress(request.getAddress());
        shopkeeper.setLatitude(request.getLatitude());
        shopkeeper.setLongitude(request.getLongitude());
        shopkeeper.setShopName(request.getShopName());
        shopkeeper.setPassword(passwordEncoder.encode(request.getPassword()));

        repository.save(shopkeeper);
        return "Shopkeeper registered successfully!";
    }

    public String loginShopkeeper(LoginRequest request) {
        Optional<Shopkeeper> shopkeeper = repository.findByMobile(request.getMobile());

        if (shopkeeper.isPresent() && passwordEncoder.matches(request.getPassword(), shopkeeper.get().getPassword())) {
            return "Login successful!";
        } else {
            return "Invalid mobile or password!";
        }
    }
}

