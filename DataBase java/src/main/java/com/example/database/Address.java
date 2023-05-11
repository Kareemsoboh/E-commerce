package com.example.database;

public class Address {
    private int AddressID;
    private String city;
    private String village;
    private String street;
    private String phone;

    Address(int addressID, String city, String village, String street, String phone) {
        this.AddressID = addressID;
        this.city = city;
        this.village = village;
        this.street = street;
        this.phone = phone;
    }

    Address(String city, String village, String street, String phone) {
        this.city = city;
        this.village = village;
        this.street = street;
        this.phone = phone;
    }

    public int getAddressID() {
        return AddressID;
    }

    public void setAddressID(int addressID) {
        AddressID = addressID;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Address{" +
                "AddressID=" + AddressID +
                ", city='" + city + '\'' +
                ", village='" + village + '\'' +
                ", street='" + street + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
