package com.meridukaan.meri_dukaan.shopkeeper.dtos;

import lombok.Data;

@Data
public class LoginRequest {
    private String mobile;
    private String password;
}
