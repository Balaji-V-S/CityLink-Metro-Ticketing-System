package com.citylink.ui;

import com.citylink.models.TapLogs;
import com.citylink.services.LogsService;
import com.citylink.services.LogsServiceImpl;
import com.citylink.utility.RuleConfig;
import com.citylink.models.CalculateFare;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LogsService logService = new LogsServiceImpl();
        List<TapLogs> history = logService.getAllLogs();

        RuleConfig config = new RuleConfig(); // All rules enabled by default
        CalculateFare calc = new CalculateFare(config);

        System.out.println("Welcome to CityLink Farebox");
        while (true) {
            System.out.println("Enter the Local Date and Time (YYYY/MM/DD/HH/mm): ");
            String dateString = sc.nextLine();
            if (dateString.equalsIgnoreCase("exit")) break;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd/HH/mm");
            LocalDateTime dateTime;
            try {
                dateTime = LocalDateTime.parse(dateString, formatter);
            } catch (Exception e) {
                System.out.println("Invalid input format. Please use YYYY/MM/DD/HH/MM.");
                continue;
            }

            System.out.println("Enter the Line (G/R/Y/X): ");
            String metroLine = sc.nextLine().toUpperCase();
            if (metroLine.equalsIgnoreCase("exit")) break;
            if (metroLine.length() != 1 || !"GRYX".contains(metroLine)) {
                System.out.println("Invalid Metro Line");
                continue;
            }

            System.out.println("Enter Station Code:");
            String stationCode = sc.nextLine().toUpperCase();
            if (stationCode.equalsIgnoreCase("exit")) break;

            TapLogs tap = new TapLogs(dateTime, metroLine, 0.0, stationCode);
            double fare = calc.calculateFare(tap, history);
            tap.setFare(fare);
            history.add(tap);
            logService.addLog(tap); // Persist the log

            System.out.println("Computed Fare: " + fare);
            System.out.println("Tap Log: " + tap);
        }

        System.out.println("\n--- Bye! Showing all the logs ---");
        for (TapLogs log : history) {
            System.out.println(log);
        }
    }
}
