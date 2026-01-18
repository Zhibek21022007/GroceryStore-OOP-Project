package com.zhkgrocerystore.management;

public class PackagedProduct extends Product {

    private String expiryDate;

    public PackagedProduct(int id, String name, double price, int quantity, String expiryDate) {
        super(id, name, price, quantity);
        this.expiryDate = expiryDate;
        this.category = "Packaged";
    }

    @Override
    public String getProductType() {
        return "Packaged Product";
    }

    public String getExpiryDate() {
        return expiryDate;
    }
}
