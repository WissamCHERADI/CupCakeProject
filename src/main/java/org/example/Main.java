package org.example;

public class Main {
    public static void main(String[] args) {
        BasicCake cupcake = new Cupcake();
        BasicCake cookie = new Cookie();

        BasicCake chocolateCupcake = new Chocolate(cupcake);
        BasicCake sugarCookie = new Sugar(cookie);
        BasicCake nutsCupcake = new Nuts(cupcake);
        BasicCake chocolateAndNutsCupcake = new Nuts(new Chocolate(cupcake));

        System.out.println("=== Gâteaux individuels ===");
        printCakeInfo(cupcake);
        printCakeInfo(cookie);
        printCakeInfo(chocolateCupcake);
        printCakeInfo(sugarCookie);
        printCakeInfo(nutsCupcake);
        printCakeInfo(chocolateAndNutsCupcake);

        Bundle bundle1 = new Bundle();
        bundle1.addCake(chocolateCupcake);
        bundle1.addCake(sugarCookie);

        Bundle bundle2 = new Bundle();
        bundle2.addCake(cupcake);
        bundle2.addCake(cookie);
        bundle2.addCake(chocolateAndNutsCupcake);

        System.out.println("\n=== Bundles ===");
        printCakeInfo(bundle1);
        printCakeInfo(bundle2);

        Bundle emptyBundle = new Bundle();
        System.out.println("\n=== Bundle vide ===");
        printCakeInfo(emptyBundle);

        System.out.println("\n=== Contenu du bundle2 ===");
        for (BasicCake cake : bundle2.getCakes()) {
            printCakeInfo(cake);
        }
    }

    private static void printCakeInfo(BasicCake cake) {
        System.out.printf("%s - %.2f€\n", cake.getName(), cake.getPrice());
    }
}