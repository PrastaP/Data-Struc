// UseParty.java
import java.util.Scanner;
public class UseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Party party = new Party();

        System.out.print("Enter number of guests for the party");
        int guests = scanner.nextInt();
        party.setGuests(guests);

        System.out.println("The party has" + party.getGuests() + "guests");
        party.displayInvitation();
    }
}
