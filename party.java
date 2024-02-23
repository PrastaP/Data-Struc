// Party.java
import java.util.Scanner;

public class Party {
    private int guests;
    public void setGuests(int numGuests) {
        guests = numGuests;
    }
    public int getGuests() {
        return guests;
    }
    public void displayInvitation() {
        System.out.println("come to my party");
    }
}
