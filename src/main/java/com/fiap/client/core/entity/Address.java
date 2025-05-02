package com.fiap.client.core.entity;

import java.util.Objects;

public class Address {

    private final String id;
    private final String nickName;
    private final String street;
    private final String city;
    private final String state;
    private final String zipCode;
    private final Integer number;

    public Address(String id, String nickName, String street, String city, String state, String zipCode, Integer number) {
        this.id = Objects.requireNonNull(id, "ID cannot be null");
        this.nickName = nickName;
        this.street = Objects.requireNonNull(street, "Street cannot be null");
        this.city = Objects.requireNonNull(city, "City cannot be null");
        this.state = Objects.requireNonNull(state, "State cannot be null");
        this.zipCode = Objects.requireNonNull(zipCode, "Zip code cannot be null");
        this.number = Objects.requireNonNull(number, "Zip code cannot be null");
    }

    public String getId() {
        return id;
    }

    public String getNickName() {
        return nickName;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public Integer getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address address = (Address) o;
        return id.equals(address.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Address{" +
                "id='" + id + '\'' +
                ", nickName='" + nickName + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }


}

