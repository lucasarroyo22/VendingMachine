package com.techelevator.application;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ItemInventory {
    private File inventoryFile;

    public ItemInventory(File inventoryFile) {
        this.inventoryFile = inventoryFile;
    }

    public List<Item> getItems(){
        List<Item> items = new ArrayList<>();
        try (Scanner itemInput = new Scanner(inventoryFile)){
            while(itemInput.hasNextLine()){
                String itemLine = itemInput.nextLine();
                String[] itemArray = itemLine.split(",");
                BigDecimal price = new BigDecimal(itemArray[2]);
                Item item = new Item(itemArray[0], itemArray[1], price, itemArray[3]);
                items.add(item);
            }
        }catch(FileNotFoundException e){
            System.err.println("File Not Found");
        }

        return items;
    }
}
