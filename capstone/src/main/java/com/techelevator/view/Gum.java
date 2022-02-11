package com.techelevator.view;

public class Gum extends Product {
    // constructor
    public Gum() {
        super();
    }
    // method override
    @Override
    public void printMessage(Customer customer){
        super.printMessage(customer);
        System.out.println("Chew, Chew, Yum!");
    }

}
