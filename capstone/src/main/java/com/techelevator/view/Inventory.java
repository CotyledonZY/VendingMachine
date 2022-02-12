package com.techelevator.view;

import java.io.File;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;


public class Inventory {
    // instance variables
    private Map<Integer, Product> inventoryMap = new HashMap<Integer, Product>();
    private int i =1;

    // constructor
    public Inventory() {
    }

    // method
    public Map<Integer, Product> readFile() {
        // load file
        String inventoryPath = "vendingmachine.csv";
        File inventory = new File(inventoryPath);

        // parse lines
        try (Scanner inventoryScanner = new Scanner(inventory)) {
            while (inventoryScanner.hasNextLine()) {
                String nextLine = inventoryScanner.nextLine();

                String[] productInfo = nextLine.split("\\|");
                Product product = new Product();
                // add to Product
                product.setSlotIdentifier(productInfo[0]);
                product.setName(productInfo[1]);
                product.setPrice(Double.valueOf(productInfo[2]));
                product.setType(productInfo[3]);
                // add to map
                inventoryMap.put(i, product);
                i++;
            }
        } catch (Exception e) {
            System.out.println("Error occurred");
        }
        return inventoryMap;
    }
        
        
        // Display items - loop through Map for listing all items

    public void displayItems(Map<Integer, Product> inventoryMap) {
        this.inventoryMap = inventoryMap;

        for(Map.Entry<Integer, Product> singleProduct: inventoryMap.entrySet()) {
            if (singleProduct.getValue().getQuantity() == 0) {
                System.out.println("Product name: " + singleProduct.getValue().getName() + "SOLD OUT");
            } else {
                System.out.println("Slot identifier: " + singleProduct.getValue().getSlotIdentifier() + " || " + singleProduct.getValue().getName()
                        +", Price: $" + singleProduct.getValue().getPrice()
                        + ", Quantity remaining: " + singleProduct.getValue().getQuantity());
            }

        }
    }
}
