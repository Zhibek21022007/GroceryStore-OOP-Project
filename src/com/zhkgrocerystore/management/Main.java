package com.zhkgrocerystore.management;

public class Main {
    static void main(String[] ignoredArgs) {

        System.out.println("=======================================");
        System.out.println("  GROCERY STORE MANAGEMENT SYSTEM");
        System.out.println("=======================================\n");

        System.out.println(">>> Creating products...\n");

        Product milk = new Product(1, "Milk", 450.0, 20);
        Product bread = new Product(2, "Bread", 250.0, 0);

        Product apple = new Product();
        apple.setName("Apple");
        apple.setPrice(300.0);
        apple.setStockQuantity(50);

        System.out.println(">>> Creating customers...\n");

        Customer customer1 = new Customer(101, "Aruzhan", "Regular", 85_000);

        Customer customer2 = new Customer();
        customer2.setMembershipLevel("Gold");

        System.out.println(">>> Creating a new sale...\n");

        Sale sale1 = new Sale(1001, customer1.getName(), 0.0, "2025-12-21");

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

        System.out.println("\n----- TESTING GETTERS -----\n");

        System.out.println("Milk price: " + milk.getPrice() + " KZT");
        System.out.println("Bread stock: " + bread.getStockQuantity());
        System.out.println("Customer name: " + customer1.getName());
        System.out.println("Sale total amount: " + sale1.getTotalAmount());

        System.out.println("\n----- TESTING SETTERS -----\n");

        System.out.println("Updating bread stock...");
        bread.setStockQuantity(30);
        System.out.println("Updated bread: " + bread);

        System.out.println("\nUpdating customer membership level...");
        customer1.setMembershipLevel("Silver");
        System.out.println("Updated customer: " + customer1);

        System.out.println("\n----- TESTING PRODUCT METHODS -----\n");

        System.out.println("Is milk in stock? " + milk.isInStock());
        System.out.println("Is bread in stock? " + bread.isInStock());

        System.out.println("\nRestocking bread by 20 units...");
        bread.restock(20);
        System.out.println("Bread after restock: " + bread);

        System.out.println("\n----- TESTING SALE METHODS -----\n");

        System.out.println("Adding products to the sale...");
        sale1.addItem(milk.getPrice());
        sale1.addItem(bread.getPrice());
        sale1.addItem(apple.getPrice());

        System.out.println("Sale after adding items:");
        System.out.println(sale1);

        System.out.println("Is this a large sale? " + sale1.isLargeSale());

        System.out.println("\n----- TESTING CUSTOMER METHODS -----\n");

        System.out.println("Adding sale amount to customer's purchases...");
        customer1.addPurchase(sale1.getTotalAmount());

        System.out.println("Customer after purchase:");
        System.out.println(customer1);

        System.out.println("Is customer VIP? " + customer1.isVIP());

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

        System.out.println("\n=======================================");
        System.out.println("        PROGRAM EXECUTION COMPLETE");
        System.out.println("=======================================");
    }
}
