package com.techelevator.view;

public class CoinBank {
        private double balance;

    public double getBalance() {
        return balance;
    }

    public CoinBank() {
    }

    public CoinBank(double balance) {
        this.balance = balance;
    }

    private double addToCoinBank (double amountToSpend){
        balance = balance + amountToSpend;
                return balance;
    }

    private double subtractFromCoinBank (double amountToReturn){
        balance = balance - amountToReturn;
        return balance;
    }
}

