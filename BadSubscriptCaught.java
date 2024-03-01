import javax.swing.*;

public class BadSubscriptCaught {
    public static void main(String[] args) {
        String[] names = {"Lucy", "Luke", "Abby", "Andy", "Eve", "Evan", "Molly", "Teresa", "Claire", "Jackson"};
        try {
            String input = JOptionPane.showInputDialog("Enter the index (0-9) to display the name:");
            int index = Integer.parseInt(input);
            if (index < 0 || index >= names.length) {
                throw new ArrayIndexOutOfBoundsException();
            }
            JOptionPane.showMessageDialog(null, "Name at index " + index + " is: " + names[index]);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please enter a valid integer.");
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Error: Index out of bounds. Please enter a number between 0 and 9.");
        }
    }
}
