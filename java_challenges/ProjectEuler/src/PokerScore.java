import com.sun.deploy.util.StringUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class PokerScore {

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
        score += scoreFourOfAKind(hand);
        score += scoreStraightFlush(hand);
        score += scoreRoyalFlush(hand);
        return score;
    }

    static int scoreRoyalFlush(String[] hand) {
        return PokerHand.hasRoyalFlush(hand) ? 500 : 0;
    }

    static int scoreStraightFlush(String[] hand) {
        return PokerHand.hasFlush(hand) && PokerHand.hasStraight(hand) ? 300 : 0;
    }

    static int scoreFourOfAKind(String[] hand) {
        return PokerHand.hasFourOfAKind(hand) ? 250 : 0;
    }

    static int scoreFullHouse(String[] hand) {
        int score = 0;
        if (PokerHand.hasPair(hand) && PokerHand.hasThreeOfAKind(hand)) score += 60;
        return score;
    }

    static int scoreFlush(String[] hand) {
        return PokerHand.hasFlush(hand) ? 50 : 0;
    }

    static int scoreStraight(String[] hand) {
        return PokerHand.hasStraight(hand) ? 150 : 0;
    }

    static int scoreThreeOfAKind(String[] hand) {
        return PokerHand.hasThreeOfAKind(hand) ? 80 : 0;
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
