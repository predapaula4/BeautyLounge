package com.example.BeautyLounge.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "eyebrows")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Eyebrows {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @Column(name = "name")
    private String name;

    @Column(name = "category")
    private String category;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "texture")
    private String texture;

    @Column(name = "price")
    private int price;

    public int getBrandCode() {
        return brand.getBrandCode();
    }

    public String getBrandName() {
        return brand.getBrandName();
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}
