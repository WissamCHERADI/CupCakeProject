package org.example;

public class CakeTest {
    public static void main(String[] args) {
        testBasicCakes();
        testToppings();
        testMultipleToppings();
        testBundles();
        testPrices();
    }

    private static void testBasicCakes() {
        System.out.println("=== TEST GÂTEAUX DE BASE ===");
        BasicCake cupcake = new Cupcake();
        BasicCake cookie = new Cookie();

        System.out.println("Cupcake: " + cupcake.getName() + " - " + cupcake.getPrice() + "€");
        System.out.println("Cookie: " + cookie.getName() + " - " + cookie.getPrice() + "€");
        System.out.println("Test gâteaux de base réussi!\n");
    }

    private static void testToppings() {
        System.out.println("=== TEST GARNITURES ===");
        BasicCake cupcake = new Cupcake();
        BasicCake cookie = new Cookie();

        BasicCake chocolateCupcake = new Chocolate(cupcake);
        BasicCake sugarCookie = new Sugar(cookie);
        BasicCake nutsCupcake = new Nuts(cupcake);

        System.out.println(chocolateCupcake.getName() + " - " + chocolateCupcake.getPrice() + "€");
        System.out.println(sugarCookie.getName() + " - " + sugarCookie.getPrice() + "€");
        System.out.println(nutsCupcake.getName() + " - " + nutsCupcake.getPrice() + "€");
        System.out.println("Test garnitures réussi!\n");
    }

    private static void testMultipleToppings() {
        System.out.println("=== TEST GARNITURES MULTIPLES ===");
        BasicCake cupcake = new Cupcake();

        BasicCake chocolateAndNuts = new Nuts(new Chocolate(cupcake));
        BasicCake sugarAndChocolate = new Chocolate(new Sugar(cupcake));
        BasicCake allToppings = new Sugar(new Nuts(new Chocolate(cupcake)));

        System.out.println(chocolateAndNuts.getName() + " - " + chocolateAndNuts.getPrice() + "€");
        System.out.println(sugarAndChocolate.getName() + " - " + sugarAndChocolate.getPrice() + "€");
        System.out.println(allToppings.getName() + " - " + allToppings.getPrice() + "€");
        System.out.println("Test garnitures multiples réussi!\n");
    }

    private static void testBundles() {
        System.out.println("=== TEST BUNDLES ===");
        BasicCake cupcake = new Cupcake();
        BasicCake cookie = new Cookie();
        BasicCake chocolateCupcake = new Chocolate(cupcake);

        Bundle emptyBundle = new Bundle();
        System.out.println("Bundle vide: " + emptyBundle.getName() + " - " + emptyBundle.getPrice() + "€");

        Bundle singleCakeBundle = new Bundle();
        singleCakeBundle.addCake(cupcake);
        System.out.println("Bundle avec un gâteau: " + singleCakeBundle.getName() + " - " + singleCakeBundle.getPrice() + "€");

        Bundle multiCakeBundle = new Bundle();
        multiCakeBundle.addCake(cupcake);
        multiCakeBundle.addCake(cookie);
        multiCakeBundle.addCake(chocolateCupcake);
        System.out.println("Bundle avec plusieurs gâteaux: " + multiCakeBundle.getName() + " - " + multiCakeBundle.getPrice() + "€");

        System.out.println("Contenu du bundle multi-gâteaux:");
        for (BasicCake cake : multiCakeBundle.getCakes()) {
            System.out.println("- " + cake.getName() + " - " + cake.getPrice() + "€");
        }

        System.out.println("Test bundles réussi!\n");
    }

    private static void testPrices() {
        System.out.println("=== TEST PRIX ===");

        BasicCake cupcake = new Cupcake();
        BasicCake cookie = new Cookie();

        BasicCake chocolateCupcake = new Chocolate(cupcake);
        BasicCake nutsCupcake = new Nuts(cupcake);
        BasicCake sugarCookie = new Sugar(cookie);

        BasicCake chocolateAndNutsCupcake = new Nuts(new Chocolate(cupcake));

        Bundle bundle = new Bundle();
        bundle.addCake(cupcake);
        bundle.addCake(cookie);
        double expectedPrice = (1.0 + 2.0) * 0.9;

        System.out.println("Prix du cupcake: " + cupcake.getPrice() + "€");
        System.out.println("Prix du cookie: " + cookie.getPrice() + "€");
        System.out.println("Prix du cupcake chocolat: " + chocolateCupcake.getPrice() + "€");
        System.out.println("Prix du cupcake noix: " + nutsCupcake.getPrice() + "€");
        System.out.println("Prix du cookie sucre: " + sugarCookie.getPrice() + "€");
        System.out.println("Prix du cupcake chocolat et noix: " + chocolateAndNutsCupcake.getPrice() + "€");
        System.out.println("Prix du bundle (attendu: " + expectedPrice + "€): " + bundle.getPrice() + "€");

        if (Math.abs(bundle.getPrice() - expectedPrice) < 0.001) {
            System.out.println("Prix du bundle correct!");
        } else {
            System.out.println("Prix du bundle incorrect!");
        }

        System.out.println("Test prix réussi!\n");
    }
}