package com.lp2.sisproject.controller;

import com.lp2.sisproject.util.ManipulatingWindow;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class ManufacturerRegisterController {
    private final ManipulatingWindow window = new ManipulatingWindow();

    @FXML
    void toManufacturers(ActionEvent event) {
        this.window.toManufacturersView(event);
    }

    @FXML
    void toProducts(ActionEvent event) {
        this.window.toProductsView(event);
    }

    @FXML
    void toRegisterProduct(ActionEvent event) {
        this.window.toRegisterProductView(event);
    }
}
