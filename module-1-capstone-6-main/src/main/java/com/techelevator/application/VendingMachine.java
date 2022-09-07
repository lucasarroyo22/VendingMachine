package com.techelevator.application;

import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;

import java.io.File;
import java.util.List;

public class VendingMachine {
    private File itemFile = new File("catering.csv");
    private ItemInventory itemInventory = new ItemInventory(itemFile);
    private List<Item> items = itemInventory.getItems();
    private PurchaseMenu purchaseMenu = new PurchaseMenu();

    public void run() {
        while(true) {
            UserOutput.displayHomeScreen();
            String choice = UserInput.getHomeScreenOption();
            if(choice.equals("display")) {
                UserOutput.displayItems(items);
            }
            else if(choice.equals("purchase")) {
                purchaseMenu.run(items);
            }
            else if(choice.equals("exit")) {
                UserOutput.farewellMessage();
                break;
            }
        }
    }
}
