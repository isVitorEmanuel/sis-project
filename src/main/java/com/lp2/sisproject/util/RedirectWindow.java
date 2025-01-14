package com.lp2.sisproject.util;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Map;

// TODO: Add comments JavaDoc.
public class RedirectWindow {

    // TODO: Add comments JavaDoc.
    private static String getWindowURL(String buttonId){
        Map<String, String> buttonIdToFXMLMap = Map.of(
                "btnRegisterManufacturer", "/com/lp2/sisproject/manufacturer-register-view.fxml",
                "btnRegisterProduct", "/com/lp2/sisproject/products-register-view.fxml",
                "btnProducts", "/com/lp2/sisproject/products-view.fxml",
                "btnManufacturers", "/com/lp2/sisproject/manufacturers-view.fxml"
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
}
