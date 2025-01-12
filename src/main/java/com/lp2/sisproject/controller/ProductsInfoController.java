package com.lp2.sisproject.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class ProductsInfoController {

    //Atributos da view
    private Stage stage;
    private Scene scene;
    private Parent root;


    //---------------------- Componentes da view --------------------//
    @FXML
    private Label id;

    @FXML
    private Label nome;

    @FXML
    private Label quantidade;

    @FXML
    private Label valor;

    //TODO: POR NO GRÁFICO o resto dos componentes
    //---------------------- FIM Componentes da view --------------------//

    //---------------------- Funções da view --------------------//

    public void voltarAoMenu(ActionEvent event) {
        String buttonId = ((Button) event.getSource()).getId();
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/lp2/sisproject/products-view.fxml"));
            root = loader.load();

            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

}
