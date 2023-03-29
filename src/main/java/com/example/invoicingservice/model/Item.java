package com.example.invoicingservice.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;

public class Item {
    @NotEmpty(message = "Item name cannot be empty")
    private String name;
    private double price;

    public Item(@Valid String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}