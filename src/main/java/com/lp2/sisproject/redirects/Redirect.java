package com.lp2.sisproject.redirects;

public class Redirect {

    public static String to(String buttonId){
        return switch (buttonId) {
            case "cadastrarFabricante" -> "/com/lp2/sisproject/manufacturer-register-view.fxml";
            case "cadastrarProduto" -> "/com/lp2/sisproject/products-register-view.fxml";
            case "visualizarFabricantes" -> "/com/lp2/sisproject/manufacturers-view.fxml";
            default -> null;
        };
    }
}
