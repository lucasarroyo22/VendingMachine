package com.techelevator.ui;

import com.techelevator.application.Item;

import java.math.BigDecimal;
import java.util.List;

public class UserOutput {
    public static void displayMessage(String message) {
        System.out.println();
        System.out.println(message);
        System.out.println();
    }

    public static void displayHomeScreen() {
        System.out.println();
        System.out.println("***************************************************");
        System.out.println("                      Home");
        System.out.println("***************************************************");
        System.out.println();
    }

    public static void displayItems(List<Item> items){
        System.out.println("ItemID   Item Name        Price    Quantity Remaining");
        for (Item item : items) {
            String quantityMessage = "" + item.getQuantity();
            if(item.getQuantity() <= 0){
                quantityMessage = "NO LONGER AVAILABLE";
            }
            System.out.printf("%-8s %-16s $%-7.2f %-16s\n", item.getItemID(), item.getName(), item.getPrice(), quantityMessage);
        }
    }

    public static void printBalance(BigDecimal balance) {
        System.out.print("Current Money Provided: ");
        System.out.printf("$%.2f", balance);
        System.out.println();
    }

    public static int[] changeRecieved(BigDecimal vendingBalance){
        int [] change = new int[5];
        int balance = vendingBalance.multiply(new BigDecimal(100)).intValue();

        change[0] = balance / 100;
        change[1] = (balance % 100)  / 25;
        change[2] = (balance % 25) / 10;
        change[3] = (balance % 25 % 10) / 5;
        change[4] = balance % 5;

        System.out.printf("Your change is %d Dollars, %d Quarters, %d Dimes, %d Nickels, and %d Pennies",change[0],change[1],change[2],change[3],change[4]);
        return change;
    }

    public static void printCategory(Item item)  {
        if (item.getCategory().equals("Munchy"))    {
            System.out.println("Munchy, Munchy, so Good!");
        }
        else if (item.getCategory().equals("Drink"))    {
            System.out.println("Drinky, Drinky, Slurp Slurp!");
        }
        else if (item.getCategory().equals("Candy"))    {
            System.out.println("Sugar, Sugar, so Sweet!");
        }
        else if (item.getCategory().equals("Gum")){
            System.out.println("Chewy, Chewy, Lots O Bubbles!");
        }
    }

    public static void balanceOverCharge()  {
        System.out.println("You don't have enough money to purchase that item.");
    }

    public static void itemOutOfStock(Item item) {
        System.out.printf("Item %s is no longer available.\n", item.getItemID());
    }

    public static void displayItemDetails(Item item) {
        System.out.printf("%s purchased, Cost: $%.2f\n", item.getName(), item.getPrice());
    }

    public static void farewellMessage()    {
        System.out.println();
        System.out.println("Thanks for shopping! Come again soon!");
    }
}
