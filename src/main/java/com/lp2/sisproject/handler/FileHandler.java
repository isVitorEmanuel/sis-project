package com.lp2.sisproject.handler;

import com.lp2.sisproject.model.Manufacturer;
import com.lp2.sisproject.model.Product;

import java.io.*;
import java.util.ArrayList;

public class FileHandler {
    public static void write(ArrayList<Product> products, ArrayList<Manufacturer> manufacturers) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("products.txt"))) {
            oos.writeObject(products);
            System.out.println("Products saved to file");
        } catch (IOException e) {
            // TODO: Handler exception.
            e.printStackTrace();
            System.out.println("Não foi possivel salvar os produtos.");
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("manufacturers.txt"))) {
            oos.writeObject(manufacturers);
            System.out.println("Manufacturers saved to file");
        } catch (IOException e) {
            // TODO: Handler exception.
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static void read(ArrayList<Product> products, ArrayList<Manufacturer> manufacturers) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("products.txt"))) {

                ArrayList<Product> productsFromFile = (ArrayList<Product>) ois.readObject();
                products.addAll(productsFromFile);
                System.out.println("Products read from file");

        } catch (IOException | ClassNotFoundException e) {
            // TODO: Handler exception.
            System.err.println("Error reading the products file");
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("manufacturers.txt"))) {

                ArrayList<Manufacturer> manufacturersFromFile = (ArrayList<Manufacturer>) ois.readObject();
                manufacturers.addAll(manufacturersFromFile);
                System.out.println("Manufacturers read from file");

        } catch (IOException | ClassNotFoundException e) {
            // TODO: Handler exception.
            System.err.println("Error reading the manufacturers file");
        }
    }
}


