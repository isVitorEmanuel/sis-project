package com.lp2.sisproject.model;

import java.time.LocalDate;

public class FoodstuffProduct extends Product {
    private LocalDate dateValidity;
    private LocalDate manufactureDate;

   public FoodstuffProduct(String name, long id, double price, int quantity,Manufacturer manufacturer,
                     LocalDate dateValidity, LocalDate manufactureDate) {
        super(name, id, price, quantity,manufacturer);
        this.dateValidity = dateValidity;
        this.manufactureDate = manufactureDate;
    }

    public void setDateValidity(LocalDate dateValidity) { this.dateValidity = dateValidity; }
    public void setManufactureDate(LocalDate manufactureDate) { this.manufactureDate = manufactureDate; }

    public LocalDate getDateValidity() { return dateValidity; }
    public LocalDate getManufactureDate() { return manufactureDate; }
}
