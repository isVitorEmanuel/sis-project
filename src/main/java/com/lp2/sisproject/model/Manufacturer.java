package com.lp2.sisproject.model;

import com.lp2.sisproject.interfaces.Validatable;

import java.io.Serializable;

public class Manufacturer implements Serializable, Validatable {
    private String name;
    private String CNPJ;
    private Address address;
}
