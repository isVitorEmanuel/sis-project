package com.lp2.sisproject.controller;

import com.lp2.sisproject.dao.BancoDAO;
import com.lp2.sisproject.model.Product;
import com.lp2.sisproject.util.RedirectWindow;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
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

        //TODO: Ajeitar para permitir redirect do jeito que está na classe.

        TableProducts.setOnMouseClicked(event -> {
            if(event.getClickCount() == 2){
                Product selectedProduct = TableProducts.getSelectionModel().getSelectedItem();
                if(selectedProduct != null){
                    try{

                            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/lp2/sisproject/product-info-view.fxml"));
                    Parent root = loader.load();

                    ProductsInfoController controller = loader.getController();
                    controller.setProduct(selectedProduct);

                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();

                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
            }

        });
    }

    private void redirectToProductInfo(Product product){

    }
}
