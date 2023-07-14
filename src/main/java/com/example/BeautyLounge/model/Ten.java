package com.example.BeautyLounge.model;

public class Ten {
    private int id;
    private String name;
    private int quantity;
    private String texture;
    //creamy, mouse, liquid
    private int price;

    public Ten(int id,String name, int quantity, String texture, int price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.texture = texture;
        this.price=price;
    }
    public Ten(){

    }
    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getTexture() {
        return texture;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setTexture(String texture) {
        this.texture = texture;
    }

    public void setId(int id) {
        this.id = id;
    }
}
