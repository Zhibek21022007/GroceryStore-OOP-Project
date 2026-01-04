package com.zhkgrocerystore.management;

public class Customer {

    private int customerId;
    private String fullName;
    private String phone;
    private double totalSpent;

    public Customer(int customerId, String fullName, String phone, double totalSpent) {
        this.customerId = customerId;
        setFullName(fullName);
        setPhone(phone);
        setTotalSpent(totalSpent);
    }

    public Customer() {
        this.customerId = 0;
        this.fullName = "Guest";
        this.phone = "N/A";
        this.totalSpent = 0.0;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPhone() {
        return phone;
    }

    public double getTotalSpent() {
        return totalSpent;
    }

    public void setCustomerId(int customerId) {
        if (customerId > 0) {
            this.customerId = customerId;
        }
    }

    public void setFullName(String fullName) {
        if (fullName != null && !fullName.trim().isEmpty()) {
            this.fullName = fullName;
        } else {
            System.out.println("⚠ Customer name cannot be empty.");
        }
    }

    public void setPhone(String phone) {
        if (phone != null && phone.contains("+")) {
            this.phone = phone;
        } else {
            System.out.println("⚠ Invalid phone number.");
            this.phone = "Unknown";
        }
    }

    public void setTotalSpent(double totalSpent) {
        if (totalSpent >= 0) {
            this.totalSpent = totalSpent;
        }
    }

    public void addPurchase(double amount) {
        if (amount > 0) {
            totalSpent += amount;
        }
    }

    public boolean isVIP() {
        return totalSpent >= 100000;
    }

    @Override
    public String toString() {
        return "Customer{id=" + customerId +
                ", name='" + fullName + '\'' +
                ", phone='" + phone + '\'' +
                ", totalSpent=" + totalSpent + '}';
    }
}
