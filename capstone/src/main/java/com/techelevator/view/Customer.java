package com.techelevator.view;

import java.math.BigDecimal;
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
        moneyProvided = moneyProvided.subtract(BigDecimal.valueOf(amountToSpend));
        return moneyProvided;
    }

}
