package com.lp2.sisproject.model;

import com.lp2.sisproject.interfaces.Validatable;

import java.io.Serializable;

public class Manufacturer implements Serializable, Validatable {
    private String name;
    private String CNPJ;
    private Address address;

    Manufacturer(String name, String CNPJ, Address address) {
        this.name = name;
        this.CNPJ = CNPJ;
        this.address = address;
    }

    public void setName(String name) { this.name = name; }
    public void setCNPJ(String CNPJ) { this.CNPJ = CNPJ; }
    public void setAddress(Address address) { this.address = address; }

    public String getName() { return name; }
    public String getCNPJ() { return CNPJ; }
    public Address getAddress() { return address; }

    @Override
    public boolean isValid() {
        return true;
    }
}
