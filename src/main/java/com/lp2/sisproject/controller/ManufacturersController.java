package com.lp2.sisproject.controller;

import com.lp2.sisproject.dao.BancoDAO;
import com.lp2.sisproject.model.Manufacturer;
import com.lp2.sisproject.util.RedirectWindow;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

// TODO: Add comments JavaDoc.
public class ManufacturersController implements Initializable {
    private final RedirectWindow redirectWindow = new RedirectWindow();

    BancoDAO bancoDAO = BancoDAO.getInstance();
    public ObservableList<Manufacturer> manufacturers = FXCollections.observableArrayList( bancoDAO.getManufacturers());

    @FXML private Button btnProducts;
    @FXML private Button btnRegisterManufacturer;
    @FXML private Button btnRegisterProduct;

    @FXML private TableColumn<Manufacturer, String> manufacturerLocation;
    @FXML private TableColumn<Manufacturer, String> manufacturerCNPJ;
    @FXML private TableColumn<Manufacturer, String> manufacturerName;

    @FXML private TableView<Manufacturer> tableManufacturers;

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

    @FXML
    void toRegisterProduct(ActionEvent event) {
        String buttonId = btnRegisterProduct.getId();
        this.redirectWindow.toWindow(event, buttonId);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (Manufacturer manufacturer : bancoDAO.getManufacturers()) {
            manufacturerCNPJ.setCellValueFactory(new PropertyValueFactory<>("CNPJ"));
            manufacturerName.setCellValueFactory(new PropertyValueFactory<>("name"));
            manufacturerLocation.setCellValueFactory(new PropertyValueFactory<>("address"));

            tableManufacturers.setItems(manufacturers);
        }
    }
}
