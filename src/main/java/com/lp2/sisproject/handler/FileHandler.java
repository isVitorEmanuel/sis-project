package com.lp2.sisproject.handler;

import com.lp2.sisproject.model.Manufacturer;
import com.lp2.sisproject.model.Product;

import java.io.*;
import java.util.ArrayList;

public class FileHandler {
    public static void write(ArrayList<Product> products, ArrayList<Manufacturer> manufacturers) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/main/resources/data/products.bin"))) {
            oos.writeObject(products);
            System.out.println("Products saved to file");
        } catch (IOException e) {
            // TODO: Handler exception.
            System.err.println(e.getMessage());
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/main/resources/data/manufacturers.bin"))) {
            oos.writeObject(manufacturers);
            System.out.println("Manufacturers saved to file");
        } catch (IOException e) {
            // TODO: Handler exception.
            System.err.println(e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static void read(ArrayList<Product> products, ArrayList<Manufacturer> manufacturers) {
        try (InputStream productStream = FileHandler.class.getClassLoader().getResourceAsStream("data/products.bin")) {
            if (productStream != null) {
                ObjectInputStream ois = new ObjectInputStream(productStream);
                ArrayList<Product> productsFromFile = (ArrayList<Product>) ois.readObject();
                products.addAll(productsFromFile);
                System.out.println("Products read from file");
            }
        } catch (IOException | ClassNotFoundException e) {
            // TODO: Handler exception.
            System.err.println("Error reading the products file");
        }

        try (InputStream manufacturerStream = FileHandler.class.getClassLoader().getResourceAsStream("data/manufacturers.bin")) {
            if (manufacturerStream != null) {
                ObjectInputStream ois = new ObjectInputStream(manufacturerStream);
                ArrayList<Manufacturer> manufacturersFromFile = (ArrayList<Manufacturer>) ois.readObject();
                manufacturers.addAll(manufacturersFromFile);
                System.out.println("Manufacturers read from file");
            }
        } catch (IOException | ClassNotFoundException e) {
            // TODO: Handler exception.
            System.err.println("Error reading the manufacturers file");
        }
    }
}


