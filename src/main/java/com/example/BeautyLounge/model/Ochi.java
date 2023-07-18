package com.example.BeautyLounge.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ochi")
public class Ochi extends BeautyLounge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "category")
    private String category;

    @Column(name = "texture")
    private String texture;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "price")
    private int price;

    public Ochi() {
    }

    public Ochi(int id, String name, String category, String texture, int quantity, int price) {
        super();
    }
}
