package com.lp2.sisproject.controller;


import com.lp2.sisproject.util.ManipulatingWindow;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class ManufacturersController {
    private final ManipulatingWindow window = new ManipulatingWindow();

    @FXML
    void toProducts(ActionEvent event) {
        this.window.toProductsView(event);
    }

    @FXML
    void toRegisterManufacturer(ActionEvent event) {
        this.window.toRegisterManufacturerView(event);
    }

    @FXML
    void toRegisterProduct(ActionEvent event) {
        this.window.toRegisterProductView(event);
    }
}
