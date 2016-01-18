import com.sun.deploy.util.StringUtils;
import com.sun.deploy.util.SystemUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static sun.misc.Version.println;

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

    static int scoreHands(String handsFile) throws IOException {
        List lines = new ResourceFile(handsFile).getLines();
        int player1Wins = 0;
        for (Object line : lines) {
            String[] cards = StringUtils.splitString(String.valueOf(line), " ");
            String[] handPlayer1 = Arrays.copyOfRange(cards, 0, 5);
            String[] handPlayer2 = Arrays.copyOfRange(cards, 5, 10);
            System.out.println();
            int scorePlayer1 = scoreHand(handPlayer1);
            int scorePlayer2 = scoreHand(handPlayer2);
            if (scorePlayer1 > scorePlayer2) player1Wins++;

            int scoreDiff = scorePlayer1 - scorePlayer2;
            if (Math.abs(scoreDiff) < 10000) {
                System.out.printf("Close call diff: %,d\n", scoreDiff);
            }
        }
        return player1Wins;
    }

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

    static int scoreRoyalFlush(String[] hand) {
        int points = POINTS_ROYAL_FLUSH;
        debugScore(hand, points, "royal flush");
        return points;
    }

    static int scoreStraightFlush(String[] hand) {
        int points = POINTS_STRAIGHT_FLUSH +
                getHighCardScore(hand);
        debugScore(hand, points, "straight flush");
        return points;
    }

    static int scoreFourOfAKind(String[] hand) {
        int points = POINTS_FOUR_OF_A_KIND +
                scoreCard(PokerHand.getOfAKindCard(hand, 4)) * 10 +
                scoreCard(PokerHand.getOfAKindCard(hand, 1));
        debugScore(hand, points, "four of a kind");
        return points;
    }

    static int scoreFullHouse(String[] hand) {
        int points = POINTS_FULL_HOUSE +
                scoreCard(PokerHand.getOfAKindCard(hand, 3)) * 10 +
                scoreCard(PokerHand.getOfAKindCard(hand, 2));
        debugScore(hand, points, "full house");
        return points;
    }

    static int scoreFlush(String[] hand) {
        int points = POINTS_FLUSH +
                getHighCardScore(hand);
        debugScore(hand, points, "flush");
        return points;
    }

    static int scoreStraight(String[] hand) {
        int points = POINTS_STRAIGHT +
                getHighCardScore(hand);
        debugScore(hand, points, "straight");
        return points;
    }

    private static int getHighCardScore(String[] hand) {
        return getScoreByCardRank(hand, 1, 1);
    }

    static int scoreThreeOfAKind(String[] hand) {
        int points = POINTS_THREE_OF_A_KIND +
                scoreCard(PokerHand.getOfAKindCard(hand, 3)) * 100 +
                getHighCardScore(hand) * 10 +
                getScoreByCardRank(hand, 1, 2);
        debugScore(hand, points, "three of a kind");
        return points;
    }

    private static int scoreTwoPairs(String[] hand) {
        int points = POINTS_TWO_PAIRS +
                getScoreByCardRank(hand, 2, 1) * 100 +
                getScoreByCardRank(hand, 2, 2) * 10 +
                getHighCardScore(hand);
        debugScore(hand, points, "two pairs");
        return points;
    }

    private static int scoreOnePair(String[] hand) {
        int points = POINTS_ONE_PAIR +
                getScoreByCardRank(hand, 2, 1) * 10000 +
                getHighCardScore(hand) * 1000 +
                getScoreByCardRank(hand, 1, 2) * 100 +
                getScoreByCardRank(hand, 1, 3) * 10 +
                getScoreByCardRank(hand, 1, 4);
        debugScore(hand, points, "one pair");
        return points;
    }

    static int scoreHighestCard(String[] hand) {
        int count = 1;
        int rank = 2;
        int points = getHighCardScore(hand) * 10000 +
                getScoreByCardRank(hand, count, rank) * 1000 +
                getScoreByCardRank(hand, 1, 3) * 100 +
                getScoreByCardRank(hand, 1, 4) * 10 +
                getScoreByCardRank(hand, 1, 5);
        debugScore(hand, points, "highest card");
        return points;
    }

    private static int getScoreByCardRank(String[] hand, int count, int rank) {
        return scoreCard(PokerHand.getOfAKindCard(hand, count, rank));
    }

    static int scoreCard(String card) {
        return PlayingCard.getCardValue(card);
    }

    private static void debugScore(String[] hand, int points, String message) {
        System.out.printf("%s, score = %,d: %s\n", Arrays.toString(hand), points, message);
    }
}
