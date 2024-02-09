import javax.swing.*;

public class BigYStoreApplication {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Pizza Order");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }
    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel welcomeLabel = new JLabel("Welcome to BigY!");
        welcomeLabel.setBounds(10, 20, 150, 25);
        panel.add(welcomeLabel);

        JLabel pizzaLabel = new JLabel("Choose pizza:");
        pizzaLabel.setBounds(10, 50, 150, 25);
        panel.add(pizzaLabel);

        JComboBox<String> pizzaComboBox = new JComboBox<>(new String[]{"Olive", "Pepperoni", "Veggie"});
        pizzaComboBox.setBounds(180, 50, 150, 25);
        panel.add(pizzaComboBox);

        JLabel sizeLabel = new JLabel("Choose size:");
        sizeLabel.setBounds(10, 80, 150, 25);
        panel.add(sizeLabel);

        JComboBox<String> sizeComboBox = new JComboBox<>(new String[]{"Small ($5.99)", "Medium ($9.99)", "Large ($13.99)", "Extra Large ($15.99)"});
        sizeComboBox.setBounds(180, 80, 150, 25);
        panel.add(sizeComboBox);

        JLabel toppingsLabel = new JLabel("How many toppings? (3 max)");
        toppingsLabel.setBounds(10, 110, 300, 25);
        panel.add(toppingsLabel);

        JTextField toppingsField = new JTextField();
        toppingsField.setBounds(320, 110, 50, 25);
        panel.add(toppingsField);

        JButton orderButton = new JButton("Order");
        orderButton.setBounds(150, 150, 100, 25);
        panel.add(orderButton);

        JTextArea resultTextArea = new JTextArea();
        resultTextArea.setBounds(10, 180, 370, 70);
        resultTextArea.setEditable(false);
        panel.add(resultTextArea);

        orderButton.addActionListener(e -> {
            int pizzaChoice = pizzaComboBox.getSelectedIndex() + 1;
            double basePrice = getBasePrice(pizzaChoice);

            int sizeChoice = sizeComboBox.getSelectedIndex() + 1;
            double sizePrice = getSizePrice(sizeChoice);

            int numToppings = Integer.parseInt(toppingsField.getText());
            double toppingsPrice = getToppingsPrice(numToppings);

            double totalCost = basePrice + sizePrice + toppingsPrice;
            String orderResult = "Your order:\n" +
                    "Pizza: " + pizzaComboBox.getSelectedItem() + "\n" +
                    "Size: " + sizeComboBox.getSelectedItem() + "\n" +
                    "Toppings: " + numToppings + "\n" +
                    "Total Cost: $" + totalCost;
            resultTextArea.setText(orderResult);
        });
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
            case 4 -> 15.99; // Extra Large
            default -> 0.0;
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
} //the creativity was the pizza toppings I chose because they are my favorite