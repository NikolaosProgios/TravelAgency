package com.myapp.travelagency;

public class Clients {
    private int id;
    private String name;
    private int born;
    private String phone;
    private String hotel;
    private int tripPackage;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBorn() {
        return born;
    }

    public void setBorn(int born) {
        this.born = born;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public int getTripPackage() {
        return tripPackage;
    }

    public void setTripPackage(int tripPackage) {
        this.tripPackage = tripPackage;
    }
}