package com.techelevator.view;

import java.io.File;
import java.util.*;

public class Inventory {
//    // instance variables
//    private String slotIdentifier;
//    private String Name;
//    private Double Price;
//    private String Type;
//    private int Quantity = 5;
//
//    // getter and setter
//
//    public String getSlotIdentifier() {
//        return slotIdentifier;
//    }
//
//    public String getName() {
//        return Name;
//    }
//
//    public Double getPrice() {
//        return Price;
//    }
//
//    public String getType() {
//        return Type;
//    }
//
//    public int getQuantity() {
//        return Quantity;
//    }
//
//    public void setSlotIdentifier(String slotIdentifier) {
//        this.slotIdentifier = slotIdentifier;
//    }
//
//    public void setName(String name) {
//        Name = name;
//    }
//
//    public void setPrice(Double price) {
//        Price = price;
//    }
//
//    public void setType(String type) {
//        Type = type;
//    }
//
//    public void setQuantity(int quantity) {
//        Quantity = quantity;
//    }
    // constructor


    public void displayItems() {
        // load
        String inventoryPath = "vendingmachine.csv";
        File inventory = new File (inventoryPath);
        Map<Integer, Product> inventoryMap = new HashMap<Integer, Product>();
        Product product = new Product();

        // parse lines
        try(Scanner inventoryScanner = new Scanner(inventory)){
            while (inventoryScanner.hasNextLine()){
                String nextLine = inventoryScanner.nextLine();
                int i =1;
                String[] productInfo = nextLine.split("\\|");

                product.setSlotIdentifier(productInfo[0]);
                product.setName(productInfo[1]);
                product.setPrice(Double.valueOf(productInfo[2]));
                product.setType(productInfo[3]);

                inventoryMap.put(i, product);
                i++;
            }
            for(Map.Entry<Integer, Product> singleProduct: inventoryMap.entrySet()){
                System.out.println("Product name: " + product.getName() + ", Slot identifier: " + product.getSlotIdentifier() + ", Price: $" + product.getPrice() + ", Quantity remaining: " + product.getQuantity() );

            }

        }catch (Exception e){
            System.out.println("Error occurred");
        }


    }

    // another constructor with all parameters
    // need a sound method???? so to be overridden in subclass




    // product{slot identifier, product name , price , product type}
}
