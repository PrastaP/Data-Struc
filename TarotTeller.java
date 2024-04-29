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
        card1Label = new JLabel("Your Past...");
        card2Label = new JLabel("Your Present...");
        card3Label = new JLabel("Your Future...");
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
        cardMap.put(23, "Ace of Wands - Inspiration, new opportunities, growth.");
        cardMap.put(24, "Two of Wands - Planning, making decisions, leaving home.");
        cardMap.put(25, "Three of Wands - Looking ahead, expansion, rapid growth.");
        cardMap.put(26, "Four of Wands - Celebration, joy, harmony, relaxation.");
        cardMap.put(27, "Five of Wands - Conflict, disagreements, competition.");
        cardMap.put(28, "Six of Wands - Victory, success, public recognition.");
        cardMap.put(29, "Seven of Wands - Challenge, competition, perseverance.");
        cardMap.put(30, "Eight of Wands - Speed, action, air travel, quick changes.");
        cardMap.put(31, "Nine of Wands - Resilience, grit, last stand, persistence.");
        cardMap.put(32, "Ten of Wands - Burden, extra responsibility, hard work.");
        cardMap.put(33, "Page of Wands - Exploration, excitement, freedom.");
        cardMap.put(34, "Knight of Wands - Energy, passion, adventure.");
        cardMap.put(35, "Queen of Wands - Courage, determination, joy.");
        cardMap.put(36, "King of Wands - Leadership, vision, entrepreneur, honour.");
        cardMap.put(37, "Ace of Cups - Love, new relationships, compassion, creativity.");
        cardMap.put(38, "Two of Cups - Unity, partnership, connection.");
        cardMap.put(39, "Three of Cups - Celebration, friendship, community.");
        cardMap.put(40, "Four of Cups - Meditation, contemplation, apathy, reevaluation.");
        cardMap.put(41, "Five of Cups - Loss, regret, disappointment, grief.");
        cardMap.put(42, "Six of Cups - Reunion, nostalgia, childhood memories.");
        cardMap.put(43, "Seven of Cups - Fantasy, illusion, wishful thinking.");
        cardMap.put(44, "Eight of Cups - Withdrawal, escapism, disillusionment.");
        cardMap.put(45, "Nine of Cups - Satisfaction, emotional stability, luxury.");
        cardMap.put(46, "Ten of Cups - Harmony, relationships, joy, contentment.");
        cardMap.put(47, "Page of Cups - Creativity, intuition, romance.");
        cardMap.put(48, "Knight of Cups - Romance, charm, imagination.");
        cardMap.put(49, "Queen of Cups - Compassion, calm, comfort.");
        cardMap.put(50, "King of Cups - Emotional balance, control, generosity.");
        cardMap.put(51, "Ace of Swords - Breakthroughs, clarity, new ideas.");
        cardMap.put(52, "Two of Swords - Difficult decisions, indecision, stalemate.");
        cardMap.put(53, "Three of Swords - Heartbreak, emotional pain, sorrow.");
        cardMap.put(54, "Four of Swords - Rest, relaxation, meditation, contemplation.");
        cardMap.put(55, "Five of Swords - Conflict, defeat, winning at all costs.");
        cardMap.put(56, "Six of Swords - Transition, leaving behind, moving on.");
        cardMap.put(57, "Seven of Swords - Betrayal, deception, getting away with something.");
        cardMap.put(58, "Eight of Swords - Confinement, helplessness, being stuck.");
        cardMap.put(59, "Nine of Swords - Anxiety, worry, fear, depression.");
        cardMap.put(60, "Ten of Swords - Back-stabbing, defeat, crisis, betrayal.");
        cardMap.put(61, "Page of Swords - Curiosity, restlessness, mental energy.");
        cardMap.put(62, "Knight of Swords - Action, impulsiveness, adventure.");
        cardMap.put(63, "Queen of Swords - Clarity, perspective, independence.");
        cardMap.put(64, "King of Swords - Mental clarity, authority, truth.");
        cardMap.put(65, "Ace of Pentacles - Manifestation, new financial opportunity, prosperity.");
        cardMap.put(66, "Two of Pentacles - Balance, adaptability, time management.");
        cardMap.put(67, "Three of Pentacles - Teamwork, collaboration, learning.");
        cardMap.put(68, "Four of Pentacles - Stability, security, possessiveness.");
        cardMap.put(69, "Five of Pentacles - Hard times, challenges, loss, insecurity.");
        cardMap.put(70, "Six of Pentacles - Generosity, charity, giving and receiving.");
        cardMap.put(71, "Seven of Pentacles - Vision, perseverance, profit, reward.");
        cardMap.put(72, "Eight of Pentacles - Mastery, skill development, hard work.");
        cardMap.put(73, "Nine of Pentacles - Fruits of labor, rewards, luxury, self-sufficiency.");
        cardMap.put(74, "Ten of Pentacles - Legacy, culmination, inheritance, stability.");
        cardMap.put(75, "Page of Pentacles - Manifestation, financial opportunity, skill development.");
        cardMap.put(76, "Knight of Pentacles - Hard work, productivity, routine.");
        cardMap.put(77, "Queen of Pentacles - Nurturing, practical, providing financially, a working parent.");
        cardMap.put(78, "King of Pentacles - Abundance, prosperity, security, control.");

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
            int card1 = random.nextInt(78) + 1;
            int card2 = random.nextInt(78) + 1;
            int card3 = random.nextInt(78) + 1;


            //final screen

            card1Explanation.setText(cardMap.get(card1));
            card2Explanation.setText(cardMap.get(card2));
            card3Explanation.setText(cardMap.get(card3));}}
    public static void main(String[] args){
        new TarotTeller();}}
