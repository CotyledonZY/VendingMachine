package com.techelevator.view;

public  class Product {
    private String slotIdentifier;
    private String Name;
    private Double Price;
    private String Type;
    private int Quantity = 5;

    public String getSlotIdentifier() {
        return slotIdentifier;
    }

    public String getName() {
        return Name;
    }

    public Double getPrice() {
        return Price;
    }

    public String getType() {
        return Type;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setSlotIdentifier(String slotIdentifier) {
        this.slotIdentifier = slotIdentifier;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setPrice(Double price) {
        Price = price;
    }

    public void setType(String type) {
        Type = type;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }
}
