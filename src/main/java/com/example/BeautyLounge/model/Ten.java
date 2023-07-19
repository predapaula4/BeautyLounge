package com.example.BeautyLounge.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ten")
public class Ten  {
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

    public Ten(int id, String name, String category, String texture,int quantity,  int price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.quantity = quantity;
        this.texture = texture;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getTexture() {
        return texture;
    }

    public void setTexture(String texture) {
        this.texture = texture;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}