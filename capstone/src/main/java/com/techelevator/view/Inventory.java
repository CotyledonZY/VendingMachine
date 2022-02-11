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
    public void displayItems() {
        // load file
        String inventoryPath = "vendingmachine.csv";
        File inventory = new File (inventoryPath);

        // parse lines
        try(Scanner inventoryScanner = new Scanner(inventory)){
            while (inventoryScanner.hasNextLine()){
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
        }catch (Exception e){System.out.println("Error occurred");
        }

        // Display items - loop through Map for listing all items
            for(Map.Entry<Integer, Product> singleProduct: inventoryMap.entrySet()){
                // CODE HERE - if item available

                System.out.println("Product name: " + singleProduct.getValue().getName() + ", Slot identifier: "
                        + singleProduct.getValue().getSlotIdentifier() + ", Price: $" + singleProduct.getValue().getPrice()
                        + ", Quantity remaining: " + singleProduct.getValue().getQuantity());
                // CODE HERE - if item sold out, print product "name and sold out"


            }


    }
}
