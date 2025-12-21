package com.zhkgrocerystore.management;

public class Product {
    private final int productId;
    private String name;
    private double price;
    private int stockQuantity;

    public Product(int productId, String name, double price, int stockQuantity) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    public Product() {
        this.productId = 0;
        this.name = "Unknown Product";
        this.price = 0.0;
        this.stockQuantity = 0;
    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public boolean isInStock() {
        return stockQuantity > 0;
    }

    public void restock(int amount) {
        stockQuantity += amount;
    }

    @Override
    public String toString() {
        return "Product{id=" + productId +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", stock=" + stockQuantity + '}';
    }
}
