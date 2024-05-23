package pokerTest;
import java.util.*;


public class PokerGame {

    public static void main(String[] args) {
        // Simulate shuffling a standard deck of 52 cards
        List<String> deck = createDeck();
        System.out.print("Shuffling ... ");
        Collections.shuffle(deck);
        System.out.println("Shuffling ... ");
        Collections.shuffle(deck);
        System.out.println("Shuffling ... ");

        // Deal a single hand of 5 cards to the player
        List<String> hand = dealHand(deck);

        // Print the player's hand
        System.out.println("Your hand: " + formatHand(hand));

        // Evaluate the player's hand
        String handRank = pokerTest.PokerHandEvaluator.evaluateHand(hand);

        // Print out the highest ranked hand that matches the hand of 5 cards
        System.out.println("You have: " + handRank);
    }

    // Method to create a standard deck of 52 cards
    private static List<String> createDeck() {
        List<String> deck = new ArrayList<>();
        for (String rank : PokerHandEvaluator.RANKS) {
            for (String suit : PokerHandEvaluator.SUITS) {
                deck.add(rank + suit);
            }
        }
        return deck;
    }

    // Method to deal a single hand of 5 cards
    private static List<String> dealHand(List<String> deck) {
        List<String> hand = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            hand.add(deck.remove(0));
        }
        return hand;
    }

    // Method to format the player's hand for printing
    private static String formatHand(List<String> hand) {
        StringBuilder formattedHand = new StringBuilder();
        for (String card : hand) {
            formattedHand.append(card).append(" ");
        }
        return formattedHand.toString().trim();
    }
}

