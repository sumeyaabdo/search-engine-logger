package com.pluralsight;
import java.util.Scanner;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SearchEngineLoggerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Log when the application starts
        logAction("launch");

        while (true) {

            System.out.print("Enter a search term (X or x to exit): ");
            String searchTerm = scanner.nextLine();

            if (searchTerm.equalsIgnoreCase("x")) {
                logAction("exit");
                break;
            } else {
                logAction("search : " + searchTerm);
            }
        }

        scanner.close();
    }

    // Method to log user actions
    public static void logAction(String action) {

        try {
            FileWriter fileWriter = new FileWriter("logs.txt", true);
            BufferedWriter bufWriter = new BufferedWriter(fileWriter);

            LocalDateTime now = LocalDateTime.now();

            DateTimeFormatter formatter =
                    DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

            String dateTime = now.format(formatter);

            bufWriter.write(dateTime + " " + action);
            bufWriter.newLine();

            bufWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
