package org.example.sessionall.Session02.models;

import java.util.Date;

public class Order {
    private String id;
    private String productName;
    private double totalAmount;
    private Date orderDate;

    public Order(String id, String productName, double totalAmount, Date orderDate) {
        this.id = id;
        this.productName = productName;
        this.totalAmount = totalAmount;
        this.orderDate = orderDate;
    }

    // Getters và Setters (Bắt buộc phải có public getter để EL trong JSP đọc được)
    public String getId() { return id; }
    public String getProductName() { return productName; }
    public double getTotalAmount() { return totalAmount; }
    public Date getOrderDate() { return orderDate; }
}