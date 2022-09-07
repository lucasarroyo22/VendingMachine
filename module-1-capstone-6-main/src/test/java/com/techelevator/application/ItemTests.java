package com.techelevator.application;
import org.junit.*;

import java.math.BigDecimal;

public class ItemTests {
    @Test
    public void decrementQuantityReturns5() {
        Item item = new Item("A1", "ItemName", new BigDecimal("5"), "Gum");
        int quantity = item.decrementQuantity();
        Assert.assertEquals(5, quantity);
    }

    @Test
    public void decrementQuantityReturns4() {
        Item item = new Item("A1", "ItemName", new BigDecimal("5"), "Gum");
        int quantity = item.decrementQuantity();
        quantity = item.decrementQuantity();
        Assert.assertEquals(4, quantity);
    }
}
