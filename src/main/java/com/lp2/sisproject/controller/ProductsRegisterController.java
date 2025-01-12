package com.lp2.sisproject.controller;

import com.lp2.sisproject.util.RedirectWindow;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

// TODO: Add comments JavaDoc.
public class ProductsRegisterController {
    private final RedirectWindow redirectWindow = new RedirectWindow();

    @FXML
    private Button btnManufacturers;

    @FXML
    private Button btnProducts;

    @FXML
    private Button btnRegisterManufacturer;

    @FXML
    void toManufacturers(ActionEvent event) {
        String buttonId = btnManufacturers.getId();
        this.redirectWindow.toWindow(event, buttonId);
    }

    @FXML
    void toProducts(ActionEvent event) {
        String buttonId = btnProducts.getId();
        this.redirectWindow.toWindow(event, buttonId);
    }

    @FXML
    void toRegisterManufacturer(ActionEvent event) {
        String buttonId = btnRegisterManufacturer.getId();
        this.redirectWindow.toWindow(event, buttonId);
    }
}
