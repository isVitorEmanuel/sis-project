package com.lp2.sisproject.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class FoodstuffProduct extends Product {
    private LocalDate dateValidity;
    private LocalDate manufactureDate;

   public FoodstuffProduct(String name, long id, double price, int quantity,Manufacturer manufacturer,
                     LocalDate dateValidity, LocalDate manufactureDate) {
        super(name, id, price, quantity,manufacturer);
        this.dateValidity = dateValidity;
        this.manufactureDate = manufactureDate;
    }
}
