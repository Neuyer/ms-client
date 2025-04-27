package com.fiap.client.core.entity;

public class Address {

    private String _id;
    private String nickName;
    private String street;
    private String city;
    private String state;
    private String zipCode;

    // Constructor
    public Address(String id, String nickName, String street, String city, String state, String zipCode) {
        _id = id;
        this.nickName = nickName;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    // Getters and Setters
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    // toString method for easy printing
    @Override
    public String toString() {
        return street + ", " + city + ", " + state + " - " + zipCode;
    }
}

