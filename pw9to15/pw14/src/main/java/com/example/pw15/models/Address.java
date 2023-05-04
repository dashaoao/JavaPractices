package com.example.pw15.models;

public class Address {
    private String addressText;
    private String zipCode;

    public Address(String addressText, String zipCode) {
        this.addressText = addressText;
        this.zipCode = zipCode;
    }

    public String getAddressText() {
        return addressText;
    }

    public String getZipCode() {
        return zipCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressText='" + addressText + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}' + "\n";
    }
}
