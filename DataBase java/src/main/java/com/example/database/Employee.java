package com.example.database;

public class Employee {
    private int employeeID;
    private String userName;
    private String password;

    Employee(int employeeID, String userName, String password) {
        this.employeeID = employeeID;
        this.userName = userName;
        this.password = password;
    }

    Employee(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeID=" + employeeID +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
