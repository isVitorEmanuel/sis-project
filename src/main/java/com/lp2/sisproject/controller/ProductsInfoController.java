package com.lp2.sisproject.controller;

import com.lp2.sisproject.util.ManipulatingWindow;
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
    private final ManipulatingWindow window = new ManipulatingWindow();

    @FXML
    public void toProducts(ActionEvent event) {
        this.window.toProductsView(event);
    }
}
