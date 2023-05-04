package com.example.pw15.models;

public class Building {
    private String creationDate;
    private String type;

    public Building(String creationDate, String type) {
        this.creationDate = creationDate;
        this.type = type;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Building{" +
                "creationDate='" + creationDate + '\'' +
                ", type='" + type + '\'' +
                '}' + "\n";
    }
}
