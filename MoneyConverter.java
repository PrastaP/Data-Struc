import java.util.Scanner;

public class MoneyConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt for input
        System.out.print("Enter amount: ");

        double amount = scanner.nextDouble();

        // Convert to cents
        int totalCents = (int) (amount * 100);

        // Calculate coins
        int quarters = totalCents / 25;

        int remainingCentsAfterQuarters = totalCents % 25;

        int dimes = remainingCentsAfterQuarters / 10;

        int remainingCentsAfterDimes = remainingCentsAfterQuarters % 10;

        int nickels = remainingCentsAfterDimes / 5;

        int pennies = remainingCentsAfterDimes - (nickels * 5);

        // Display result
        System.out.println("For $" + amount + ", you will have:");

        System.out.println(quarters + " quarters");

        System.out.println(dimes + " dimes");

        System.out.println(nickels + " nickels");

        System.out.println(pennies + " pennies");

        scanner.close();
    }
}
//for creativity