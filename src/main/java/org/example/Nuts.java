package org.example;

public class Nuts extends BasicCake {
    protected BasicCake cake;
    protected String topping;

    public Nuts(BasicCake cake) {
        super(cake.getName(), cake.getPrice());
        this.cake = cake;
        this.topping = "nuts";
        this.price = cake.getPrice() + 0.2;
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