package com.lp2.sisproject.model;

public abstract class Product {
    private String name;
    private long id;
    private double price;
    private int quantity;

    Product(String name, long id, double price, int quantity) {
        this.name = name;
        this.id = id;
        this.price = price;
        this.quantity = quantity;
    }

    public void setName(String name) { this.name = name; }
    public void setId(long id) { this.id = id; }
    public void setPrice(double price) { this.price = price; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public String getName() { return name; }
    public long getId() { return id; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
}
