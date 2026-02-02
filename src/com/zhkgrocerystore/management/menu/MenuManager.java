package com.zhkgrocerystore.management.menu;

import com.zhkgrocerystore.management.*;
import database.ProductDAO;

import java.util.Scanner;

public class MenuManager implements Menu {

    private final Scanner scanner = new Scanner(System.in);
    private final ProductDAO productDAO = new ProductDAO();
    private boolean running = true;

    @Override
    public void displayMenu() {
        System.out.println("\n===== PRODUCT MANAGEMENT MENU =====");
        System.out.println("1. Insert Product");
        System.out.println("2. View All Products");
        System.out.println("3. Get Product By ID");
        System.out.println("4. Update Product");
        System.out.println("5. Delete Product");
        System.out.println("6. Search by Name");
        System.out.println("7. Search by Quantity Range");
        System.out.println("0. Exit");
        System.out.print("Choose option: ");
    }

    @Override
    public void run() {
        while (running) {
            displayMenu();
            try {
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1 -> insertProduct();
                    case 2 -> productDAO.getAllProducts();
                    case 3 -> getProductById();
                    case 4 -> updateProduct();
                    case 5 -> deleteProduct();
                    case 6 -> searchByName();
                    case 7 -> searchByQuantityRange();
                    case 0 -> running = false;
                    default -> System.out.println(" Invalid option!");
                }
            } catch (Exception e) {
                System.out.println(" Invalid input!");
            }
        }
    }

    private void insertProduct() {
        try {
            System.out.print("Product ID: ");
            int id = Integer.parseInt(scanner.nextLine());

            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Price: ");
            double price = Double.parseDouble(scanner.nextLine());

            System.out.print("Quantity: ");
            int quantity = Integer.parseInt(scanner.nextLine());

            System.out.print("Type (1 - Fresh, 2 - Packaged): ");
            int type = Integer.parseInt(scanner.nextLine());

            Product product;

            if (type == 1) {
                System.out.print("Shelf Life (days): ");
                int shelfLife = Integer.parseInt(scanner.nextLine());
                product = new FreshProduct(id, name, price, quantity, shelfLife);
            } else {
                System.out.print("Expiry Date (YYYY-MM-DD): ");
                String expiry = scanner.nextLine();
                product = new PackagedProduct(id, name, price, quantity, expiry);
            }

            productDAO.insertProduct(product);
            System.out.println(" Product inserted successfully!");

        } catch (Exception e) {
            System.out.println(" Failed to insert product!");
        }
    }

    private void getProductById() {
        System.out.print("Enter product ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        Product product = productDAO.getProductById(id);

        if (product == null) {
            System.out.println(" Product not found!");
        } else {
            System.out.println(product);
        }
    }

        private void updateProduct() {
        System.out.print("Enter product ID to update: ");
        int id = Integer.parseInt(scanner.nextLine());

        Product existing = productDAO.getProductById(id);
        if (existing == null) {
            System.out.println(" Product not found!");
            return;
        }

        System.out.println("Current data: " + existing);

        System.out.print("New name [" + existing.getName() + "]: ");
        String name = scanner.nextLine();
        if (name.isEmpty()) name = existing.getName();

        System.out.print("New price [" + existing.getPrice() + "]: ");
        String priceInput = scanner.nextLine();
        double price = priceInput.isEmpty()
                ? existing.getPrice()
                : Double.parseDouble(priceInput);

        System.out.print("New quantity [" + existing.getQuantity() + "]: ");
        String qtyInput = scanner.nextLine();
        int quantity = qtyInput.isEmpty()
                ? existing.getQuantity()
                : Integer.parseInt(qtyInput);

        productDAO.updateProduct(id, name, price, quantity);
        System.out.println(" Product updated!");
    }

    private void deleteProduct() {
        System.out.print("Enter product ID to delete: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Are you sure? (yes/no): ");
        String confirm = scanner.nextLine();

        if (confirm.equalsIgnoreCase("yes")) {
            boolean deleted = productDAO.deleteProduct(id);
            System.out.println(deleted ? " Product deleted!" : " Product not found!");
        } else {
            System.out.println(" Deletion cancelled.");
        }
    }

    private void searchByName() {
        System.out.print("Enter name keyword: ");
        String keyword = scanner.nextLine();
        productDAO.searchByName(keyword);
    }

    private void searchByQuantityRange() {
        System.out.print("Min quantity: ");
        int min = Integer.parseInt(scanner.nextLine());

        System.out.print("Max quantity: ");
        int max = Integer.parseInt(scanner.nextLine());

        productDAO.searchByQuantityRange(min, max);
    }
}
