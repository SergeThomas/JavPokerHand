package pokerTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

//import static org.junit.Assert.assertEquals;

public class PokerHandEvaluatorTest {

    @Test
    public void testEvaluateHandStraightFlush() {
        List<String> hand = new ArrayList<>();
        hand.add("2Hearts");
        hand.add("3Hearts");
        hand.add("4Hearts");
        hand.add("5Hearts");
        hand.add("6Hearts");

        String result = PokerHandEvaluator.evaluateHand(hand);

        assertEquals("Straight Flush", result);
    }

    @Test
    public void testEvaluateHandFourOfAKind() {
        List<String> hand = new ArrayList<>();
        hand.add("2Clubs");
        hand.add("2Diamonds");
        hand.add("2Hearts");
        hand.add("2Spades");
        hand.add("5Clubs");

        String result = PokerHandEvaluator.evaluateHand(hand);

        assertEquals("Four of a Kind", result);
    }

    @Test
    public void testEvaluateHandFullHouse() {
        List<String> hand = new ArrayList<>();
        hand.add("2Clubs");
        hand.add("2Diamonds");
        hand.add("2Hearts");
        hand.add("3Spades");
        hand.add("3Hearts");

        String result = PokerHandEvaluator.evaluateHand(hand);

        assertEquals("Full House", result);
    }

    @Test
    public void testEvaluateHandFlush() {
        List<String> hand = new ArrayList<>();
        hand.add("2Hearts");
        hand.add("5Hearts");
        hand.add("7Hearts");
        hand.add("9Hearts");
        hand.add("KHearts");

        String result = PokerHandEvaluator.evaluateHand(hand);

        assertEquals("Flush", result);
    }

    @Test
    public void testEvaluateHandStraightStandard() {
        List<String> hand = new ArrayList<>();
        hand.add("5Spades");
        hand.add("6Hearts");
        hand.add("7Clubs");
        hand.add("8Diamonds");
        hand.add("9Hearts");

        String result = PokerHandEvaluator.evaluateHand(hand);

        assertEquals("Straight", result);
    }


    @Test
    public void testEvaluateHandThreeOfAKind() {
        List<String> hand = new ArrayList<>();
        hand.add("4Clubs");
        hand.add("4Diamonds");
        hand.add("4Hearts");
        hand.add("6Spades");
        hand.add("8Hearts");

        String result = PokerHandEvaluator.evaluateHand(hand);

        assertEquals("Three of a Kind", result);
    }

    @Test
    public void testEvaluateHandTwoPairs() {
        List<String> hand = new ArrayList<>();
        hand.add("5Clubs");
        hand.add("5Diamonds");
        hand.add("8Hearts");
        hand.add("8Spades");
        hand.add("KHearts");

        String result = PokerHandEvaluator.evaluateHand(hand);

        assertEquals("Two Pairs", result);
    }

    @Test
    public void testEvaluateHandOnePair() {
        List<String> hand = new ArrayList<>();
        hand.add("2Clubs");
        hand.add("2Diamonds");
        hand.add("7Hearts");
        hand.add("9Spades");
        hand.add("KHearts");

        String result = PokerHandEvaluator.evaluateHand(hand);

        assertEquals("One Pair", result);
    }

    @Test
    public void testEvaluateHandHighCards() {
        List<String> hand = new ArrayList<>();
        hand.add("2Clubs");
        hand.add("4Diamonds");
        hand.add("7Hearts");
        hand.add("9Spades");
        hand.add("KHearts");

        String result = PokerHandEvaluator.evaluateHand(hand);

        assertEquals("High Cards", result);
    }
}
