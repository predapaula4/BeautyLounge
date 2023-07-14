package com.example.BeautyLounge.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ten")
public class Ten extends BeautyLounge {
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

    public Ten() {

    }
    public Ten(int id, String name, String category, int quantity, String texture, int price) {
        super();
    }
}