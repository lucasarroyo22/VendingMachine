package com.techelevator.application;
import org.junit.*;

import java.math.BigDecimal;

public class VendingMachineBalanceTests {
    @Test
    public void addBalanceShouldReturn5()   {
        VendingMachineBalance vendingMachineBalance = new VendingMachineBalance();
        BigDecimal myDecimal = new BigDecimal("5");
        vendingMachineBalance.addBalance(myDecimal);
        BigDecimal result = vendingMachineBalance.getBalance();
        Assert.assertEquals(new BigDecimal(5), result);
    }

    @Test
    public void subtractBalanceShouldReturn0()   {
        VendingMachineBalance vendingMachineBalance = new VendingMachineBalance();
        BigDecimal myDecimal = new BigDecimal("5");
        vendingMachineBalance.addBalance(myDecimal);
        vendingMachineBalance.subtractBalance(myDecimal);
        BigDecimal result = vendingMachineBalance.getBalance();
        Assert.assertEquals(new BigDecimal(0), result);
    }
}
