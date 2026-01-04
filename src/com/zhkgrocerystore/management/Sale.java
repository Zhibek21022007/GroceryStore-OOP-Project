package com.zhkgrocerystore.management;

public class Sale {

    private int saleId;
    private int productId;
    private int customerId;
    private int quantitySold;
    private double totalAmount;

    public Sale(int saleId, int productId, int customerId, int quantitySold, double totalAmount) {
        this.saleId = saleId;
        setProductId(productId);
        setCustomerId(customerId);
        setQuantitySold(quantitySold);
        setTotalAmount(totalAmount);
    }

    public Sale() {
        this.saleId = 0;
        this.productId = 0;
        this.customerId = 0;
        this.quantitySold = 0;
        this.totalAmount = 0.0;
    }

    public int getSaleId() {
        return saleId;
    }

    public int getProductId() {
        return productId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getQuantitySold() {
        return quantitySold;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setSaleId(int saleId) {
        if (saleId > 0) {
            this.saleId = saleId;
        }
    }

    public void setProductId(int productId) {
        if (productId > 0) {
            this.productId = productId;
        }
    }

    public void setCustomerId(int customerId) {
        if (customerId > 0) {
            this.customerId = customerId;
        }
    }

    public void setQuantitySold(int quantitySold) {
        if (quantitySold > 0) {
            this.quantitySold = quantitySold;
        }
    }

    public void setTotalAmount(double totalAmount) {
        if (totalAmount >= 0) {
            this.totalAmount = totalAmount;
        }
    }

    public boolean isLargeSale() {
        return totalAmount >= 30000;
    }

    public void recalculateTotal(double pricePerUnit) {
        if (pricePerUnit > 0 && quantitySold > 0) {
            totalAmount = pricePerUnit * quantitySold;
        }
    }

    @Override
    public String toString() {
        return "Sale{id=" + saleId +
                ", productId=" + productId +
                ", customerId=" + customerId +
                ", quantitySold=" + quantitySold +
                ", totalAmount=" + totalAmount + '}';
    }
}
