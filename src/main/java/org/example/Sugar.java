package org.example;

public class Sugar extends BasicCake {
    protected BasicCake cake;
    protected String topping;

    public Sugar(BasicCake cake) {
        super(cake.getName(), cake.getPrice());
        this.cake = cake;
        this.topping = "sugar";
        this.price = cake.getPrice() + 0.05;
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