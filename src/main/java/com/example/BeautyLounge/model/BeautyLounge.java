package com.example.BeautyLounge.model;

import jakarta.persistence.*;

@Entity
@Table(name="beauty_lounge")
public class BeautyLounge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String category;
    private int quantity;
    private String texture;
    private int price;

    public BeautyLounge() {
    }

    public BeautyLounge(int id, String name, int quantity, String texture, int price, String category) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.texture = texture;
        this.price = price;
        this.category = category;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
