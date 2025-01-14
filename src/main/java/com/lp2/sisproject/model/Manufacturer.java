package com.lp2.sisproject.model;

import com.lp2.sisproject.interfaces.Validatable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Manufacturer implements Serializable, Validatable {
    private String name;
    private String CNPJ;
    private Address address;

    @Override
    public boolean isValid() {
        return true;
    }
}
