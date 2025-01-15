package com.lp2.sisproject.controller;

import com.lp2.sisproject.dao.BancoDAO;
import com.lp2.sisproject.enums.TypeProduct;
import com.lp2.sisproject.model.EletronicProduct;
import com.lp2.sisproject.model.Manufacturer;
import com.lp2.sisproject.util.NumberCheck;
import com.lp2.sisproject.util.RedirectWindow;
import com.lp2.sisproject.util.WarningsAlert;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.util.Duration;

import java.util.ArrayList;

// TODO: Add comments JavaDoc.
public class ProductsRegisterController {
    private final RedirectWindow redirectWindow = new RedirectWindow();

    BancoDAO bancoDAO = BancoDAO.getInstance();

    private TypeProduct typeProduct;

    @FXML private Button btnManufacturers;
    @FXML private Button btnProducts;
    @FXML private Button btnRegisterManufacturer;

    @FXML
    private HBox hbManufacture;

    @FXML private HBox hbSize;
    @FXML private HBox hbSpecs;
    @FXML private HBox hbValidity;

    @FXML private ComboBox<Manufacturer> comboBoxManufac;
    @FXML private TextField inputName;
    @FXML private TextField inputQuantity;
    @FXML private TextField inputValue;
    @FXML private TextArea textAreaSpec;
    @FXML private Label sucessLabel;

    @FXML
    void save() {
        System.out.println("Entrou n save");
        if (this.typeProduct == TypeProduct.TECH_PRODUCT) {
            Manufacturer selectedManufacturer = comboBoxManufac.getValue();
            if (!this.validatedInputTech(selectedManufacturer)) return;

            EletronicProduct eletronicProduct = new EletronicProduct(inputName.getText(), 0,
                                                        Double.parseDouble(inputValue.getText()),
                                                        Integer.parseInt(inputQuantity.getText()),
                                                        selectedManufacturer, textAreaSpec.getText());

            if (!eletronicProduct.isValid()) {
                WarningsAlert.invalidValues();
                return;
            }

            System.out.println("Valido");
        }

        if (this.typeProduct == TypeProduct.CLOTHING_PRODUCT) {}

        System.out.println("Caiu aui");
        Timeline timeline = new Timeline(new KeyFrame(
                Duration.seconds(3),
                _ -> sucessLabel.setVisible(false)
        ));

        timeline.setCycleCount(1);
        timeline.play();
    }

    public void initialize() {
        ArrayList<Manufacturer> manufacturers = bancoDAO.getManufacturers();
        comboBoxManufac.getItems().addAll(manufacturers);
        this.disableAllSpecificFields();
    }

    private void disableAllSpecificFields() {
        hbSpecs.setDisable(true);
        hbSize.setDisable(true);
        hbValidity.setDisable(true);
        hbManufacture.setDisable(true);
    }

    private boolean validatedInputTech(Manufacturer manufacturer) {
        if (manufacturer == null || this.inputName.getText().isBlank() ||
            this.inputQuantity.getText().isBlank() || this.inputValue.getText().isBlank()) {
            WarningsAlert.blankValues();
            return false;
        }

        if (this.textAreaSpec.getText().isBlank()) {
            WarningsAlert.blankValues();
            return false;
        }

        if (!NumberCheck.isDouble(inputValue.getText()) ||
            !NumberCheck.isInt(inputQuantity.getText())) {
            WarningsAlert.invalidValues();
            return false;
        }
        return true;
    }

    @FXML
    void selectElectronics() {
        disableAllSpecificFields();
        hbSpecs.setDisable(false);
        this.typeProduct = TypeProduct.TECH_PRODUCT;
    }

    @FXML
    void selectClothing() {
        disableAllSpecificFields();
        hbSize.setDisable(false);
        this.typeProduct = TypeProduct.CLOTHING_PRODUCT;
    }

    @FXML
    void selectFood() {
        disableAllSpecificFields();
        hbValidity.setDisable(false);
        hbManufacture.setDisable(false);
        this.typeProduct = TypeProduct.FOOD_PRODUCT;
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
