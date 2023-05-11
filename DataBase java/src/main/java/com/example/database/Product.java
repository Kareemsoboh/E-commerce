package com.example.database;

public class Product {
    private int productID;
    private String productName;
    private String size;
    private String colour;
    private int Quantity;
    private float price;
    private int employeeID;
    private int categoryID;

    Product(String productName, String size, String colour, int quantity, float price, int employeeID, int categoryID) {

        this.productName = productName;
        this.size = size;
        this.colour = colour;
        this.Quantity = quantity;
        this.price = price;
        this.employeeID = employeeID;
        this.categoryID = categoryID;
    }

    Product(int productID, String productName, String size, String colour, int quantity, float price, int employeeID, int categoryID) {
        this.productID = productID;
        this.productName = productName;
        this.size = size;
        this.colour = colour;
        this.Quantity = quantity;
        this.price = price;
        this.employeeID = employeeID;
        this.categoryID = categoryID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }


    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productID=" + productID +
                ", productName='" + productName + '\'' +
                ", size='" + size + '\'' +
                ", colour='" + colour + '\'' +
                ", Quantity=" + Quantity +
                ", price=" + price +
                ", employeeID=" + employeeID +
                ", categoryID=" + categoryID +
                '}';
    }
}
