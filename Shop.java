import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class Item {
    private String name;
    private double price;
    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    @Override
    public String toString() {
        return name + " - $" + price;
    }
}
class ItemOrder {
    private Item item;
    private int quantity;
    public ItemOrder(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }
    public Item getItem() {
        return item;
    }
    public int getQuantity() {
        return quantity;
    }
    public double getTotalPrice() {
        return item.getPrice() * quantity;
    }
}
class ShoppingCart {
    private ArrayList<ItemOrder> itemOrders;
    public ShoppingCart() {
        itemOrders = new ArrayList<>();
    }
    public void addItemOrder(ItemOrder itemOrder) {
        itemOrders.add(itemOrder);
    }
    public void removeItemOrder(ItemOrder itemOrder) {
        itemOrders.remove(itemOrder);
    }
    public double getTotalPrice() {
        double totalPrice = 0;
        for (ItemOrder itemOrder : itemOrders) {
            totalPrice += itemOrder.getTotalPrice();
        }
        return totalPrice;
    }
    public ArrayList<ItemOrder> getItemOrders() {
        return itemOrders;
    }
}
public class Shop extends JFrame implements ActionListener {
    private ShoppingCart cart;
    private JTextArea textArea;
    public Shop() {
        cart = new ShoppingCart();

        setTitle("Shopping List");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        textArea = new JTextArea(10, 30);
        textArea.setEditable(false);
        panel.add(new JScrollPane(textArea), BorderLayout.CENTER);

        JButton addButton = new JButton("Add Item");
        addButton.addActionListener(this);
        panel.add(addButton, BorderLayout.SOUTH);

        add(panel);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Shop();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = JOptionPane.showInputDialog("Enter item:");
        double price = Double.parseDouble(JOptionPane.showInputDialog("Enter price:"));
        int quantity = Integer.parseInt(JOptionPane.showInputDialog("Enter quantity:"));

        Item item = new Item(name, price);
        ItemOrder itemOrder = new ItemOrder(item, quantity);
        cart.addItemOrder(itemOrder);

        StringBuilder sb = new StringBuilder();
        for (ItemOrder io : cart.getItemOrders()) {
            sb.append(io.getItem().getName()).append(" - Quantity: ").append(io.getQuantity())
                    .append(" - Total Price: $").append(io.getTotalPrice()).append("\n");
        }
        sb.append("\nTotal Price: $").append(cart.getTotalPrice());

        textArea.setText(sb.toString());
    }
}
