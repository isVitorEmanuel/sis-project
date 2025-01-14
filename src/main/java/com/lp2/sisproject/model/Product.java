package com.lp2.sisproject.model;

import java.io.Serializable;

public abstract class Product implements Serializable {
    private String name;
    private long id;
    private double price;
    private int quantity;
    private Manufacturer manufacturer;

    Product(String name, long id, double price, int quantity,Manufacturer manufacturer) {
        this.name = name;
        this.id = id;
        this.price = price;
        this.quantity = quantity;
        this.manufacturer = manufacturer;
    }

    public void setName(String name) { this.name = name; }
    public void setId(long id) { this.id = id; }
    public void setPrice(double price) { this.price = price; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void setManufacturer(Manufacturer manufacturer) { this.manufacturer = manufacturer; }

    public String getName() { return name; }
    public long getId() { return id; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public Manufacturer getManufacturer() { return manufacturer; }
}
