package com.example.BeautyLounge.model;

public class Ochi {
    private int id;
    private String name;
    private int quantity;
    private String texture;
    //matte, glitter, cream, metallic
    private int price;

    public Ochi(int id, String name, int quantity, String texture, int price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.texture = texture;
        this.price = price;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public int getQuantity() { return quantity; }

    public void setQuantity(int quantity) { this.quantity = quantity; }

    public String getTexture() { return texture; }

    public void setTexture(String texture) { this.texture = texture; }

    public int getPrice() { return price; }

    public void setPrice(int price) { this.price = price; }
}
