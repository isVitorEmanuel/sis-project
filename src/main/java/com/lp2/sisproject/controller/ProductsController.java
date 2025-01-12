package com.lp2.sisproject.controller;

import com.lp2.sisproject.util.ManipulatingWindow;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

/**
 * Add documentation.
 */
public class ProductsController {
    private final ManipulatingWindow window = new ManipulatingWindow();

    // Functions to manipulate windows.
    @FXML
    private void toRegisterProduct(ActionEvent event) {
        this.window.toRegisterProductView(event);
    }

    @FXML
    private void toRegisterManufacturer(ActionEvent event) {
        this.window.toRegisterManufacturerView(event);
    }

    @FXML
    private void toManufacturer(ActionEvent event) {
        this.window.toManufacturersView(event);
    }
}
