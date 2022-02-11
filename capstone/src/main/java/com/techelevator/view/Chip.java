package com.techelevator.view;

public class Chip extends Product {
    // constructor
    public Chip() {
        super();
    }
    // method override
    @Override
    public void printMessage(Customer customer){
        super.printMessage(customer);
        System.out.println("Crunch, Crunch, Yum!");
    }
}
