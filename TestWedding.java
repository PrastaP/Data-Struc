import java.time.LocalDate;
import java.util.Scanner;

// TestWedding.java
public class TestWedding {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the bride's first name:");
        String brideFirstName = scanner.nextLine();

        System.out.println("Enter the bride's last name:");
        String brideLastName = scanner.nextLine();

        System.out.println("Enter the groom's first name:");
        String groomFirstName = scanner.nextLine();

        System.out.println("Enter the groom's last name:");
        String groomLastName = scanner.nextLine();

        System.out.println("Enter the wedding date (yyyy-mm-dd):");
        String dateStr = scanner.nextLine();
        LocalDate weddingDate = LocalDate.parse(dateStr);

        System.out.println("Enter the wedding location:");
        String location = scanner.nextLine();

        Person bride = new Person(brideFirstName, brideLastName);
        Person groom = new Person(groomFirstName, groomLastName);
        Couple couple = new Couple(bride, groom);
        Wedding wedding = new Wedding(couple, weddingDate, location);

        System.out.println("Wedding details:");
        System.out.println("Bride: " + wedding.getCouple().getBride().getFirstName() + " " + wedding.getCouple().getBride().getLastName());
        System.out.println("Groom: " + wedding.getCouple().getGroom().getFirstName() + " " + wedding.getCouple().getGroom().getLastName());
        System.out.println("Wedding Date: " + wedding.getWeddingDate());
        System.out.println("Location: " + wedding.getLocation());

        scanner.close();
    }
}
