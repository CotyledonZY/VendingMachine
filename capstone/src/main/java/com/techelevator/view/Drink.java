package com.techelevator.view;

public class Drink extends Product {
    // constructor
    public Drink() {
        super();
    }
    // method override
    @Override
    public void printMessage(Customer customer){
        super.printMessage(customer);
        System.out.println("Glug, Glug, Yum!");
    }

}
