package com.kodilla.good.patterns.challenges.ProductOrder;

public class Product {
    private String productName;
    private String productDescription;
    private double productPrice;

    public Product(String productName, String productDescription, double productPrice) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public double getProductPrice() {
        return productPrice;
    }
}
