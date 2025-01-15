package com.lp2.sisproject.controller;

import com.lp2.sisproject.util.RedirectWindow;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ManufacturerInfoController {

    private final RedirectWindow redirectWindow = new RedirectWindow();

    @FXML
    private Button btnManufacturers;

    @FXML
    private Button btnRegisterManufacturer;

    @FXML
    private Button btnRegisterProduct;

    @FXML
    private Label cep;

    @FXML
    private Label cidade;

    @FXML
    private Label cnpj;

    @FXML
    private Label estado;

    @FXML
    private Label nome;

    @FXML
    private Label pais;

    @FXML
    private Label rua;
    //TODO: finish manufacturerInfo controller.

    @FXML
    void toProducts(ActionEvent event) {
        String buttonId = btnManufacturers.getId();
        this.redirectWindow.toWindow(event, buttonId);
    }

    @FXML
    void toRegisterManufacturer(ActionEvent event) {
        String buttonId = btnRegisterManufacturer.getId();
        this.redirectWindow.toWindow(event, buttonId);
    }

    @FXML
    void toRegisterProduct(ActionEvent event) {
        String buttonId = btnRegisterProduct.getId();
        this.redirectWindow.toWindow(event, buttonId);
    }

}
