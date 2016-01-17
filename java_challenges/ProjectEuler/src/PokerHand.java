import java.util.Arrays;

import static org.apache.commons.lang3.StringUtils.countMatches;
import static org.apache.commons.lang3.StringUtils.join;

public class PokerHand {

    static boolean hasRoyalFlush(String[] hand) {
        return hasStraight(hand) && hasFlush(hand) && hasAce(hand);
    }

    static boolean hasStraight(int[] sortedValues) {
        return hasStraightWithHighAce(sortedValues) ||
                hasStraightWithLowAce(sortedValues);
    }

    static boolean hasStraightWithHighAce(int[] values) {
        for (int i = 1; i <= 4; i++) if (values[i] != values[i - 1] + 1) return false;
        return true;
    }

    static boolean hasStraightWithLowAce(int[] sortedValues) {
        for (int i = 0; i <= 3; i++) if (sortedValues[i] != i + 2) return false;
        return sortedValues[4] == 14;
    }

    static boolean hasStraight(String[] hand) {
        return hasStraight(getSortedValues(hand));
    }

    static boolean hasAce(String[] hand) {
        for (int i = 0; i <= 4; i++) if (hand[i].charAt(0) == 'A') return true;
        return false;
    }

    static boolean hasFlush(String[] hand) {
        String firstSuite = hand[0].substring(1);
        for (int i = 1; i <= 4; i++) {
            String thisSuite = hand[i].substring(1);
            if (!thisSuite.equals(firstSuite)) return false;
        }
        return true;
    }

    static boolean hasFourOfAKind(String[] hand) {
        for (String cardValue : PlayingCard.CARD_VALUES) {
            if (hasFourOfAKind(hand, cardValue)) return true;
        }
        return false;
    }

    static boolean hasThreeOfAKind(String[] hand) {
        for (String cardValue : PlayingCard.CARD_VALUES) {
            if (hasThreeOfAKind(hand, cardValue)) return true;
        }
        return false;
    }

    static boolean hasThreeOfAKind(String[] hand, String cardValue) {
        return hasRun(hand, cardValue, 3);
    }

    static boolean hasFourOfAKind(String[] hand, String cardValue) {
        return hasRun(hand, cardValue, 4);
    }

    static boolean hasPair(String[] hand) {
        for (String cardValue : PlayingCard.CARD_VALUES) {
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

    static int[] getSortedValues(String[] hand) {
        int[] values = new int[5];
        for (int i = 0; i <= 4; i++) values[i] = PlayingCard.getCardValue(hand[i]);
        Arrays.sort(values);
        return values;
    }
}
