package com.example.database;

import java.util.Date;

public class Order {
    private int OrderID;
    private String OrderDate;
    private int AddressID;
    private int PaymentID;
    private int CustomerID;
    private float amount;

    Order(int orderID, String orderDate, int addressID, int paymentID, int customerID, float amount) {
        this.OrderID = orderID;
        this.OrderDate = orderDate;
        this.AddressID = addressID;
        this.PaymentID = paymentID;
        this.CustomerID = customerID;
        this.amount = amount;
    }

    Order(String orderDate, int addressID, int paymentID, int customerID, float amount) {
        this.OrderDate = orderDate;
        this.AddressID = addressID;
        this.PaymentID = paymentID;
        this.CustomerID = customerID;
        this.amount = amount;
    }

    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int orderID) {
        OrderID = orderID;
    }

    public String getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(String orderDate) {
        OrderDate = orderDate;
    }

    public int getAddressID() {
        return AddressID;
    }

    public void setAddressID(int addressID) {
        AddressID = addressID;
    }

    public int getPaymentID() {
        return PaymentID;
    }

    public void setPaymentID(int paymentID) {
        PaymentID = paymentID;
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int customerID) {
        CustomerID = customerID;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "OrderID=" + OrderID +
                ", OrderDate=" + OrderDate +
                ", AddressID=" + AddressID +
                ", PaymentID=" + PaymentID +
                ", CustomerID=" + CustomerID +
                '}';
    }
}
