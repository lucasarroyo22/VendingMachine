package com.techelevator.application;
import org.junit.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PurchaseMenuTests {
    @Test
    public void feedMoney_returns_5(){
        BigDecimal balance = new BigDecimal(5);
        PurchaseMenu purchaseMenu = new PurchaseMenu();

        BigDecimal result = purchaseMenu.feedMoney(balance);

        Assert.assertEquals(new BigDecimal(5),result);
    }

    @Test
    public void selectItem_returns_BalanceOvercharge(){
        PurchaseMenu purchaseMenu = new PurchaseMenu();
        List<Item> items = new ArrayList<>();
        Item item1 = new Item("a1", "chips", new BigDecimal("2"), "test");
        Item item2 = new Item("a2", "chocolate", new BigDecimal("3"), "test");
        Item item3 = new Item("a3", "cherries", new BigDecimal("5"), "test");
        items.add(item1);
        items.add(item2);
        items.add(item3);
        Item selectedItem = item1;

        String result = purchaseMenu.selectItem(items,selectedItem);

        Assert.assertEquals("Balance Overcharge",result);
    }

    @Test
    public void finishTransaction_returns_0(){
        PurchaseMenu purchaseMenu = new PurchaseMenu();

        BigDecimal result = purchaseMenu.finishTransaction();

        Assert.assertEquals(new BigDecimal(0), result);
    }
}
