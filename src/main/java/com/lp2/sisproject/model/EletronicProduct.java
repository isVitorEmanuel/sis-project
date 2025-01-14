package com.lp2.sisproject.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EletronicProduct extends Product {
    private String technicalInfo;

   public EletronicProduct(String name, long id, double price, int quantity,Manufacturer manufacturer, String technicalInfo) {
        super(name, id, price, quantity,manufacturer);
        this.technicalInfo = technicalInfo;
    }
}
