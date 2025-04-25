package org.example;

public class Chocolate extends BasicCake {
    protected BasicCake cake;
    protected String topping;

    public Chocolate(BasicCake cake) {
        super(cake.getName(), cake.getPrice());
        this.cake = cake;
        this.topping = "chocolate";
        this.price = cake.getPrice() + 0.1;
    }

    @Override
    public String getName() {
        String cakeName = cake.getName();
        if (cakeName.contains(" with ")) {
            return cakeName + " and " + topping;
        } else {
            return cakeName + " with " + topping;
        }
    }
}