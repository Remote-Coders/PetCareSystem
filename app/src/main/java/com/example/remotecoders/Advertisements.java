package com.example.remotecoders;

public class Advertisements {
    protected String name;
    protected String location;
    protected String address;
    protected Integer phone;

    public Advertisements() {
        this.name = "";
        this.location = "";
        this.address = "";
        this.phone = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }
}
