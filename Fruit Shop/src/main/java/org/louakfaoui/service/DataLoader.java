package org.louakfaoui.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DataLoader {

    public static Map<String, Float> loadPrices(String priceFileName) {
        Map<String, Float> result = new HashMap<>();
        try (Scanner scanner = new Scanner(new File(priceFileName))) {
            if (scanner.hasNextLine()) {
                scanner.nextLine();// to skip header
            }

            while (scanner.hasNextLine()) {
                String[] split = scanner.nextLine().split(",");
                result.put(split[0].trim(), Float.valueOf(split[1].trim()));
            }

            return result;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static Map<String, Integer> loadPurchase(String purchaseFileName) {
        Map<String, Integer> result = new HashMap<>();
        try (Scanner scanner = new Scanner(new File(purchaseFileName))) {
            if (scanner.hasNextLine()) {
                scanner.nextLine();// to skip header
            }

            while (scanner.hasNextLine()) {
                String[] split = scanner.nextLine().split(",");
                result.put(split[0].trim(), Integer.valueOf(split[1].trim()));
            }

            return result;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}


