package com.lp2.sisproject.model;

public class EletronicProduct extends Product {
    private String technicalInfo;

    EletronicProduct(String name, long id, double price, int quantity, String technicalInfo) {
        super(name, id, price, quantity);
        this.technicalInfo = technicalInfo;
    }

    public void setTechnicalInfo(String technicalInfo) { this.technicalInfo = technicalInfo; }

    public String getTechnicalInfo() { return technicalInfo; }
}
