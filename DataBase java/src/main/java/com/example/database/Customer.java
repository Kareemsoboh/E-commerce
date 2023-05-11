package com.example.database;

import java.util.Date;

public class Customer {
    private String FirstName;
    private String LastName;
    private int CustomerID;
    private String BirthDate;
    private String Email;
    private String password;

    Customer(String fname, String lname, String BirthDate, String email, String password) {
        this.FirstName = fname;
        this.LastName = lname;
        this.BirthDate = BirthDate;
        this.Email = email;
        this.password = password;
    }

    Customer(String fname, String lname, int customerID, String BirthDate, String email, String password) {
        this.FirstName = fname;
        this.LastName = lname;
        this.CustomerID = customerID;
        this.BirthDate = BirthDate;
        this.Email = email;
        this.password = password;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int customerID) {
        CustomerID = customerID;
    }

    public String getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(String birthDate) {
        BirthDate = birthDate;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", CustomerID=" + CustomerID +
                ", BirthDate=" + BirthDate +
                ", Email='" + Email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
