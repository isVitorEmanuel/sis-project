package com.lp2.sisproject.controller;

import com.lp2.sisproject.model.Address;
import com.lp2.sisproject.model.Manufacturer;
import com.lp2.sisproject.util.RedirectWindow;
import com.sun.tools.jconsole.JConsoleContext;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

// TODO: Add comments JavaDoc.
public class ManufacturerRegisterController {
    private final RedirectWindow redirectWindow = new RedirectWindow();

    @FXML private Button btnManufacturers;
    @FXML private Button btnProducts;
    @FXML private Button btnRegisterProduct;
    @FXML private Button btnSave;

    @FXML private TextField fieldCEP;
    @FXML private TextField fieldCNPJ;
    @FXML private TextField fieldCity;
    @FXML private TextField fieldCountry;
    @FXML private TextField fieldName;
    @FXML private TextField fieldState;
    @FXML private TextField fieldStreet;

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
    void toRegisterProduct(ActionEvent event) {
        String buttonId = btnRegisterProduct.getId();
        this.redirectWindow.toWindow(event, buttonId);
    }

    @FXML
    void save(ActionEvent event) {
        String name = fieldName.getText();
        String CNPJ = fieldCNPJ.getText();
        String state = fieldState.getText();
        String street = fieldStreet.getText();
        String city = fieldCity.getText();
        String country = fieldCountry.getText();
        String CEP = fieldCEP.getText();

        if (name.isBlank() || state.isBlank() ||
            street.isBlank() || city.isBlank() ||
            country.isBlank() || CEP.isBlank() || CNPJ.isBlank()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Alerta");
            alert.setHeaderText("Campos obrigatórios");
            alert.setContentText("Preencha todos os campos");
            alert.show();
        } else {
            Address newAddress = new Address(street, city, state, country, CEP);
            Manufacturer manufacturer = new Manufacturer(name, CNPJ, newAddress);

            // TODO: Implement the save logic in bancoDAO.
        }
    }
}
