package org.example;

import java.util.ArrayList;
import java.util.List;

public class Bundle extends BasicCake {
    private List<BasicCake> cakes;
    private static final double DISCOUNT = 0.1;

    public Bundle() {
        super("Empty Bundle", 0.0);
        this.cakes = new ArrayList<>();
    }

    public void addCake(BasicCake cake) {
        cakes.add(cake);
        updateNameAndPrice();
    }

    public List<BasicCake> getCakes() {
        return new ArrayList<>(cakes);
    }

    private void updateNameAndPrice() {
        if (cakes.isEmpty()) {
            this.name = "Empty Bundle";
            this.price = 0.0;
            return;
        }

        StringBuilder result = new StringBuilder("Bundle of [");
        double totalPrice = 0.0;

        for (int i = 0; i < cakes.size(); i++) {
            BasicCake cake = cakes.get(i);
            result.append(cake.getName());
            totalPrice += cake.getPrice();

            if (i < cakes.size() - 1) {
                result.append(", ");
            }
        }

        result.append("]");
        this.name = result.toString();
        this.price = totalPrice * (1 - DISCOUNT);
    }
}