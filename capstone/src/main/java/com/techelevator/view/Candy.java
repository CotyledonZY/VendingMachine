package com.techelevator.view;

public class Candy extends Product {
    // constructor
    public Candy() {
        super();
    }
    // method override
    @Override
    public void printMessage(Customer customer){
        super.printMessage(customer);
        System.out.println("Munch, Munch, Yum!");
    }
}
