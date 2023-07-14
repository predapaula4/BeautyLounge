package com.example.BeautyLounge.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Ochi extends BeautyLounge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

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

    public Ochi() {
    }

    public Ochi(int id, String name, String category, int quantity, String texture, int price) {
        super();
    }
}
