package com.lp2.sisproject.controller;

import com.lp2.sisproject.dao.BancoDAO;
import com.lp2.sisproject.model.Product;
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
public class ProductsController implements Initializable {

    BancoDAO banco = BancoDAO.getInstance();

    public ObservableList<Product> products = FXCollections.observableArrayList( banco.getProdutos());

    private final RedirectWindow redirectWindow = new RedirectWindow();

    @FXML
    private Button btnManufacturers;

    @FXML
    private Button btnRegisterManufacturer;

    @FXML
    private Button btnRegisterProduct;

    @FXML
    private TableColumn<Product, Long> productId;

    @FXML
    private TableColumn<Product, String> productName;

    @FXML
    private TableColumn<Product, Integer> productQuantity;

    @FXML
    private TableView<Product> TableProducts;

    @FXML
    private void toRegisterProduct(ActionEvent event) {
        String buttonId = btnRegisterProduct.getId();
        this.redirectWindow.toWindow(event, buttonId);
    }

    @FXML
    private void toRegisterManufacturer(ActionEvent event) {
        String buttonId = btnRegisterManufacturer.getId();
        this.redirectWindow.toWindow(event, buttonId);
    }

    @FXML
    private void toManufacturers(ActionEvent event) {
        String buttonId = btnManufacturers.getId();
        this.redirectWindow.toWindow(event, buttonId);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for(Product p: banco.getProdutos()){
            productId.setCellValueFactory(new PropertyValueFactory<>("id"));
            productName.setCellValueFactory(new PropertyValueFactory<>("name"));
            productQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));

            TableProducts.setItems(products);
        }
    }
}
