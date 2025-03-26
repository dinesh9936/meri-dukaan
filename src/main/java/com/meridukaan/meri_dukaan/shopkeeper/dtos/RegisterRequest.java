package com.meridukaan.meri_dukaan.shopkeeper.dtos;


import lombok.Data;

@Data
public class RegisterRequest {

    private String name;
    private String mobile;
    private String address;
    private Double latitude;
    private Double longitude;
    private String shopName;
    private String password;
}
