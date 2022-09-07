package com.techelevator.application;

import java.math.BigDecimal;

public class VendingMachineBalance {
    private BigDecimal balance = new BigDecimal(0);

    public BigDecimal getBalance()  {
        return this.balance;
    }

    public void addBalance(BigDecimal moneyFed)    {
        this.balance = this.balance.add(moneyFed);
    }

    public void subtractBalance(BigDecimal moneySubtracted) {
        if(this.balance.compareTo(moneySubtracted) != -1)  {
            this.balance = this.balance.subtract(moneySubtracted);
        }
    }
}
