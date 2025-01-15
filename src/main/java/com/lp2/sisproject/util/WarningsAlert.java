package com.lp2.sisproject.util;

import javafx.scene.control.Alert;

public class WarningsAlert {
    public static void blankValues() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Alerta");
        alert.setHeaderText("Campos obrigatórios");
        alert.setContentText("Preencha todos os campos");
        alert.show();
    }

    public static void invalidValues() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Alerta");
        alert.setHeaderText("Valores inválidos");
        alert.setContentText("Os valores informados não são válidos");
        alert.show();
    }
}
