package com.techelevator.view;

import java.math.BigDecimal;

public class CoinBank {
    private BigDecimal balance = BigDecimal.valueOf(0);

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
// constructor
    public CoinBank() {
    }

    public CoinBank(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal addToCoinBank (BigDecimal amountToSpend){
        balance = this.balance.add(amountToSpend) ;
        return balance;
    }

    public BigDecimal subtractFromCoinBank (BigDecimal amountToReturn) {
        balance = this.balance.subtract(amountToReturn);
        // calculation
        BigDecimal amountToReturnInCent = amountToReturn.multiply(BigDecimal.valueOf(100));
        BigDecimal nickels = BigDecimal.valueOf(5);
        BigDecimal dimes = BigDecimal.valueOf(10);
        BigDecimal quarters = BigDecimal.valueOf(25);
        BigDecimal quarterAmount;
        BigDecimal dimesAmount = BigDecimal.valueOf(0);
        BigDecimal nickelsAmount = BigDecimal.valueOf(0);
        BigDecimal remainderFromDimes = BigDecimal.valueOf(0);
        BigDecimal remainderFromQuarter =BigDecimal.valueOf(0);

// John - change made here!!!!
        if (amountToReturnInCent.compareTo(quarters) == 1) {
            quarterAmount = (amountToReturnInCent.divide(quarters)).setScale(0);
            remainderFromQuarter = amountToReturnInCent.remainder(quarters);
            if (remainderFromQuarter.compareTo(dimes) == 1) {
                dimesAmount = (remainderFromQuarter.divide(dimes)).setScale(0);
                remainderFromDimes = remainderFromQuarter.remainder(dimes);
            } else {
                nickelsAmount =(remainderFromDimes.divide(nickels)).setScale(0);
            }
            System.out.println(quarterAmount + " quarters, " + dimesAmount
                    + " dimes, " + nickelsAmount + " nickels.");
        } else if (amountToReturnInCent.compareTo(dimes) == 1) {
            dimesAmount = (amountToReturnInCent.divide(dimes)).setScale(0);
            remainderFromDimes = amountToReturnInCent.remainder(dimes);
            nickelsAmount = (remainderFromDimes.divide(nickels)).setScale(0);
            System.out.println( dimesAmount + " dimes, " + nickelsAmount + " nickels.");
        } else {
            nickelsAmount = BigDecimal.valueOf(1);
            System.out.println( nickelsAmount + " nickels.");
        }

        return balance;
    }


    // coinbank balance += amount to spend,

}

