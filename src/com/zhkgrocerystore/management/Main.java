package com.zhkgrocerystore.management;

public class Main {
    public static void main(String[] args) {

        // ===============================
        // 1. WELCOME MESSAGE
        // ===============================
        System.out.println("=======================================");
        System.out.println("  GROCERY STORE MANAGEMENT SYSTEM");
        System.out.println("=======================================\n");

        // ===============================
        // 2. CREATE PRODUCTS
        // ===============================
        System.out.println(">>> Creating products...\n");

        Product milk = new Product(1, "Milk", 450.0, 20);
        Product bread = new Product(2, "Bread", 250.0, 0);

        Product apple = new Product(); // default constructor
        apple.setName("Apple");
        apple.setPrice(300.0);
        apple.setStockQuantity(50);

        // ===============================
        // 3. CREATE CUSTOMERS
        // ===============================
        System.out.println(">>> Creating customers...\n");

        Customer customer1 = new Customer(101, "Aruzhan", "Regular", 85_000);

        Customer customer2 = new Customer(); // default constructor
        customer2.setMembershipLevel("Gold");

        // ===============================
        // 4. CREATE SALE
        // ===============================
        System.out.println(">>> Creating a new sale...\n");

        Sale sale1 = new Sale(); // default constructor
        sale1.setSaleId(1001);
        sale1.setCustomerName(customer1.getName());
        sale1.setDate("2025-12-21");

        // ===============================
        // 5. DISPLAY INITIAL STATE
        // ===============================
        System.out.println("----- INITIAL STATE -----\n");

        System.out.println("Products:");
        System.out.println(milk);
        System.out.println(bread);
        System.out.println(apple);

        System.out.println("\nCustomers:");
        System.out.println(customer1);
        System.out.println(customer2);

        System.out.println("\nSale:");
        System.out.println(sale1);

        // ===============================
        // 6. TEST GETTERS
        // ===============================
        System.out.println("\n----- TESTING GETTERS -----\n");

        System.out.println("Milk price: " + milk.getPrice() + " KZT");
        System.out.println("Bread stock: " + bread.getStockQuantity());
        System.out.println("Sale date: " + sale1.getDate());

        // ===============================
        // 7. TEST SETTERS
        // ===============================
        System.out.println("\n----- TESTING SETTERS -----\n");

        bread.setStockQuantity(30);
        customer1.setMembershipLevel("Silver");
        sale1.setTotalAmount(0.0);

        System.out.println("Updated bread: " + bread);
        System.out.println("Updated customer: " + customer1);
        System.out.println("Updated sale: " + sale1);

        // ===============================
        // 8. TEST PRODUCT METHODS
        // ===============================
        System.out.println("\n----- TESTING PRODUCT METHODS -----\n");

        System.out.println("Is milk in stock? " + milk.isInStock());
        System.out.println("Is bread in stock? " + bread.isInStock());

        bread.restock(20);
        System.out.println("Bread after restock: " + bread);

        // ===============================
        // 9. TEST SALE METHODS
        // ===============================
        System.out.println("\n----- TESTING SALE METHODS -----\n");

        sale1.addItem(milk.getPrice());
        sale1.addItem(bread.getPrice());
        sale1.addItem(apple.getPrice());

        System.out.println("Sale after adding items:");
        System.out.println(sale1);
        System.out.println("Is large sale? " + sale1.isLargeSale());

        // ===============================
        // 10. TEST CUSTOMER METHODS
        // ===============================
        System.out.println("\n----- TESTING CUSTOMER METHODS -----\n");

        customer1.addPurchase(sale1.getTotalAmount());
        System.out.println("Customer after purchase:");
        System.out.println(customer1);
        System.out.println("Is customer VIP? " + customer1.isVIP());

        // ===============================
        // 11. FINAL SUMMARY
        // ===============================
        System.out.println("\n----- FINAL STATE SUMMARY -----\n");

        System.out.println("Final Products:");
        System.out.println(milk);
        System.out.println(bread);
        System.out.println(apple);

        System.out.println("\nFinal Customers:");
        System.out.println(customer1);
        System.out.println(customer2);

        System.out.println("\nFinal Sale:");
        System.out.println(sale1);

        // ===============================
        // 12. PROGRAM END
        // ===============================
        System.out.println("\n=======================================");
        System.out.println("        PROGRAM EXECUTION COMPLETE");
        System.out.println("=======================================");
    }
}
