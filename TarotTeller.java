import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class TarotTeller extends JFrame {
    private JLabel card1Label, card2Label, card3Label;
    private JLabel card1Explanation, card2Explanation, card3Explanation;
    private JButton drawButton;
    private Map<Integer, String> cardMap;
    //start screen
    public TarotTeller() {
        setSize(800, 600);
        setTitle("Tarot Teller");
        setLayout(new GridLayout(4, 2));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //label
        card1Label = new JLabel("Card 1");
        card2Label = new JLabel("Card 2");
        card3Label = new JLabel("Card 3");
        //explanation
        card1Explanation = new JLabel("");
        card2Explanation = new JLabel("");
        card3Explanation = new JLabel("");
        // random picking
        drawButton = new JButton("Draw Cards...");
        drawButton.addActionListener(new DrawButtonListener());

        //cards
        cardMap = new HashMap<>();
        cardMap.put(1, "The Fool - New beginnings, innocence, spontaneity.");
        cardMap.put(2, "The Magician - Taking action, creativity, power.");
        cardMap.put(3, "The High Priestess - Intuition, mystery, subconscious mind.");
        cardMap.put(4, "The Empress - Abundance, nurturing, fertility.");
        cardMap.put(5, "The Emperor - Authority, structure, control.");
        cardMap.put(6, "The Hierophant - Tradition, conformity, beliefs.");
        cardMap.put(7, "The Lovers - Relationships, love, harmony.");
        cardMap.put(8, "The Chariot - Control, willpower, success.");
        cardMap.put(9, "Strength - Courage, inner strength, self-control.");
        cardMap.put(10, "The Hermit - Solitude, introspection, soul-searching.");
        cardMap.put(11, "Wheel of Fortune - Change, cycles, destiny.");
        cardMap.put(12, "Justice - Fairness, truth, cause and effect.");
        cardMap.put(13, "The Hanged Man - Letting go, new perspectives, sacrifice.");
        cardMap.put(14, "Death - Endings, change, transformation.");
        cardMap.put(15, "Temperance - Balance, moderation, patience.");
        cardMap.put(16, "The Devil - Materialism, bondage, ignorance.");
        cardMap.put(17, "The Tower - Sudden change, upheaval, chaos.");
        cardMap.put(18, "The Star - Hope, spirituality, renewal.");
        cardMap.put(19, "The Moon - Illusion, fear, subconscious.");
        cardMap.put(20, "The Sun - Success, joy, vitality.");
        cardMap.put(21, "Judgement - Reflection, reckoning, inner calling.");
        cardMap.put(22, "The World - Completion, accomplishment, travel.");

        //placement
        add(card1Label);
        add(card1Explanation);
        add(card2Label);
        add(card2Explanation);
        add(card3Label);
        add(card3Explanation);
        add(drawButton);

        setVisible(true);}
    private class DrawButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            //formuul
            Random random = new Random();
            int card1 = random.nextInt(22) + 1;
            int card2 = random.nextInt(22) + 1;
            int card3 = random.nextInt(22) + 1;


            //final screen

            card1Explanation.setText(cardMap.get(card1));
            card2Explanation.setText(cardMap.get(card2));
            card3Explanation.setText(cardMap.get(card3));}}
    public static void main(String[] args){
        new TarotTeller();}}
