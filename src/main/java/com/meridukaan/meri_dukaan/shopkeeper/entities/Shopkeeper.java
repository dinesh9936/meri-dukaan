package com.meridukaan.meri_dukaan.shopkeeper.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "shopkeepers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Shopkeeper {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String mobile;
    private String address;
    private Double latitude;
    private Double longitude;
    private String shopName;
    private String password;
}
