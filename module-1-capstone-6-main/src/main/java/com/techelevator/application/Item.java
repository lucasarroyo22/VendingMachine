package com.techelevator.application;

import java.math.BigDecimal;

public class Item {
    private String itemID;
    private String name;
    private BigDecimal price;
    private String category;
    private int quantity = 6;

    public Item(String itemID, String name, BigDecimal price, String category) {
        this.itemID = itemID;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public int decrementQuantity(){
        if(this.getQuantity() > 0) {
            this.quantity--;
        }
        return this.quantity;
    }
    public String getItemID() {
        return itemID;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public int getQuantity() {
        return quantity;
    }
}
