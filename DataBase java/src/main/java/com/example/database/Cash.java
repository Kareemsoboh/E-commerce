package com.example.database;

public class Cash extends Payment {
    private int paymentID;
    private float amount;

    Cash(float amount) {
        super(amount);
        this.amount = amount;
    }

    Cash(int paymentID, float amount) {
        super(paymentID, amount);
        this.paymentID = paymentID;
        this.amount = amount;
    }

    public int getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Cash{" +
                "paymentID=" + paymentID +
                '}';
    }
}
