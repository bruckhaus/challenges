import java.util.Arrays;

class PokerScore {
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
    // The cards are valued in the order: 2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen, King, Ace.
    // If two players have the same ranked hands then the rank made up of the highest value wins;
    // for example, a pair of eights beats a pair of fives (see example 1 below).
    // But if two ranks tie, for example, both players have a pair of queens,
    // then highest cards in each hand are compared (see example 4 below);
    // if the highest cards tie then the next highest cards are compared, and so on.

    @SuppressWarnings("FieldCanBeLocal")
    private static boolean PRINT_DEBUG_OUTPUT = false;

    private static final int POINT_INCREMENT = 1000000;
    private static final int POINTS_ONE_PAIR = POINT_INCREMENT;
    private static final int POINTS_TWO_PAIRS = POINTS_ONE_PAIR + POINT_INCREMENT;
    private static final int POINTS_THREE_OF_A_KIND = POINTS_TWO_PAIRS + POINT_INCREMENT;
    private static final int POINTS_STRAIGHT = POINTS_THREE_OF_A_KIND + POINT_INCREMENT;
    private static final int POINTS_FLUSH = POINTS_STRAIGHT + POINT_INCREMENT;
    private static final int POINTS_FULL_HOUSE = POINTS_FLUSH + POINT_INCREMENT;
    private static final int POINTS_FOUR_OF_A_KIND = POINTS_FULL_HOUSE + POINT_INCREMENT;
    private static final int POINTS_STRAIGHT_FLUSH = POINTS_FOUR_OF_A_KIND + POINT_INCREMENT;
    private static final int POINTS_ROYAL_FLUSH = POINTS_STRAIGHT_FLUSH + POINT_INCREMENT;

    // overall hand scoring:

    static int scoreHand(String[] hand) {
        if (PokerHand.hasRoyalFlush(hand)) return scoreRoyalFlush(hand);
        if (PokerHand.hasStraightFlush(hand)) return scoreStraightFlush(hand);
        if (PokerHand.hasFourOfAKind(hand)) return scoreFourOfAKind(hand);
        if (PokerHand.hasFullHouse(hand)) return scoreFullHouse(hand);
        if (PokerHand.hasFlush(hand)) return scoreFlush(hand);
        if (PokerHand.hasStraight(hand)) return scoreStraight(hand);
        if (PokerHand.hasThreeOfAKind(hand)) return scoreThreeOfAKind(hand);
        if (PokerHand.hasTwoPairs(hand)) return scoreTwoPairs(hand);
        if (PokerHand.hasOnePair(hand)) return scoreOnePair(hand);
        return PokerScore.scoreHighestCard(hand);
    }

    // individual hand scores:

    static int scoreRoyalFlush(String[] hand) {
        int points = POINTS_ROYAL_FLUSH;
        debugScore(hand, points, "royal flush");
        return points;
    }

    static int scoreStraightFlush(String[] hand) {
        int points = POINTS_STRAIGHT_FLUSH + getHighCardScore(hand);
        debugScore(hand, points, "straight flush");
        return points;
    }

    static int scoreFourOfAKind(String[] hand) {
        int points = POINTS_FOUR_OF_A_KIND +
                getScoreByCardCount(hand, 4, 10) +
                getScoreByCardCount(hand, 1, 1);
        debugScore(hand, points, "four of a kind");
        return points;
    }

    static int scoreFullHouse(String[] hand) {
        int points = POINTS_FULL_HOUSE +
                getScoreByCardCount(hand, 3, 10) +
                getScoreByCardCount(hand, 2, 1);
        debugScore(hand, points, "full house");
        return points;
    }

    static int scoreFlush(String[] hand) {
        int points = POINTS_FLUSH + getCumulativeSimpleCardScore(hand, 1, 1, 5, 1);
        debugScore(hand, points, "flush");
        return points;
    }

    static int scoreStraight(String[] hand) {
        int points = POINTS_STRAIGHT + getHighCardScore(hand);
        debugScore(hand, points, "straight");
        return points;
    }

    static int scoreThreeOfAKind(String[] hand) {
        int points = POINTS_THREE_OF_A_KIND +
                getScoreByCardCount(hand, 3, 100) +
                getCumulativeSimpleCardScore(hand, 1, 1, 2, 1);
        debugScore(hand, points, "three of a kind");
        return points;
    }

    private static int scoreTwoPairs(String[] hand) {
        int points = POINTS_TWO_PAIRS +
                getCumulativeSimpleCardScore(hand, 2, 1, 2, 10) +
                getScoreByCardCount(hand, 1, 1);
        debugScore(hand, points, "two pairs");
        return points;
    }

    private static int scoreOnePair(String[] hand) {
        int points = POINTS_ONE_PAIR +
                getScoreByCardCount(hand, 2, 10000) +
                getCumulativeSimpleCardScore(hand, 1, 1, 4, 1);
        debugScore(hand, points, "one pair");
        return points;
    }

    static int scoreHighestCard(String[] hand) {
        int points = getCumulativeSimpleCardScore(hand, 1, 1, 5, 1);
        debugScore(hand, points, "highest card");
        return points;
    }

    // helpers:

    private static int getHighCardScore(String[] hand) {
        return getScoreByCardRank(hand, 1, 1);
    }

    private static int getScoreByCardCount(String[] hand, int count, int multiplier) {
        return getCumulativeSimpleCardScore(hand, count, 1, 1, multiplier);
    }

    private static int getCumulativeSimpleCardScore(String[] hand, int count, int start, int end, int multiplier) {
        int score = 0;
        for (int i = end; i >= start; i--) {
            score += getScoreByCardRank(hand, count, i) * multiplier;
            multiplier *= 10;
        }
        return score;
    }

    private static int getScoreByCardRank(String[] hand, int count, int rank) {
        return scoreCard(PokerHand.getOfAKindCard(hand, count, rank));
    }

    static int scoreCard(String card) {
        return PlayingCard.getCardValue(card);
    }

    // debugging:

    private static void debugScore(String[] hand, int points, String message) {
        if (PRINT_DEBUG_OUTPUT) System.out.printf("%s, score = %,d: %s\n", Arrays.toString(hand), points, message);
    }
}
