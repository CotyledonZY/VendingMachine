package com.techelevator.view;

import java.math.BigDecimal;
import java.text.DateFormat;
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

    public BigDecimal changeReturned (BigDecimal amountToSpend){
            moneyProvided = moneyProvided.subtract(amountToSpend);
        return moneyProvided;
    }

    public Product selectProduct (Map<Integer, Product> inventoryMap, BigDecimal moneyProvided, Scanner userInput,Customer customer){
        // list available products
        Product product = new Product();
        if (moneyProvided.equals(BigDecimal.ZERO)) {
            System.out.println("Deposit money before making a selection");
        } else {
            // loop through the map
            for(Map.Entry<Integer, Product> singleProduct: inventoryMap.entrySet()) {
                // only print products available
                if (singleProduct.getValue().getQuantity()>0) {
                    System.out.println("Slot identifier: " + singleProduct.getValue().getSlotIdentifier() + " || "
                            + singleProduct.getValue().getName()
                            +", Price: $" + singleProduct.getValue().getPrice()
                            + ", Quantity remaining: " + singleProduct.getValue().getQuantity());
                }
            }

            // compare userinput with slotID
            System.out.println("Make a selection with slot identifier: ");
            String slotIdentifierPicked = userInput.nextLine();

            boolean matchFound = false;

            for (int i = 1; i <= inventoryMap.size(); i++){
                // if valid, then dispense;
                if (slotIdentifierPicked.equals(inventoryMap.get(i).getSlotIdentifier())) {
                    //item sold out
                    if (inventoryMap.get(i).getQuantity() == 0){
                        System.out.println(inventoryMap.get(i).getName() + " is Sold Out :(");
                    } else {
//                        Product product = new Product();
                        // product available, - dispense , printMessage
                        if (inventoryMap.get(i).getType().equals("Drink")){
                            product = new Drink();
                            setupProduct(inventoryMap, customer, i, product);

                        }else if (inventoryMap.get(i).getType().equals("Chip")){
                            product = new Chip();
                            setupProduct(inventoryMap, customer, i, product);

                        }else if (inventoryMap.get(i).getType().equals("Candy")){
                            product = new Candy();
                            setupProduct(inventoryMap, customer, i, product);

                        }else if (inventoryMap.get(i).getType().equals("Gum")){
                            product = new Gum();
                            setupProduct(inventoryMap, customer, i, product);
                        }

                        // update  quantity of item,
//                        product.setQuantity(product.getQuantity()-1);
                        inventoryMap.get(i).setQuantity(product.getQuantity()-1);
                    }
                    matchFound = true;
                }
            }
            // if customer enter invalid code
            if (!matchFound){
                 System.out.println("**** Slot identifier does not exist - Please enter a valid slot identifier ****");
            }
        }
        return product;
    }

    private void setupProduct(Map<Integer, Product> inventoryMap, Customer customer, int i, Product product) {
        product.setName(inventoryMap.get(i).getName());
        product.setType(inventoryMap.get(i).getType());
        product.setPrice(inventoryMap.get(i).getPrice());
        product.setSlotIdentifier(inventoryMap.get(i).getSlotIdentifier());
        product.setQuantity(inventoryMap.get(i).getQuantity());
        product.printMessage(customer);
    }

    // hit finish transaction - got a message money returned, moneyProvided =0,
    public void finishTransaction(Product product, Customer customer, CoinBank coinBank){

        BigDecimal amountToReturn = customer.getMoneyProvided();
        BigDecimal amountToSpend = product.getPrice();
        coinBank.addToCoinBank(amountToSpend);
//        coinBank.setBalance(coinBank.getBalance().add(product.getPrice()));
        if (amountToReturn == BigDecimal.valueOf(0)){
            System.out.println("Thank you for your business! :)");
        }else {

            System.out.println("Here is your change: $" + amountToReturn);
            coinBank.subtractFromCoinBank(amountToReturn);
        }
        customer.setMoneyProvided(BigDecimal.valueOf(0));



    }
}
