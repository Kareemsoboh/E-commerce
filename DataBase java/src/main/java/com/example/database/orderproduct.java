package com.example.database;

public class orderproduct {
    private int oid;
    private int pid;
    private String pdescription;
    private Float price;

    public orderproduct(int oid, int pid, String pdescription, Float price) {
        this.oid = oid;
        this.pid = pid;
        this.pdescription = pdescription;
        this.price = price;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPdescription() {
        return pdescription;
    }

    public void setPdescription(String pdescription) {
        this.pdescription = pdescription;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
