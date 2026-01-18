package com.zhkgrocerystore.management;

import com.zhkgrocerystore.management.exception.InvalidProductDataException;

public abstract class Product implements Manageable {

    private int productId;
    private String name;
    private double price;
    private int quantity;

    protected String category;

    public Product(int productId, String name, double price, int quantity) {
        setProductId(productId);
        setName(name);
        setPrice(price);
        setQuantity(quantity);
        this.category = "General";
    }

    public abstract String getProductType();

    @Override
    public void manage() {
        System.out.println("Managing product: " + name);
    }

    public int getProductId() { return productId; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public String getCategory() { return category; }

    public void setProductId(int productId) {
        if (productId <= 0)
            throw new InvalidProductDataException("Product ID must be positive");
        this.productId = productId;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty())
            throw new InvalidProductDataException("Product name cannot be empty");
        this.name = name;
    }

    public void setPrice(double price) {
        if (price < 0)
            throw new InvalidProductDataException("Price cannot be negative");
        this.price = price;
    }

    public void setQuantity(int quantity) {
        if (quantity < 0)
            throw new InvalidProductDataException("Quantity cannot be negative");
        this.quantity = quantity;
    }

    public boolean isAvailable() {
        return quantity > 0;
    }

    public void restock(int amount) {
        if (amount <= 0)
            throw new InvalidProductDataException("Restock amount must be positive");
        quantity += amount;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + productId +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
