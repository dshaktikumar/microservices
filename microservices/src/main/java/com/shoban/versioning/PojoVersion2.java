package com.shoban.versioning;

public class PojoVersion2 {
    private String name;
    private String country;
    private String address;
    private String pojoId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPojoId() {
        return pojoId;
    }

    public void setPojoId(String pojoId) {
        this.pojoId = pojoId;
    }

    public PojoVersion2(String name, String country, String address, String pojoId) {
        this.name = name;
        this.country = country;
        this.address = address;
        this.pojoId = pojoId;
    }
}
