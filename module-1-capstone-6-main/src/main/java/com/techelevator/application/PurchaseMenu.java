package com.techelevator.application;

import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;
import java.math.BigDecimal;
import java.util.List;

public class PurchaseMenu{

    private BigDecimal balancePrior = new BigDecimal("0");
    private BigDecimal balanceAfter = new BigDecimal("0");
    private VendingMachineBalance vendingMachineBalance = new VendingMachineBalance();

    public void run(List<Item> items){

        while(true) {

            UserOutput.printBalance(vendingMachineBalance.getBalance());
            String purchaseChoice = UserInput.getPurchaseScreenOption();
            if(purchaseChoice.equals("feedMoney"))  {
                BigDecimal balance = UserInput.getMoneyFedScreenOption();
                feedMoney(balance);
            }
            else if(purchaseChoice.equals("selectItem"))    {
                UserOutput.displayItems(items);
                Item selectedItem = UserInput.getItemSelectionScreenOption(items);
                selectItem(items, selectedItem);
            }
            else if(purchaseChoice.equals("finishTransaction")) {
                finishTransaction();
                break;
            }
        }
    }
    public BigDecimal feedMoney(BigDecimal balance){
        balancePrior = vendingMachineBalance.getBalance();
        vendingMachineBalance.addBalance(balance);
        balanceAfter = vendingMachineBalance.getBalance();
        AuditLog.feedLog(balancePrior, balanceAfter);
        return balanceAfter;
    }

    public String selectItem(List<Item> items, Item selectedItem){
        for (Item item : items) {
            if(item.equals(selectedItem)){
                if(item.getQuantity() == 0) {
                    UserOutput.itemOutOfStock(item);
                    return "Out of Stock!";
                }
                if(vendingMachineBalance.getBalance().compareTo(item.getPrice()) >= 0)  {
                    balancePrior = vendingMachineBalance.getBalance();
                    vendingMachineBalance.subtractBalance(item.getPrice());
                    item.decrementQuantity();
                    items.set(items.indexOf(item),item);
                    UserOutput.displayItemDetails(item);
                    UserOutput.printCategory(item);
                    balanceAfter = vendingMachineBalance.getBalance();
                    AuditLog.itemLog(item, balancePrior, balanceAfter);
                    return item.getItemID();
                }
                else    {
                    UserOutput.balanceOverCharge();
                    return "Balance Overcharge";
                }
            }
        }
        return "Item not found";
    }

    public BigDecimal finishTransaction(){
        AuditLog.changeLog(vendingMachineBalance.getBalance(), new BigDecimal("0"));
        UserOutput.changeRecieved(vendingMachineBalance.getBalance());
        vendingMachineBalance.subtractBalance(vendingMachineBalance.getBalance());
        return vendingMachineBalance.getBalance();
    }
}
