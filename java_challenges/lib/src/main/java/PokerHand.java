import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

class PokerHand {
    //   - Royal Flush: Ten, Jack, Queen, King, Ace, in same suit.
    //   - Straight Flush: All cards are consecutive values of same suit.
    //   - Four of a Kind: Four cards of the same value.
    //   - Full House: Three of a kind and a pair.
    //   - Flush: All cards of the same suit.
    //   - Straight: All cards are consecutive values.
    //   - Three of a Kind: Three cards of the same value.
    //   - Two Pairs: Two different pairs.
    //   - One Pair: Two cards of the same value.
    //   - High Card: Highest value card.

    // special hand scores:

    static boolean hasRoyalFlush(String[] hand) {
        return hasStraight(hand) && hasFlush(hand) && hasAce(hand);
    }

    static boolean hasStraightFlush(String[] hand) {
        return hasStraight(hand) && hasFlush(hand);
    }

    static boolean hasFourOfAKind(String[] hand) {
        for (String cardValue : PlayingCard.CARD_VALUES) {
            if (hasFourOfAKind(hand, cardValue)) return true;
        }
        return false;
    }

    static boolean hasFullHouse(String[] hand) {
        return hasThreeOfAKind(hand) && hasPair(hand);
    }

    static boolean hasFlush(String[] hand) {
        String firstSuite = hand[0].substring(1);
        for (int i = 1; i <= 4; i++) {
            String thisSuite = hand[i].substring(1);
            if (!thisSuite.equals(firstSuite)) return false;
        }
        return true;
    }

    static boolean hasStraight(String[] hand) {
        return hasStraight(getSortedValues(hand));
    }

    static boolean hasThreeOfAKind(String[] hand) {
        for (String cardValue : PlayingCard.CARD_VALUES) {
            if (hasThreeOfAKind(hand, cardValue)) return true;
        }
        return false;
    }

    static boolean hasTwoPairs(String[] hand) {
        return getCountPairs(hand) == 2;
    }

    static boolean hasOnePair(String[] hand) {
        return getCountPairs(hand) == 1;
    }

    // of-a-kind helpers:

    static boolean hasFourOfAKind(String[] hand, String cardValue) {
        return hasOfAKind(hand, cardValue, 4);
    }

    static boolean hasThreeOfAKind(String[] hand, String cardValue) {
        return hasOfAKind(hand, cardValue, 3);
    }

    static boolean hasPair(String[] hand) {
        return getCountPairs(hand) > 0;
    }

    static boolean hasPair(String[] hand, String cardValue) {
        return hasOfAKind(hand, cardValue, 2);
    }

    static boolean hasOfAKind(String[] hand, String cardValue, int count) {
        String handString = StringUtils.join(hand, ",");
        int matches = StringUtils.countMatches(handString, cardValue);
        return matches == count;
    }

    static int getCountPairs(String[] hand) {
        int countPairs = 0;
        for (String cardValue : PlayingCard.CARD_VALUES) {
            if (hasPair(hand, cardValue)) countPairs++;
        }
        return countPairs;
    }

    static String getOfAKindCard(String[] hand, int count) {
        for (String cardValue : PlayingCard.CARD_VALUES) {
            if (hasOfAKind(hand, cardValue, count)) return cardValue;
        }
        return "?";
    }

    static String getOfAKindCard(String[] hand, int count, int n) {
        // get n-th highest card having count in hand
        int seen = 0;
        for (String cardValue : PlayingCard.CARD_VALUES) {
            if (hasOfAKind(hand, cardValue, count)) {
                seen++;
                if (seen == n) return cardValue;
            }
        }
        return "?";
    }

    // straight helpers:

    static boolean hasStraight(int[] sortedValues) {
        return hasStraightWithHighAce(sortedValues) ||
                hasStraightWithLowAce(sortedValues);
    }

    static boolean hasStraightWithHighAce(int[] SortedValues) {
        for (int i = 1; i <= 4; i++) if (SortedValues[i] != SortedValues[i - 1] + 1) return false;
        return true;
    }

    static boolean hasStraightWithLowAce(int[] sortedValues) {
        for (int i = 0; i <= 3; i++) if (sortedValues[i] != i + 2) return false;
        return sortedValues[4] == PlayingCard.ACE;
    }

    // other helpers:

    static boolean hasAce(String[] hand) {
        for (int i = 0; i <= 4; i++) {
            if (PlayingCard.getCardValue(hand[i]) == PlayingCard.ACE) return true;
        }
        return false;
    }

    static int[] getSortedValues(String[] hand) {
        int[] values = new int[5];
        for (int i = 0; i <= 4; i++) values[i] = PlayingCard.getCardValue(hand[i]);
        Arrays.sort(values);
        return values;
    }
}
