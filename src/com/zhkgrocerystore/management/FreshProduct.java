package com.zhkgrocerystore.management;

public class FreshProduct extends Product {

    private int shelfLifeDays;

    public FreshProduct(int productId, String name, double price, int quantity, int shelfLifeDays) {
        super(productId, name, price, quantity);
        this.shelfLifeDays = shelfLifeDays;
        this.category = "Fresh";
    }

    public int getShelfLifeDays() {
        return shelfLifeDays;
    }

    public boolean needsQuickSale() {
        return shelfLifeDays <= 2;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", shelfLifeDays=" + shelfLifeDays;
    }
}
