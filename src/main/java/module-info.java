module com.lp2.sisproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.lp2.sisproject to javafx.fxml;
    exports com.lp2.sisproject;
    exports com.lp2.sisproject.controller;
    opens com.lp2.sisproject.controller to javafx.fxml;
}