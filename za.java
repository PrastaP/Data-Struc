import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class za extends JFrame implements ActionListener {
    private JTextArea textArea;
    private ArrayList<String> toppingsList;
    private final int MAX_TOPPINGS = 10;
    private final String QUIT = "QUIT";

    public za() {
        setTitle("Pizza Order");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        textArea = new JTextArea(10, 30);
        textArea.setEditable(false);
        panel.add(new JScrollPane(textArea), BorderLayout.CENTER);

        JButton addButton = new JButton("Add topping");
        addButton.addActionListener(this);
        panel.add(addButton, BorderLayout.SOUTH);

        add(panel);
        setVisible(true);

        toppingsList = new ArrayList<>();
    }
    public static void main(String[] args) {
        new za();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String topping = JOptionPane.showInputDialog("Enter topping (or QUIT):");
        if (topping != null && !topping.isEmpty() && !topping.equalsIgnoreCase(QUIT)) {
            toppingsList.add(topping);
            if (toppingsList.size() < MAX_TOPPINGS) {
                JOptionPane.showMessageDialog(this, "Topping added");
            } else {
                JOptionPane.showMessageDialog(this, "Maximum reached");
            }
        } else {
            String[] toppingsArray = toppingsList.toArray(new String[0]);
            String address = "";
            boolean isDelivery = JOptionPane.showConfirmDialog(this, "Delivery?") == JOptionPane.YES_OPTION;
            if (isDelivery) {
                address = JOptionPane.showInputDialog("Enter address:");
            }
            Pizza pizza;
            if (isDelivery) {
                pizza = new DeliveryPizza(toppingsArray, toppingsList.size(), address);
            } else {
                pizza = new Pizza(toppingsArray, toppingsList.size());
            }
            textArea.setText(pizza.toString());
        }
    }
}
