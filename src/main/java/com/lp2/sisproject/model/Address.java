package com.lp2.sisproject.model;

import com.lp2.sisproject.interfaces.Validatable;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address implements Serializable, Validatable {
    private String street;
    private String city;
    private String state;
    private String country;
    private String CEP;

    @Override
    public boolean isValid() {
        return true;
    }

    @Override
    public String toString() {
        return getCountry() + " - " + getState() + " - " + getCEP();
    }
}
