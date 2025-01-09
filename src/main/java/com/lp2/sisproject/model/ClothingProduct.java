package com.lp2.sisproject.model;

import com.lp2.sisproject.enums.Size;
import com.lp2.sisproject.enums.TypeProduct;

public class ClothingProduct extends Product {
    private static final TypeProduct typeProduct = TypeProduct.CLOTHING_PRODUCT; //Deixar assim ou setar no construtor?
    private Size size;

    public ClothingProduct(
            String name,
            long id,
            double price,
            int quantity,
            Size size) {
        super(name, id, price, quantity);
        this.size = size;
    }

    public Size getSize() { return size; }

    public void setSize(Size size) { this.size = size; }
}
