package pokerTest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class PokerHandEvaluator {

    public static final String[] RANKS = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
    public static final String[] SUITS = {"Hearts", "Diamonds", "Clubs", "Spades"};

    // Method to evaluate hand
    public static String evaluateHand(List<String> hand) {
        Collections.sort(hand);

        if (isStraightFlush(hand)) {
            return "Straight Flush";
        } else if (isFourOfAKind(hand)) {
            return "Four of a Kind";
        } else if (isFullHouse(hand)) {
            return "Full House";
        } else if (isFlush(hand)) {
            return "Flush";
        } else if (isStraight(hand)) {
            return "Straight";
        } else if (isThreeOfAKind(hand)) {
            return "Three of a Kind";
        } else if (isTwoPairs(hand)) {
            return "Two Pairs";
        } else if (isOnePair(hand)) {
            return "One Pair";
        } else {
            return "High Cards";
        }
    }

    // Method to determine straight flush
    private static boolean isStraightFlush(List<String> hand) {
        return isStraight(hand) && isFlush(hand);
    }

    // Method to determine four of a kind
    private static boolean isFourOfAKind(List<String> hand) {
        int[] ranksCount = new int[RANKS.length];
        int[] ranksCountArray = cardPositionValidator(hand, ranksCount);

        for (int count : ranksCountArray) {
            if (count == 4) {
                return true;
            }
        }
        return false;
    }

    //    method to determine full house
    private static boolean isFullHouse(List<String> hand) {
        int[] ranksCount = new int[RANKS.length];
        int[] ranksCountArray = cardPositionValidator(hand, ranksCount);

        boolean hasThreeOfAKind = false;
        boolean hasPair = false;
        for (int count : ranksCountArray) {
            if (count == 3) {
                hasThreeOfAKind = true;
            } else if (count == 2) {
                hasPair = true;
            }
        }
        return hasThreeOfAKind && hasPair;
    }

    private static boolean isFlush(List<String> hand) {
        String firstCardSuit = hand.get(0).substring(1); // Removes the first character ('J')
        for (String card : hand) {
            String cardSuit = card.substring(1);
            if (!cardSuit.equals(firstCardSuit)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isStraight(List<String> hand) {
        // Sort cards by rank
        List<Integer> ranks = new ArrayList<>();
        for (String card : hand) {
            String rank = card.substring(0, card.length() - 1);
            ranks.add(convertRankToInt(rank));
        }
//        System.out.println("**");
//        System.out.println(ranks);
        Collections.sort(ranks);
//        System.out.println("##");
//        System.out.println(ranks);

        // Check for consecutive or A-2-3-4-5 wrap-around ranks
        for (int i = 0; i < ranks.size() - 1; i++) {
            int difference = ranks.get(i + 1) - ranks.get(i);
            if (difference != 1) {
                // Not consecutive, check for A-2-3-4-5 wrap-around (special case)
                if (i == 0 && ranks.get(0) == 1 && ranks.get(ranks.size() - 1) == 13) {
                    return true; // A-2-3-4-5 Straight
                }
                return false;  // Not a Straight
            }
        }
        return true; // Straight
    }

    private static int convertRankToInt(String card) {
        // Extract the rank from the card string
        String rank = String.valueOf(card.charAt(0));

        // Convert rank string to integer (1-13)
        switch (rank) {
            case "A":
                return 1;
            case "J":
                return 11;
            case "Q":
                return 12;
            case "K":
                return 13;
            default:
                return Integer.parseInt(rank);
        }
    }

    private static boolean isThreeOfAKind(List<String> hand) {
        int[] ranksCount = new int[RANKS.length];

        int[] ranksCountArray = cardPositionValidator(hand, ranksCount);
        for (int count : ranksCountArray) {
            if (count == 3) {
                return true;
            }
        }
        return false;
    }

    private static boolean isTwoPairs(List<String> hand) {
        int[] ranksCount = new int[RANKS.length];
        int pairsCount = 0;
        for (String card : hand) {
            String rank = card.substring(0, card.length() - 1);

            int newRank = 0;

            String[] rankSplit = rank.split("");

            if (rankSplit[0].equals("A")) {
                continue;
            } else if (rankSplit[0].equals("Q")) {
                continue;
            } else if (rankSplit[0].equals("K")) {
                continue;
            } else if (rankSplit[0].equals("J")) {
                continue;
            } else {
                newRank = Integer.parseInt(rankSplit[0]);
            }

            if (rankSplit[0].equals("1")) {
                newRank = 10;
            }

            int rankIndex = Arrays.asList(RANKS).indexOf(String.valueOf(newRank));
            ranksCount[rankIndex]++;
            if (ranksCount[rankIndex] == 2) {
                pairsCount++;
            }
        }
        return pairsCount == 2;
    }

    private static boolean isOnePair(List<String> hand) {
        int[] ranksCount = new int[RANKS.length];
        int[] ranksCountArray = cardPositionValidator(hand, ranksCount);

        for (int count : ranksCountArray) {
            if (count == 2) {
                return true;
            }
        }
        return false;
    }

    public static int[] cardPositionValidator(List<String> hand, int[] ranksCount) {
        int newRank = 0;
        for (String card : hand) {
            String rank = card.substring(0, card.length() - 1);
            String[] rankSplit = rank.split("");

            if (rankSplit[0].equals("A")) {
                continue;
            } else if (rankSplit[0].equals("Q")) {
                continue;
            } else if (rankSplit[0].equals("K")) {
                continue;
            } else if (rankSplit[0].equals("J")) {
                continue;
            } else {
                newRank = Integer.parseInt(rankSplit[0]);
            }

            if (rankSplit[0].equals("1")) {
                newRank = 10;
            }
            int rankIndex = Arrays.asList(RANKS).indexOf(String.valueOf(newRank));
            ranksCount[rankIndex]++;
            // ranks[0,4, 1, 1]
        }
        return ranksCount;
    }
}
