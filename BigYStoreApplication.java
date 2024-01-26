import java.util.Scanner;

public class BigYStoreApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to BigY Store!");
        System.out.println("Select your pizza order:");
        System.out.println("1. Olive Pizza");
        System.out.println("2. Pepperoni Pizza");
        System.out.println("3. Veggie Pizza");

        int pizzaChoice = scanner.nextInt();
        double basePrice = getBasePrice(pizzaChoice);

        System.out.println("Choose pizza size:");
        System.out.println("1. Small ($5.99)");
        System.out.println("2. Medium ($9.99)");
        System.out.println("3. Large ($13.99)");
        System.out.println("4. Super ($15.99)");

        int sizeChoice = scanner.nextInt();
        double sizePrice = getSizePrice(sizeChoice);

        System.out.println("How many toppings do you want? (max 3)");
        int numToppings = scanner.nextInt();
        double toppingsPrice = getToppingsPrice(numToppings);

        double totalCost = basePrice + sizePrice + toppingsPrice;

        System.out.println("Your order:");
        System.out.println("Pizza: " + getPizzaName(pizzaChoice));
        System.out.println("Size: " + getSizeName(sizeChoice));
        System.out.println("Toppings: " + numToppings);
        System.out.println("Total Cost: $" + totalCost);
    }

    private static double getBasePrice(int pizzaChoice) {
        return switch (pizzaChoice) {
            case 1 -> 3.99; // Olive Pizza
            case 2 -> 5.99; // Pepperoni Pizza
            case 3 -> 4.99; // Veggie Pizza
            default -> 0.0;
        };
    }

    private static double getSizePrice(int sizeChoice) {
        return switch (sizeChoice) {
            case 1 -> 5.99; // Small
            case 2 -> 9.99; // Medium
            case 3 -> 13.99; // Large
            case 4 -> 15.99; // Super
            default -> 0.0;
        };
    }

    private static String getPizzaName(int pizzaChoice) {
        return switch (pizzaChoice) {
            case 1 -> "Olive Pizza";
            case 2 -> "Pepperoni Pizza";
            case 3 -> "Veggie Pizza";
            default -> "Unknown Pizza";
        };
    }

    private static String getSizeName(int sizeChoice) {
        return switch (sizeChoice) {
            case 1 -> "Small";
            case 2 -> "Medium";
            case 3 -> "Large";
            case 4 -> "Super";
            default -> "Unknown Size";
        };
    }

    private static double getToppingsPrice(int numToppings) {
        if (numToppings == 1) {
            return 0.5;
        } else if (numToppings == 2) {
            return 1.0;
        } else if (numToppings == 3) {
            return 1.25;
        } else {
            return 0.0;
        }
    }
}
//the creativity was the pizza toppings I chose because they are my favorite