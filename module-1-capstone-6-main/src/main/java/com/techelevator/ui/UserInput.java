package com.techelevator.ui;

import com.techelevator.application.Item;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

/**
 * Responsibilities: This class should handle receiving ALL input from the User
 *
 * Dependencies: None
 */
public class UserInput {
    private static Scanner scanner = new Scanner(System.in);

    public static String getHomeScreenOption() {
        System.out.println("What would you like to do?");
        System.out.println();

        System.out.println("D) Display Items");
        System.out.println("P) Purchase");
        System.out.println("E) Exit");

        System.out.println();
        System.out.print("Please select an option: ");

        String selectedOption = scanner.nextLine();
        String option = selectedOption.trim().toLowerCase();
        if (option.equals("d")) {
            return "display";
        }
        else if (option.equals("p")) {
            return "purchase";
        }
        else if (option.equals("e")) {
            return "exit";
        }
        else {
            return "";
        }

    }

    public static String getPurchaseScreenOption()  {
        System.out.println();
        System.out.println("(M) Feed Money");
        System.out.println("(S) Select Item");
        System.out.println("(F) Finish Transaction");
        System.out.println();
        String option = scanner.nextLine().trim().toLowerCase();
        switch(option)  {
            case "m":
                return "feedMoney";
            case "s":
                return "selectItem";
            case "f":
                return "finishTransaction";
            default:
                System.out.println("Invalid Entry, Please Re-enter: ");
        }

        return "";

    }

    public static Item getItemSelectionScreenOption(List<Item> items)  {
        int indexOfValidID = 0;
        while(true) {
            System.out.println();
            System.out.print("Enter desired item ID: ");
            String selection = scanner.nextLine();
            System.out.println();
            indexOfValidID = isValidID(selection.toUpperCase(), items);
            if(indexOfValidID != -1){
                break;
            }
        }
        return items.get(indexOfValidID);
    }

    public static int isValidID(String selection, List<Item> items){
        try{
            for (Item item : items) {
                String itemID = item.getItemID();
                if(selection.equals(itemID)){
                    return items.indexOf(item);
                }
            }
            System.out.println("Please enter valid item ID.");
            return -1;
        }catch(NullPointerException e){
            System.out.println("Please enter an item ID.");
            return -1;
        }
    }
    public static BigDecimal getMoneyFedScreenOption()  {
        BigDecimal amount = new BigDecimal("0");
        while(true) {
            System.out.println();
            System.out.print("Enter amount of money to be fed ($1/$5/$10/$20): ");
            String money = scanner.nextLine();
            System.out.println();
            if (isValidInteger(money)) {
                int amountInt = Integer.parseInt(money);
                amount = new BigDecimal(amountInt);
                break;
            }
        }
        return amount;
    }

    public static boolean isValidInteger(String myString)    {
        try {
            int amountInt = Integer.parseInt(myString);
            if(amountInt == 1 || amountInt == 5 || amountInt == 10 || amountInt == 20) {
                return true;
            }else{
                System.out.println("Please enter 1, 5, 10, or 20.");
                return false;
            }
        }
        catch (NumberFormatException e)  {
            System.out.println("Please enter the number 1, 5, 10, or 20.");
            return false;
        }
    }


}

