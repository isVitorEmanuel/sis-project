package com.lp2.sisproject.controller;

import com.lp2.sisproject.model.Manufacturer;
import com.lp2.sisproject.util.RedirectWindow;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class ManufacturerInfoController{

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

    public void setManufacturer(Manufacturer manufacturer) {
        cep.setText(cep.getText()+manufacturer.getAddress().getCEP());
        cidade.setText(cidade.getText()+manufacturer.getAddress().getCity());
        cnpj.setText(cnpj.getText()+manufacturer.getCNPJ());
        estado.setText(estado.getText()+manufacturer.getAddress().getState());
        rua.setText(rua.getText()+manufacturer.getAddress().getStreet());
        pais.setText(pais.getText()+manufacturer.getAddress().getCountry());
        nome.setText(nome.getText()+manufacturer.getName());
    }

}
