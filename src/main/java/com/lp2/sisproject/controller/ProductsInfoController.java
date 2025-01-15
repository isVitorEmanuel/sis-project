package com.lp2.sisproject.controller;

import com.lp2.sisproject.dao.BancoDAO;
import com.lp2.sisproject.model.ClothingProduct;
import com.lp2.sisproject.model.EletronicProduct;
import com.lp2.sisproject.model.FoodstuffProduct;
import com.lp2.sisproject.model.Product;
import com.lp2.sisproject.util.RedirectWindow;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

// TODO: Add comments JavaDoc and implementation.
public class ProductsInfoController {

    private final RedirectWindow redirectWindow = new RedirectWindow();

    @FXML
    private Button btnRegisterProduct;

    @FXML
    private Button btnProducts;

    @FXML
    private Button btnRegisterManufacturer;

    @FXML
    private VBox details;

    @FXML
    private VBox productDetails;

    @FXML
    private VBox clothingProductDetails;

    @FXML
    private VBox eletronicProductDetails;

    @FXML
    private VBox foodProductDetails;

    @FXML
    private Label dataDeFabricacao;

    @FXML
    private Label dataDeValidade;

    @FXML
    private Label id;

    @FXML
    private Label informacaoTecnica;

    @FXML
    private Label nome;

    @FXML
    private Label quantidade;

    @FXML
    private Label tamanho;

    @FXML
    private Label valor;

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


    public void setProduct(Product product) {
        quantidade.setText(quantidade.getText() + product.getQuantity());
        valor.setText(valor.getText() + product.getPrice());
        nome.setText(nome.getText()+product.getName());
        id.setText(id.getText()+product.getId());
        if(product instanceof FoodstuffProduct fp){
            dataDeValidade.setText(dataDeValidade.getText() + fp.getDateValidity());
            dataDeFabricacao.setText(dataDeFabricacao.getText() + fp.getManufactureDate());

            eletronicProductDetails.setVisible(false);
            clothingProductDetails.setVisible(false);

            details.getChildren().setAll(productDetails,foodProductDetails);
        }
        else if(product instanceof EletronicProduct e){
            informacaoTecnica.setText(informacaoTecnica.getText()+e.getTechnicalInfo());

            foodProductDetails.setVisible(false);
            clothingProductDetails.setVisible(false);

            details.getChildren().setAll(productDetails,eletronicProductDetails);
        }else if(product instanceof ClothingProduct c){
            tamanho.setText(tamanho.getText()+c.getSize().toString());

            foodProductDetails.setVisible(false);
            eletronicProductDetails.setVisible(false);

            details.getChildren().setAll(productDetails,clothingProductDetails);
        }
    }
}
