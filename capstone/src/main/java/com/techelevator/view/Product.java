package com.techelevator.view;

public class Product {
    // instance variables
    private String slotIdentifier;
    private String name;
    private Double price;
    private String type;
    private int quantity = 5;

    // getter
    public String getSlotIdentifier() {
        return slotIdentifier;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public int getQuantity() {
        return quantity;
    }

    // setter
    public void setSlotIdentifier(String slotIdentifier) {
        this.slotIdentifier = slotIdentifier;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // default constructor
    public Product() {
    }

    // need a sound method???? so to be overridden in subclass
    public void soundMessage(){

    }


}
