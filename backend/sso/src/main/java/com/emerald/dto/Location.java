package com.emerald.dto;

public class Location {
    private int id;
    private String phone;
    private String street;
    private String country;
    private String city;

    public Location(
        int id,
        String phone,
        String street,
        String country,
        String city
    ) {
        this.id = id;
        this.phone = phone;
        this.street = street;
        this.country = country;
        this.city = city;
    }
}
