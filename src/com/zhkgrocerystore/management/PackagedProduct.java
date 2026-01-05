package com.zhkgrocerystore.management;

public class PackagedProduct extends Product {

    private String brand;

    public PackagedProduct(int productId, String name, double price, int quantity, String brand) {
        super(productId, name, price, quantity);
        this.brand = brand;
        this.category = "Packaged";
    }

    public String getBrand() {
        return brand;
    }

    public boolean isPremiumBrand() {
        return brand.length() > 6;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", brand='" + brand + '\'';
    }
}
