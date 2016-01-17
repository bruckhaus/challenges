import com.sun.deploy.util.StringUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

class PokerScore {

    private static final int POINTS_ROYAL_FLUSH = 700;
    private static final int POINTS_STRAIGHT_FLUSH = 600;
    private static final int POINTS_FOUR_OF_A_KIND = 500;
    private static final int POINTS_FULL_HOUSE = 400;
    private static final int POINTS_FLUSH = 300;
    private static final int POINTS_STRAIGHT = 200;
    private static final int POINTS_THREE_OF_A_KIND = 100;

    static int scoreHands(String handsFile) throws IOException {
        List lines = new ResourceFile(handsFile).getLines();
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
        if (PokerHand.hasRoyalFlush(hand)) return POINTS_ROYAL_FLUSH;
        if (PokerHand.hasStraightFlush(hand)) return POINTS_STRAIGHT_FLUSH;
        if (PokerHand.hasFourOfAKind(hand)) return POINTS_ROYAL_FLUSH;
        if (PokerHand.hasFullHouse(hand)) return POINTS_ROYAL_FLUSH;
        if (PokerHand.hasFlush(hand)) return POINTS_ROYAL_FLUSH;
        if (PokerHand.hasStraight(hand)) return POINTS_ROYAL_FLUSH;
        if (PokerHand.hasThreeOfAKind(hand)) return POINTS_ROYAL_FLUSH;
        if (PokerHand.hasTwoPairs(hand)) return POINTS_ROYAL_FLUSH;
        if (PokerHand.hasRoyalFlush(hand)) return POINTS_ROYAL_FLUSH;
        if (PokerHand.hasRoyalFlush(hand)) return POINTS_ROYAL_FLUSH;
        return PokerScore.scoreHighestCard(hand);
    }

    static int scoreRoyalFlush(String[] hand) {
        return PokerHand.hasRoyalFlush(hand) ? POINTS_ROYAL_FLUSH : 0;
    }

    static int scoreStraightFlush(String[] hand) {
        return PokerHand.hasFlush(hand) && PokerHand.hasStraight(hand) ? POINTS_STRAIGHT_FLUSH : 0;
    }

    static int scoreFourOfAKind(String[] hand) {
        return PokerHand.hasFourOfAKind(hand) ? POINTS_FOUR_OF_A_KIND : 0;
    }

    static int scoreFullHouse(String[] hand) {
        int score = 0;
        if (PokerHand.hasPair(hand) && PokerHand.hasThreeOfAKind(hand)) score += POINTS_FULL_HOUSE;
        return score;
    }

    static int scoreFlush(String[] hand) {
        return PokerHand.hasFlush(hand) ? POINTS_FLUSH : 0;
    }

    static int scoreStraight(String[] hand) {
        return PokerHand.hasStraight(hand) ? POINTS_STRAIGHT : 0;
    }

    static int scoreThreeOfAKind(String[] hand) {
        return PokerHand.hasThreeOfAKind(hand) ? POINTS_THREE_OF_A_KIND : 0;
    }

    static int scorePairs(String[] hand) {
        int score = 0;
        for (String cardValue : PlayingCard.CARD_VALUES) {
            if (PokerHand.hasPair(hand, cardValue)) {
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
        return PlayingCard.getCardValue(card);
    }


}
