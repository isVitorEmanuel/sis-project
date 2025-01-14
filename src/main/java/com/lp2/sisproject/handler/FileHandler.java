package com.lp2.sisproject.handler;

import com.lp2.sisproject.model.Manufacturer;
import com.lp2.sisproject.model.Product;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class FileHandler {
    public static void write(ArrayList<Product> products, ArrayList<Manufacturer> manufacturers){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Products.txt"))){
            oos.writeObject(products);
            System.out.println("Products saved to file");
        }catch(IOException e){
            //TODO: Implementar exceptions personalizadas?
            System.err.println(e);
        }
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Manufacturers.txt"))){
            oos.writeObject(manufacturers);
            System.out.println("Manufacturers saved to file");
        }catch(IOException e){
            //TODO: Implementar exceptions personalizadas?
            System.err.println(e);
        }
    }
    public static void read(ArrayList<Product> products, ArrayList<Manufacturer> manufacturers){

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Products.txt"))){
            //TODO: Ajeitar esse warning, ou nao.
            ArrayList<Product> productsFromFile = (ArrayList<Product>) ois.readObject();
            ArrayList<Manufacturer> manufacturersFromFile = (ArrayList<Manufacturer>) ois.readObject();

            manufacturers.addAll(manufacturersFromFile);
            products.addAll(productsFromFile);
        }catch(IOException | ClassNotFoundException e){
            System.err.println("Error reading the products file");
            //TODO: Implementar exceptions personalizadas?
        }
        System.out.println("Products read from file");
        System.out.println("Manufacturers read from file");
    }

    }

