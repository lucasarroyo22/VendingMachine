package com.techelevator.application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AuditLog {
    public static void itemLog(Item item, BigDecimal balancePrior, BigDecimal balanceAfter) {
        File log = new File("C:\\Users\\Student\\workspace\\module-1-capstone-6\\src\\main\\java\\com\\techelevator\\logs/audit.txt");
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String formattedDate = dateTime.format(timeFormatter);
        try(PrintWriter printerWrite = new PrintWriter(new FileOutputStream(log, true)))    {
            String output = String.format("%s %s %s $%.2f $%.2f\n", formattedDate, item.getName(), item.getItemID(), balancePrior, balanceAfter);
            printerWrite.append(output);

        }
        catch(FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    public static void feedLog(BigDecimal balancePrior, BigDecimal balanceAfter)    {
        File log = new File("C:\\Users\\Student\\workspace\\module-1-capstone-6\\src\\main\\java\\com\\techelevator\\logs/audit.txt");
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String formattedDate = dateTime.format(timeFormatter);
        try(PrintWriter printerWrite = new PrintWriter(new FileOutputStream(log, true)))    {
            String output = String.format("%s MONEY FED: $%.2f $%.2f\n", formattedDate, balancePrior, balanceAfter);
            printerWrite.append(output);

        }
        catch(FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    public static void changeLog(BigDecimal balancePrior, BigDecimal balanceAfter)  {
        File log = new File("C:\\Users\\Student\\workspace\\module-1-capstone-6\\src\\main\\java\\com\\techelevator\\logs/audit.txt");
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String formattedDate = dateTime.format(timeFormatter);
        try(PrintWriter printerWrite = new PrintWriter(new FileOutputStream(log, true)))    {
            String output = String.format("%s CHANGE GIVEN: $%.2f $%.2f\n", formattedDate, balancePrior, balanceAfter);
            printerWrite.append(output);

        }
        catch(FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}
