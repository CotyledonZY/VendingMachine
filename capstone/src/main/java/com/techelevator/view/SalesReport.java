package com.techelevator.view;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SalesReport {
    // instance variables
    String reportMessage;
    int numberOfSales = 0;
    String productName;

    // getter & setter

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getNumberOfSales() {
        return numberOfSales;
    }

    public void setNumberOfSales(int numberOfSales) {
        this.numberOfSales = numberOfSales;
    }

    // constructor
    public SalesReport() {
    }

    public SalesReport(Product product,int numberOfSales) {
        this.numberOfSales = numberOfSales;
        this.productName = product.getName();


    }

    // method
    public String printInReport(){

        this.numberOfSales = numberOfSales;

        return reportMessage;
    }
}
