package org.example;

public class BasicCake {
    protected String name;
    protected double price;

    public BasicCake(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}