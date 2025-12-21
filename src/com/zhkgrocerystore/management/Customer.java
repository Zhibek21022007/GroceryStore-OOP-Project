package com.zhkgrocerystore.management;

public class Customer {
    private final int customerId;
    private final String name;
    private String membershipLevel;
    private double totalPurchases;

    public Customer(int customerId, String name, String membershipLevel, double totalPurchases) {
        this.customerId = customerId;
        this.name = name;
        this.membershipLevel = membershipLevel;
        this.totalPurchases = totalPurchases;
    }

    public Customer() {
        this.customerId = 0;
        this.name = "Unknown Customer";
        this.membershipLevel = "Regular";
        this.totalPurchases = 0.0;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getMembershipLevel() {
        return membershipLevel;
    }

    public double getTotalPurchases() {
        return totalPurchases;
    }

    public void setMembershipLevel(String membershipLevel) {
        this.membershipLevel = membershipLevel;
    }

    public void addPurchase(double amount) {
        totalPurchases += amount;
    }

    public boolean isVIP() {
        return totalPurchases > 100000;
    }

    @Override
    public String toString() {
        return "Customer{id=" + customerId +
                ", name='" + name + '\'' +
                ", level='" + membershipLevel + '\'' +
                ", purchases=" + totalPurchases + '}';
    }
}
