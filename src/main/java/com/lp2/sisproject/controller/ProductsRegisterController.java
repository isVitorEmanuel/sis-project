package com.lp2.sisproject.controller;

import com.lp2.sisproject.dao.BancoDAO;
import com.lp2.sisproject.model.Manufacturer;
import com.lp2.sisproject.util.RedirectWindow;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.util.ArrayList;

// TODO: Add comments JavaDoc.
public class ProductsRegisterController {
    private final RedirectWindow redirectWindow = new RedirectWindow();

    BancoDAO bancoDAO = BancoDAO.getInstance();

    @FXML private Button btnManufacturers;
    @FXML private Button btnProducts;
    @FXML private Button btnRegisterManufacturer;

    @FXML private ComboBox<Manufacturer> comboBoxManufac;

    @FXML private Button btnSave;

    @FXML private Label sucessLabel;

    @FXML
    void save(ActionEvent event) {
        Manufacturer selectedManufacturer = comboBoxManufac.getValue();

        if (selectedManufacturer != null) {
            System.out.println("Fabricante selecionado: " + selectedManufacturer.getName());
            System.out.println("Fabricante selecionado: " + selectedManufacturer.getCNPJ());
            System.out.println("Fabricante selecionado: " + selectedManufacturer.getAddress());
        } else {
            System.out.println("Nenhum fabricante foi selecionado.");
        }
    }

    public void initialize() {
        ArrayList<Manufacturer> manufacturers = bancoDAO.getManufacturers();
        comboBoxManufac.getItems().addAll(manufacturers);
    }

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
