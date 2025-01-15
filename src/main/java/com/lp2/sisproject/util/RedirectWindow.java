package com.lp2.sisproject.util;

import com.lp2.sisproject.controller.ProductsInfoController;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;

// TODO: Add comments JavaDoc.
public class RedirectWindow {


    // TODO: Add comments JavaDoc.
    private static String getWindowURL(String buttonId){
    String defaultPath = "/com/lp2/sisproject/";
        Map<String, String> buttonIdToFXMLMap = Map.of(
                "btnRegisterManufacturer", defaultPath + "manufacturer-register-view.fxml",
                "btnRegisterProduct", defaultPath+"products-register-view.fxml",
                "btnProducts", defaultPath+"products-view.fxml",
                "btnManufacturers", defaultPath+"manufacturers-view.fxml",
                "btnProductInfo",defaultPath+"products-info-view.fxml",
                "btnManufacturerInfo",defaultPath+"manufacturer-info-view.fxml"
        );

        return buttonIdToFXMLMap.getOrDefault(buttonId, null);
    }

    // TODO: Add comments JavaDoc.
    public void toWindow(ActionEvent event, String buttonId) {
        try {
            String url = getWindowURL(buttonId);

            // TODO: Create a customize exception.
            if (url == null) { throw new Exception(); }

            FXMLLoader loader = new FXMLLoader(getClass().getResource(url));
            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            // TODO: Handle exception.
        }
    }

    public void toWindow(MouseEvent event, String buttonId) {
        try{
            String url = getWindowURL(buttonId);

            FXMLLoader loader = new FXMLLoader(getClass().getResource(url));
            Parent root = loader.load();

            if(buttonId.equals("btnProductInfo")){
            ProductsInfoController controller = loader.getController();
            }else{
            //TODO: if manufacturer, load his controller
            }
        }catch (IOException e){

        }
    }
}
