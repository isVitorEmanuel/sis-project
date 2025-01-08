package com.lp2.sisproject.model;

import com.lp2.sisproject.interfaces.Validatable;

import java.io.Serializable;

public class Address implements Serializable, Validatable {
    private String street;
    private String city;
    private String state;
    private String country;
    private String CEP;

    /*
     * Constructor.
     */
    public Address(String street, String city, String state, String country, String CEP) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.country = country;
        this.CEP = CEP;
    }

    /*
     * Getters.
     */
    public String getStreet() { return street; }
    public String getCity() { return city; }
    public String getState() { return state; }
    public String getCountry() { return country; }
    public String getCEP() { return CEP; }

    /*
     * Setters.
     */
    public void setStreet(String street) { this.street = street; }
    public void setCity(String city) { this.city = city; }
    public void setState(String state) { this.state = state; }
    public void setCountry(String country) { this.country = country; }
    public void setCEP(String CEP) { this.CEP = CEP; }

    @Override
    public boolean isValid() {
        return true;
    }
}
