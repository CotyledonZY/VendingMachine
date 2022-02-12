package com.techelevator.view;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Scanner;

public class Customer {
    //How to display Current Money Provided formatted like "0.00"?? BigDecimal format?
    private BigDecimal moneyProvided = new BigDecimal(0.00);

    public BigDecimal getMoneyProvided() {
        return moneyProvided;
    }

    public void setMoneyProvided(BigDecimal moneyProvided) {
        this.moneyProvided = moneyProvided;
    }

    public Customer() {
    }

    public Customer(BigDecimal moneyProvided) {
        this.moneyProvided = moneyProvided;
    }

    public BigDecimal feedMoney (double amountToDeposit){
        if (amountToDeposit > 0 && amountToDeposit % 1 == 0){
            moneyProvided = moneyProvided.add(BigDecimal.valueOf(amountToDeposit));
        } else {
            System.out.println("****Amount entered is not a whole dollar amount****");
        }
        return moneyProvided;
    }

    public BigDecimal changeReturned (double amountToSpend){
        if (amountToSpend > moneyProvided.doubleValue()){
            System.out.println("Not enough money provided, please enter more money");
        }else{
            moneyProvided = moneyProvided.subtract(BigDecimal.valueOf(amountToSpend));
        }
        return moneyProvided;
    }

    public void selectProduct (Map<Integer, Product> inventoryMap, BigDecimal moneyProvided, Scanner userInput,Customer customer){
        // list available products
        if (moneyProvided.equals(BigDecimal.ZERO)) {
            System.out.println("Deposit money before making a selection");
        } else {
            // loop through the map
            for(Map.Entry<Integer, Product> singleProduct: inventoryMap.entrySet()) {
                // only print products available
                if (singleProduct.getValue().getQuantity()>0) {
                    System.out.println("Slot identifier: " + singleProduct.getValue().getSlotIdentifier() + " || " + singleProduct.getValue().getName()
                            +", Price: $" + singleProduct.getValue().getPrice()
                            + ", Quantity remaining: " + singleProduct.getValue().getQuantity());
                }
            }

            // compare userinput with slotID
            System.out.println("Make a selection with slot identifier");
            String slotIdentifierPicked = userInput.nextLine();

            for (int i = 1; i <= inventoryMap.size(); i++){
                // if valid, then dispense; if not, throw error
                if (slotIdentifierPicked.equals(inventoryMap.get(i).getSlotIdentifier())) {
                    //item sold out
                    if (inventoryMap.get(i).getQuantity() == 0){
                        System.out.println(inventoryMap.get(i).getName() + " is Sold Out :(");
                    } else {
                        // product available, - dispense , printMessage
                        if (inventoryMap.get(i).getType().equals("Drink")){
                            Product product = new Drink();
                            setupProduct(inventoryMap, customer, i, product);

                        }else if (inventoryMap.get(i).getType().equals("Chip")){
                            Product product = new Chip();
                            setupProduct(inventoryMap, customer, i, product);

                        }else if (inventoryMap.get(i).getType().equals("Candy")){
                            Product product = new Candy();
                            setupProduct(inventoryMap, customer, i, product);

                        }else if (inventoryMap.get(i).getType().equals("Gum")){
                            Product product = new Gum();
                            setupProduct(inventoryMap, customer, i, product);
                        }

                        // update coinbank balance, quantity of item, 

                    }
                }
            }

            // ******************** CODE LATER!!! what if customer enter invalid code *************************
//            System.out.println("**** Slot identifier does not exist - Please enter a valid slot identifier ****");

        }
    }

    private void setupProduct(Map<Integer, Product> inventoryMap, Customer customer, int i, Product product) {
        product.setName(inventoryMap.get(i).getName());
        product.setType(inventoryMap.get(i).getType());
        product.setPrice(inventoryMap.get(i).getPrice());
        product.setSlotIdentifier(inventoryMap.get(i).getSlotIdentifier());
        product.setQuantity(inventoryMap.get(i).getQuantity());
        product.printMessage(customer);
    }
}
