package com.meridukaan.meri_dukaan.shopkeeper.controllers;

import com.meridukaan.meri_dukaan.shopkeeper.dtos.LoginRequest;
import com.meridukaan.meri_dukaan.shopkeeper.dtos.RegisterRequest;
import com.meridukaan.meri_dukaan.shopkeeper.services.ShopkeeperService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/shopkeeper")
public class ShopkeeperController {
    private final ShopkeeperService service;

    public ShopkeeperController(ShopkeeperService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) {
        return service.registerShopkeeper(request);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        return service.loginShopkeeper(request);
    }
}
