package com.lp2.sisproject.dao;

import com.lp2.sisproject.model.Manufacturer;
import com.lp2.sisproject.model.Product;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class BancoDAO {
    private ArrayList<Product> products;

    private ArrayList<Manufacturer> manufacturers;

    private static BancoDAO bancoDAO;

    private BancoDAO() {
        products = new ArrayList<>();
    }
    public static BancoDAO getInstance() {
        if (bancoDAO == null) {
            bancoDAO = new BancoDAO();
        }
        return bancoDAO;
    }
    public ArrayList<Product> getProdutos() {
        return products;
    }
    public ArrayList<Manufacturer> getManufacturers() {
        return manufacturers;
    }
}
