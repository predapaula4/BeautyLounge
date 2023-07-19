package com.example.BeautyLounge.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ochi")
public class Ochi  {
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
        this.id = id;
        this.name = name;
        this.category = category;
        this.texture = texture;
        this.quantity = quantity;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTexture() {
        return texture;
    }

    public void setTexture(String texture) {
        this.texture = texture;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
