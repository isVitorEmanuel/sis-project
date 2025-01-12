package com.lp2.sisproject;

import com.lp2.sisproject.dao.BancoDAO;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    BancoDAO banco = BancoDAO.getInstance();

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("products-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("SisCaixa");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}