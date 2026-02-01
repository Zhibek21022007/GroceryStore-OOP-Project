package com.zhkgrocerystore.management.menu;

import com.zhkgrocerystore.management.*;
import com.zhkgrocerystore.management.exception.*;

import java.util.ArrayList;
import java.util.Scanner;
import database.ProductDAO;

public class MenuManager implements Menu {

    private final ArrayList<Product> products = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);
    private boolean running = true;

    @Override
    public void displayMenu() {
        System.out.println("\n--- Grocery Store Menu ---");
        System.out.println("1. Add Fresh Product");
        System.out.println("2. Add Packaged Product");
        System.out.println("3. View Products");
        System.out.println("0. Exit");
    }

    @Override
    public void run() {
        while (running) {
            displayMenu();
            try {
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1 -> addFreshProduct();
                    case 2 -> addPackagedProduct();
                    case 3 -> viewProducts();
                    case 0 -> running = false;
                    default -> System.out.println("Invalid option");
                }

            } catch (NumberFormatException e) {
                System.out.println("❌ Please enter a number.");
            } catch (IllegalArgumentException e) {
                System.out.println("❌ " + e.getMessage());
            }
        }
    }

    private void addFreshProduct() {
        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Price: ");
        double price = Double.parseDouble(scanner.nextLine());

        System.out.print("Quantity: ");
        int qty = Integer.parseInt(scanner.nextLine());

        System.out.print("Shelf life days: ");
        int days = Integer.parseInt(scanner.nextLine());

        products.add(new FreshProduct(1, name, price, qty, days));
        System.out.println("✅ Fresh product added");
    }

    private void addPackagedProduct() {
        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Price: ");
        double price = Double.parseDouble(scanner.nextLine());

        System.out.print("Quantity: ");
        int qty = Integer.parseInt(scanner.nextLine());

        System.out.print("Expiry date: ");
        String expiry = scanner.nextLine();

        products.add(new PackagedProduct(2, name, price, qty, expiry));
        System.out.println("✅ Packaged product added");
    }

    private void viewProducts() {
        for (Product p : products) {
            System.out.println(p);

            if (p instanceof FreshProduct fp) {
                System.out.println(" → Shelf life: " + fp.getShelfLifeDays());
            }

            if (p instanceof PackagedProduct pp) {
                System.out.println(" → Expiry date: " + pp.getExpiryDate());
            }

            System.out.println("--------------------------");
        }
    }
}
