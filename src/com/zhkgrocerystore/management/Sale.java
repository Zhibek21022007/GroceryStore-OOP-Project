package com.zhkgrocerystore.management;

public class Sale {
    private final int saleId;
    private final String customerName;
    private double totalAmount;
    private final String date;

    public Sale(int saleId, String customerName, double totalAmount, String date) {
        this.saleId = saleId;
        this.customerName = customerName;
        this.totalAmount = totalAmount;
        this.date = date;
    }

    public Sale() {
        this.saleId = 0;
        this.customerName = "Unknown";
        this.totalAmount = 0.0;
        this.date = "N/A";
    }

    public int getSaleId() {
        return saleId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void addItem(double price) {
        totalAmount += price;
    }

    public boolean isLargeSale() {
        return totalAmount > 20000;
    }

    @Override
    public String toString() {
        return "Sale{id=" + saleId +
                ", customer='" + customerName + '\'' +
                ", total=" + totalAmount +
                ", date='" + date + '\'' + '}';
    }
}
