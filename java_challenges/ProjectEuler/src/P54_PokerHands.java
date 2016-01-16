import com.sun.deploy.util.StringUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.countMatches;
import static org.apache.commons.lang3.StringUtils.join;

public class P54_PokerHands {
    // Project Euler - Problem 54 - Poker hands
    // In the card game poker, a hand consists of five cards and are ranked, from lowest to highest, 
    // in the following way:
    //   - High Card: Highest value card.
    //   - One Pair: Two cards of the same value.
    //   - Two Pairs: Two different pairs.
    //   - Three of a Kind: Three cards of the same value.
    //   - Straight: All cards are consecutive values.
    //   - Flush: All cards of the same suit.
    //   - Full House: Three of a kind and a pair.
    //   - Four of a Kind: Four cards of the same value.
    //   - Straight Flush: All cards are consecutive values of same suit.
    //   - Royal Flush: Ten, Jack, Queen, King, Ace, in same suit.
    // The cards are valued in the order: 2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen, King, Ace.
    // If two players have the same ranked hands then the rank made up of the highest value wins;
    // for example, a pair of eights beats a pair of fives (see example 1 below).
    // But if two ranks tie, for example, both players have a pair of queens,
    // then highest cards in each hand are compared (see example 4 below);
    // if the highest cards tie then the next highest cards are compared, and so on.
    // Consider the following five hands dealt to two players:
    // Hand Player 1                           Player 2                             Winner
    // 1    5H 5C 6S 7S KD (Pair of Fives)     2C 3S 8S 8D TD (Pair of Eights)      Player 2
    // 2    5D 8C 9S JS AC (Highest card Ace)  2C 5C 7D 8S QH (Highest card Queen)  Player 1
    // 3    2D 9C AS AH AC (Three Aces)        3D 6D 7D TD QD (Flush with Diamonds) Player 2
    // 4    4D 6S 9H QH QC (Pair of Queens,    3D 6D 7H QD QS (Pair of Queens,
    //                      Highest card Nine)                 Highest card Seven)  Player 1
    // 5    2H 2D 4C 4D 4S (Full House,        3C 3D 3S 9S 9D (Full House,
    //                      With Three Fours)                  with Three Threes)   Player 1
    // The file, poker.txt, contains one-thousand random hands dealt to two players.
    // Each line of the file contains ten cards (separated by a single space):
    // the first five are Player 1's cards and the last five are Player 2's cards.
    // You can assume that all hands are valid (no invalid characters or repeated cards),
    // each player's hand is in no specific order, and in each hand there is a clear winner.
    // How many hands does Player 1 win?

    public static void main(String[] args) throws IOException {
        int solution = P54_PokerHands.scoreHands();
        String message = "Player 1 wins %,d hands.\n";
        System.out.printf(message, solution);
    }

    private static final String HANDS_FILE = "file/p054_poker.txt";
    private static final String[] CARD_VALUES = new String[]
            {"2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K", "A"};

    static int scoreHands() throws IOException {
        List lines = new ResourceFile(HANDS_FILE).getLines();
        int player1Wins = 0;
        for (Object line : lines) {
//            System.out.println("line = " + line);
            String[] cards = StringUtils.splitString(String.valueOf(line), " ");
//            System.out.println("cards = " + Arrays.toString(cards));
            String[] handPlayer1 = Arrays.copyOfRange(cards, 0, 5);
//            System.out.println("handPlayer1 = " + Arrays.toString(handPlayer1));
            String[] handPlayer2 = Arrays.copyOfRange(cards, 5, 10);
//            System.out.println("handPlayer2 = " + Arrays.toString(handPlayer2));
            int scorePlayer1 = scoreHand(handPlayer1);
            int scorePlayer2 = scoreHand(handPlayer2);
            if (scorePlayer1 > scorePlayer2) player1Wins++;
        }
        return player1Wins;
    }

    static int scoreHand(String[] hand) {
        //   - High Card: Highest value card.
        //   - One Pair: Two cards of the same value.
        //   - Two Pairs: Two different pairs.
        //   - Three of a Kind: Three cards of the same value.
        //   - Straight: All cards are consecutive values.
        //   - Flush: All cards of the same suit.
        //   - Full House: Three of a kind and a pair.
        //   - Four of a Kind: Four cards of the same value.
        //   - Straight Flush: All cards are consecutive values of same suit.
        //   - Royal Flush: Ten, Jack, Queen, King, Ace, in same suit.
        int score = 0;
        score += scoreHighestCard(hand);
        score += scorePairs(hand);
        score += scoreThreeOfAKind(hand);
        score += scoreStraight(hand);
        score += scoreFlush(hand);
        score += scoreFullHouse(hand);
        score += scoreStraightFlush(hand);
        score += scoreRoyalFlush(hand);
        return score;
    }

    static int scoreRoyalFlush(String[] hand) {
        return 0;
    }

    static int scoreStraightFlush(String[] hand) {
        return 0;
    }

    static int scoreFullHouse(String[] hand) {
        int score = 0;
        if (hasPair(hand) && hasThreeOfAKind(hand)) score += 100;
        return score;
    }

    static int scoreFlush(String[] hand) {
        return hasFlush(hand) ? 50 : 0;
    }

    static boolean hasFlush(String[] hand) {
        String firstSuite = hand[0].substring(1);
        for (int i = 1; i <= 4; i++) {
            String thisSuite = hand[i].substring(1);
            if (!thisSuite.equals(firstSuite)) return false;
        }
        return true;
    }

    static int scoreStraight(String[] hand) {
        int[] values = new int[5];
        getSortedValues(hand);
        return 0;
    }

    static int[] getSortedValues(String[] hand) {
        int[] values = new int[5];
        for (int i = 0; i <= 4; i++) {
            values[i] = Integer.parseInt(String.valueOf(hand[i].charAt(0)));
        }
        Arrays.sort(values);
        return values;
    }

    static int scoreThreeOfAKind(String[] hand) {
        return hasThreeOfAKind(hand) ? 40 : 0;
    }

    static int scorePairs(String[] hand) {
        int score = 0;
        for (String cardValue : CARD_VALUES) {
            if (hasPair(hand, cardValue)) {
                score += 20 + scoreCard(cardValue);
            }
        }
        return score;
    }

    static int scoreHighestCard(String[] hand) {
        int score = 0;
        for (int i = 0; i <= 4; i++) {
            int cardScore = scoreCard(hand[0]);
            if (cardScore > score) score = cardScore;
        }
        return score;
    }

    static int scoreCard(String card) {
        String cardValue = card.substring(0, 1);
        if (cardValue.equals("A")) return 14;
        if (cardValue.equals("K")) return 13;
        if (cardValue.equals("Q")) return 12;
        if (cardValue.equals("J")) return 11;
        if (cardValue.equals("T")) return 10;
        return Integer.parseInt(cardValue);
    }

    static boolean hasThreeOfAKind(String[] hand) {
        for (String cardValue : CARD_VALUES) {
            if (hasThreeOfAKind(hand, cardValue)) return true;
        }
        return false;
    }

    static boolean hasThreeOfAKind(String[] hand, String cardValue) {
        return hasRun(hand, cardValue, 3);
    }

    static boolean hasPair(String[] hand) {
        for (String cardValue : CARD_VALUES) {
            if (hasPair(hand, cardValue)) return true;
        }
        return false;
    }

    static boolean hasPair(String[] hand, String cardValue) {
        return hasRun(hand, cardValue, 2);
    }

    static boolean hasRun(String[] hand, String cardValue, int count) {
        String handString = join(hand, ",");
        int matches = countMatches(handString, cardValue);
        return matches == count;
    }
}
