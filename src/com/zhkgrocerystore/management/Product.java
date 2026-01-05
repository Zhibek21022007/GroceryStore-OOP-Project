package com.zhkgrocerystore.management;

public class Product {

    private int productId;
    private String name;
    private double price;
    private int quantity;
    protected String category;

    public Product(int productId, String name, double price, int quantity) {
        this.productId = productId;
        setName(name);
        setPrice(price);
        setQuantity(quantity);
        this.category = "General";
    }

    public Product() {
        this.productId = 0;
        this.name = "Unnamed Product";
        this.price = 0.0;
        this.quantity = 0;
        this.category = "General";
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

    public int getQuantity() {
        return quantity;
    }

    public String getCategory() {
        return category;
    }

    public void setProductId(int productId) {
        if (productId > 0) {
            this.productId = productId;
        }
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.out.println("⚠ Product name cannot be empty.");
        }
    }

    public void setPrice(double price) {
        if (price >= 0) {
            this.price = price;
        } else {
            System.out.println("⚠ Price cannot be negative. Set to 0.");
            this.price = 0;
        }
    }

    public void setQuantity(int quantity) {
        if (quantity >= 0) {
            this.quantity = quantity;
        } else {
            System.out.println("⚠ Quantity cannot be negative.");
            this.quantity = 0;
        }
    }

    public boolean isAvailable() {
        return quantity > 0;
    }

    public void restock(int amount) {
        if (amount > 0) {
            quantity += amount;
        }
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
