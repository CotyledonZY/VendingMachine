package com.techelevator.view;
import org.junit.Test;
import org.junit.Before;
import org.junit.Assert;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CustomerTest {
    Customer customer;
    Product productA;
    Product productB;
    @Before
    public void create_Customer_Test() {
        customer = new Customer();
        BigDecimal moneyProvided = new BigDecimal(0.00).setScale(2, RoundingMode.UP);
        productA = new Chip();
        productB = new Candy();
        productA.setName("Potato Crisps");
        productB.setName("Cowtales");
        productA.setPrice(BigDecimal.valueOf(3.05));
        productB.setPrice(BigDecimal.valueOf(1.50));
        productA.setType("Chip");
        productB.setType("Candy");
        productA.setSlotIdentifier("A");
        productB.setSlotIdentifier("B");
        productB.setQuantity(0);

    }
    //feedMoney - happy path; something with decimal; words/a letter; 0; negative number;

    @Test
    public void feedMoneyTests(){
        BigDecimal moneyProvided = customer.feedMoney(0.00).setScale(2, RoundingMode.UP);
        BigDecimal moneyProvided1 = customer.feedMoney(1.25).setScale(2, RoundingMode.UP);
        BigDecimal moneyProvided2 = customer.feedMoney(-1.00).setScale(2, RoundingMode.UP);
        BigDecimal moneyProvided3 = customer.feedMoney(2.00).setScale(2, RoundingMode.UP);
        Assert.assertEquals("****Amount entered is not a whole dollar amount****", new BigDecimal(0.00).setScale(2, RoundingMode.UP), moneyProvided);
        Assert.assertEquals("****Amount entered is not a whole dollar amount****", new BigDecimal(0.00).setScale(2, RoundingMode.UP), moneyProvided1);
        Assert.assertEquals("****Amount entered is not a whole dollar amount****", new BigDecimal(0.00).setScale(2, RoundingMode.UP), moneyProvided2);
        Assert.assertEquals(BigDecimal.valueOf(2.00).setScale(2, RoundingMode.UP), moneyProvided3);
    }

    //changeReturned - declare amountToSpend as zero or regular number

    @Test
    public void changeReturnedTests(){
        BigDecimal amountToSpend1 = new BigDecimal(0);
        BigDecimal amountToSpend2 = new BigDecimal(2);
        Assert.assertEquals(BigDecimal.valueOf(0), amountToSpend1);
        Assert.assertEquals(BigDecimal.valueOf(2), amountToSpend2);
    }

    //selectProduct - happy path; invalid selection; product sold out;

 /*   @Test
    public void selectProduct(){
        BigDecimal moneyProvided = new BigDecimal(6.00).setScale(2, RoundingMode.UP);
       // Map<String, Product> inventoryMap, BigDecimal moneyProvided, Scanner userInput,Customer customer
        Map<String, Product> inventoryMap = new TreeMap<>();

        *//*        Product productA = new Chip();
        Product productB = new Candy();
        productA.setName("Potato Crisps");
        productB.setName("Cowtales");
        productA.setPrice(BigDecimal.valueOf(3.05));
        productB.setPrice(BigDecimal.valueOf(1.50));
        productA.setType("Chip");
        productB.setType("Candy");
        productA.setSlotIdentifier("A");
        productB.setSlotIdentifier("B");
        productB.setQuantity(0);*//*

        Scanner userInput = new Scanner("A");
        Scanner userInput2 = new Scanner("B");
        Scanner userInput3 = new Scanner("C");
        inventoryMap.put ("A", productA);
        inventoryMap.put ("B", productB);

        Assert.assertEquals(productA, customer.selectProduct(inventoryMap, new BigDecimal(6.00).setScale(2, RoundingMode.UP), userInput, customer));
        Assert.assertEquals("**** Slot identifier does not exist - Please enter a valid slot identifier ****", customer.selectProduct(inventoryMap, moneyProvided, userInput3, customer));
        Assert.assertEquals("B are Sold Out :(", customer.selectProduct(inventoryMap, moneyProvided, userInput2, customer));*/



    }


