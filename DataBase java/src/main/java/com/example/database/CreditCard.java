package com.example.database;

import java.util.Date;

public class CreditCard extends Payment {

    private int paymentID;
    private int number;
    private String cardDate;
    private int cvvCode;
    private float amount;

    CreditCard(int paymentID, int number, String cardDate, int cvvCode, float amount) {
        super(paymentID, amount);
        this.number = number;
        this.cardDate = cardDate;
        this.cvvCode = cvvCode;
        this.amount = amount;
    }

    CreditCard(int number, String cardDate, int cvvCode, float amount) {
        super(amount);
        this.number = number;
        this.cardDate = cardDate;
        this.cvvCode = cvvCode;
        this.amount = amount;
    }

    @Override
    public int getPaymentID() {
        return paymentID;
    }

    @Override
    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getCardDate() {
        return cardDate;
    }

    public void setCardDate(String cardDate) {
        this.cardDate = cardDate;
    }

    public int getCvvCode() {
        return cvvCode;
    }

    public void setCvvCode(int cvvCode) {
        this.cvvCode = cvvCode;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "paymentID=" + paymentID +
                ", number=" + number +
                ", cardDate=" + cardDate +
                ", cvvCode=" + cvvCode +
                '}';
    }
}
