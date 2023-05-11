package com.example.database;

public class Payment {
    private int paymentID;
    private Float amount;

    Payment(int paymentID, float amount) {
        this.paymentID = paymentID;
        this.amount = amount;
    }

    public Payment(float amount) {
        this.amount = amount;
    }

    public int getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }
}
