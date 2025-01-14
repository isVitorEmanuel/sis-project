package com.lp2.sisproject;

import com.lp2.sisproject.dao.BancoDAO;
import com.lp2.sisproject.enums.Size;
import com.lp2.sisproject.model.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

import static com.lp2.sisproject.handler.FileHandler.read;


public class Main extends Application {
    BancoDAO banco = BancoDAO.getInstance();

    @Override
    public void start(Stage stage) throws IOException {

        read(banco.getProdutos(),banco.getManufacturers());

        Manufacturer manufacturer1 = new Manufacturer("Fabricante A", "12345678000101", new Address("Rua A", "Cidade A", "Estado A", "Brasil", "11111-111"));
        Manufacturer manufacturer2 = new Manufacturer("Fabricante B", "23456789000102", new Address("Rua B", "Cidade B", "Estado B", "Brasil", "22222-222"));

        // Criando produtos alimentícios
        FoodstuffProduct food1 = new FoodstuffProduct("Leite", 1, 4.50, 100, manufacturer1, LocalDate.of(2024, 12, 31), LocalDate.of(2024, 6, 1));
        FoodstuffProduct food2 = new FoodstuffProduct("Pão", 2, 3.00, 200, manufacturer2, LocalDate.of(2024, 12, 15), LocalDate.of(2024, 11, 1));

        // Criando produtos eletrônicos
        EletronicProduct elec1 = new EletronicProduct("Smartphone", 3, 1500.00, 50, manufacturer1, "Tela OLED, 128GB");
        EletronicProduct elec2 = new EletronicProduct("Laptop", 4, 3500.00, 30, manufacturer2, "Intel i7, 16GB RAM, 512GB SSD");

        // Criando produtos de vestuário
        ClothingProduct cloth1 = new ClothingProduct("Camiseta", 5, 50.00, 100, manufacturer1, Size.G);
        ClothingProduct cloth2 = new ClothingProduct("Calça Jeans", 6, 120.00, 80, manufacturer2, Size.P);

        banco.getProdutos().add(food1);
        banco.getProdutos().add(food2);
        banco.getProdutos().add(elec1);
        banco.getProdutos().add(elec2);
        banco.getProdutos().add(cloth1);
        banco.getProdutos().add(cloth2);

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("products-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("SisCaixa");
        stage.setScene(scene);

        stage.setOnCloseRequest(event -> {
            try {
                com.lp2.sisproject.handler.FileHandler.write(banco.getProdutos(), banco.getManufacturers());
            } catch (Exception e) {
                System.err.println("Error ao salvar os dados: " + e.getMessage());
            }
        });

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}