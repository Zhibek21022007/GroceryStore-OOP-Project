package com.zhkgrocerystore.management;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Product> products = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        products.add(new Product(1, "Soap", 300, 10));
        products.add(new FreshProduct(2, "Milk", 450, 12, 3));
        products.add(new PackagedProduct(3, "Rice", 3500, 20, "Makfa"));

        boolean running = true;

        while (running) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addGeneralProduct();
                case 2 -> addFreshProduct();
                case 3 -> addPackagedProduct();
                case 4 -> viewAllProducts();
                case 5 -> viewFreshOnly();
                case 0 -> running = false;
                default -> System.out.println("Invalid choice.");
            }
        }

        System.out.println("Application closed.");
    }

    private static void showMenu() {
        System.out.println("""
        ===============================
        GROCERY STORE MANAGEMENT MENU
        ===============================
        1. Add General Product
        2. Add Fresh Product
        3. Add Packaged Product
        4. View All Products
        5. View Fresh Products Only
        0. Exit
        ===============================
        Enter choice:
        """);
    }

    private static void addGeneralProduct() {
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Price: ");
        double price = scanner.nextDouble();

        System.out.print("Quantity: ");
        int qty = scanner.nextInt();

        products.add(new Product(id, name, price, qty));
        System.out.println("Product added.");
    }

    private static void addFreshProduct() {
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Price: ");
        double price = scanner.nextDouble();

        System.out.print("Quantity: ");
        int qty = scanner.nextInt();

        System.out.print("Shelf life (days): ");
        int days = scanner.nextInt();

        products.add(new FreshProduct(id, name, price, qty, days));
        System.out.println("Fresh product added.");
    }

    private static void addPackagedProduct() {
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Price: ");
        double price = scanner.nextDouble();

        System.out.print("Quantity: ");
        int qty = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Brand: ");
        String brand = scanner.nextLine();

        products.add(new PackagedProduct(id, name, price, qty, brand));
        System.out.println("Packaged product added.");
    }

    private static void viewAllProducts() {
        if (products.isEmpty()) {
            System.out.println("No products available.");
            return;
        }

        for (Product p : products) {
            System.out.println(p);
        }
    }

    private static void viewFreshOnly() {
        for (Product p : products) {
            if (p instanceof FreshProduct) {
                FreshProduct fp = (FreshProduct) p;
                System.out.println(fp);
                if (fp.needsQuickSale()) {
                    System.out.println("⚠ Needs quick sale!");
                }
            }
        }
    }
}
