package com.lp2.sisproject.handler;

import com.lp2.sisproject.model.Product;

import java.io.*;
import java.util.ArrayList;

public class FileHandler {
    public static void write(ArrayList<Product> products){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Products.txt"))){
            oos.writeObject(products);
            System.out.println("Products saved to file");
        }catch(IOException e){
            //TODO: Implementar exceptions personalizadas?
            System.err.println(e);
        }
    }
    public static void read(ArrayList<Product> products){

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Products.txt"))){
            //TODO: Ajeitar esse warning, se pá...
            ArrayList<Product> produtos = (ArrayList<Product>) ois.readObject();

            products.addAll(produtos);
        }catch(IOException | ClassNotFoundException e){
            System.err.println("Error reading the products file");
            //TODO: Implementar exceptions personalizadas?
        }
        System.out.println("Products read from file");
    }

    }

