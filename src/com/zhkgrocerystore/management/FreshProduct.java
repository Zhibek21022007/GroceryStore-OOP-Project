package com.zhkgrocerystore.management;

public class FreshProduct extends Product {

    private int shelfLifeDays;

    public FreshProduct(int id, String name, double price, int qty, int shelfLifeDays) {
        super(id, name, price, qty);
        this.shelfLifeDays = shelfLifeDays;
        this.category = "Fresh";
    }

    @Override
    public String getProductType() {
        return "Fresh Product";
    }

    public int getShelfLifeDays() {
        return shelfLifeDays;
    }
}
