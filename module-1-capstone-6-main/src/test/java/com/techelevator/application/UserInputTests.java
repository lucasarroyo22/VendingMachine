package com.techelevator.application;

import com.techelevator.ui.UserInput;
import org.junit.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class UserInputTests {
    @Test
    public void isValidIDReturns2()  {
        List<Item> items = new ArrayList<>();
        Item item1 = new Item("a1", "chips", new BigDecimal("2"), "test");
        Item item2 = new Item("a2", "chocolate", new BigDecimal("3"), "test");
        Item item3 = new Item("a3", "cherries", new BigDecimal("5"), "test");
        items.add(item1);
        items.add(item2);
        items.add(item3);
        String selection = "a3";
        int index = UserInput.isValidID(selection, items);
        Assert.assertEquals(2, index);
    }

    @Test
    public void isValidIDReturns0()  {
        List<Item> items = new ArrayList<>();
        Item item1 = new Item("a1", "chips", new BigDecimal("2"), "test");
        Item item2 = new Item("a2", "chocolate", new BigDecimal("3"), "test");
        Item item3 = new Item("a3", "cherries", new BigDecimal("5"), "test");
        items.add(item1);
        items.add(item2);
        items.add(item3);
        String selection = "a1";
        int index = UserInput.isValidID(selection, items);
        Assert.assertEquals(0, index);
    }
}
