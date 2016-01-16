import org.junit.Test;

import static org.junit.Assert.*;

public class P54_PokerHandsTest {

    @Test
    public void scoreRoyalFlushWin() throws Exception {
        // royal flush > straight flush
        String[] royalFlush = new String[]{"AH", "KH", "QH", "JH", "TH"};
        String[] straightFlush = new String[]{"KH", "QH", "JH", "TH", "9H"};
        int royalFlushScore = P54_PokerHands.scoreHand(royalFlush);
        int straightFlushScore = P54_PokerHands.scoreHand(straightFlush);
        assert (royalFlushScore > straightFlushScore);
    }

    @Test
    public void scoreStraightFlushWin() throws Exception {
        // straight flush > four of a kind
        String[] straightFlush = new String[]{"KH", "QH", "JH", "TH", "9H"};
        String[] fourOfAKind = new String[]{"KH", "KD", "KC", "KS", "9H"};
        int straightFlushScore = P54_PokerHands.scoreHand(straightFlush);
        int fourOfAKindScore = P54_PokerHands.scoreHand(fourOfAKind);
        assert (straightFlushScore > fourOfAKindScore);
    }

    @Test
    public void scoreFourOfAKindWin() throws Exception {
        // four of a kind > full house
        String[] fourOfAKind = new String[]{"KH", "KD", "KC", "KS", "9H"};
        String[] fullHouse = new String[]{"AH", "AD", "QH", "QD", "QC"};
        int fourOfAKindScore = P54_PokerHands.scoreHand(fourOfAKind);
        int fullHouseScore = P54_PokerHands.scoreHand(fullHouse);
        assert (fourOfAKindScore > fullHouseScore);
    }

    @Test
    public void scoreFullHouseWin() throws Exception {
        // full house > flush
        String[] fullHouse = new String[]{"AH", "AD", "QH", "QD", "QC"};
        String[] flush = new String[]{"KH", "JH", "9H", "7H", "5H"};
        int fullHouseScore = P54_PokerHands.scoreHand(fullHouse);
        int flushScore = P54_PokerHands.scoreHand(flush);
        assert (fullHouseScore > flushScore);
    }

    @Test
    public void scoreFlushWin() throws Exception {
        // flush > straight
        String[] flush = new String[]{"KH", "JH", "9H", "7H", "5H"};
        String[] straight = new String[]{"AH", "KD", "JH", "TD", "9C"};
        int flushScore = P54_PokerHands.scoreHand(flush);
        int straightScore = P54_PokerHands.scoreHand(straight);
        assert (flushScore > straightScore);
    }

    @Test
    public void scoreStraightWin() throws Exception {
        // straight > three of a kind
        String[] straight = new String[]{"AH", "KD", "JH", "TD", "9C"};
        String[] threeOfAKind = new String[]{"KH", "KD", "KC", "7H", "5H"};
        int straightScore = P54_PokerHands.scoreHand(straight);
        int threeOfAKIndScore = P54_PokerHands.scoreHand(threeOfAKind);
        assert (straightScore > threeOfAKIndScore);
    }

    @Test
    public void scoreThreeOfAKindWin() throws Exception {
        // three of a kind > two pairs
        String[] threeOfAKind = new String[]{"KH", "KD", "KC", "2D", "9H"};
        String[] twoPairs = new String[]{"AH", "AD", "QH", "QD", "2C"};
        int threeOfAKindScore = P54_PokerHands.scoreHand(threeOfAKind);
        int twoPairsScore = P54_PokerHands.scoreHand(twoPairs);
        assert (threeOfAKindScore > twoPairsScore);
    }

    @Test
    public void scoreTwoPairsWin() throws Exception {
        // two pairs > one pair
        String[] twoPairs = new String[]{"9H", "9D", "QH", "QD", "2C"};
        String[] onePair = new String[]{"KH", "KD", "7C", "2D", "9H"};
        int twoPairsScore = P54_PokerHands.scoreHand(twoPairs);
        int onePairScore = P54_PokerHands.scoreHand(onePair);
        assert (twoPairsScore > onePairScore);
    }

    @Test
    public void scoreOnePairWin() throws Exception {
        // one pair > high card
        String[] onePair = new String[]{"KH", "KD", "7C", "2D", "9H"};
        String[] highCard = new String[]{"AH", "9D", "7H", "5D", "2C"};
        int onePairScore = P54_PokerHands.scoreHand(onePair);
        int highCardScore = P54_PokerHands.scoreHand(highCard);
        assert (onePairScore > highCardScore);
    }

    @Test
    public void scoreHighCardWin() throws Exception {
        // higher card > high card
        String[] higherCard = new String[]{"AH", "9D", "7H", "5D", "2C"};
        String[] highCard = new String[]{"KH", "JD", "9C", "7D", "5H"};
        int higherCardScore = P54_PokerHands.scoreHand(higherCard);
        int highCardScore = P54_PokerHands.scoreHand(highCard);
        assert (higherCardScore > highCardScore);
    }

    @Test
    public void scoreRoyalFlush() throws Exception {
        String[] royalFlush = new String[]{"AH", "KH", "QH", "JH", "TH"};
        int royalFlushScore = P54_PokerHands.scoreRoyalFlush(royalFlush);
        assert (royalFlushScore > 0);
    }

    @Test
    public void scoreStraightFlush() throws Exception {
        String[] straightFlush = new String[]{"KH", "QH", "JH", "TH", "9H"};
        int straightFlushScore = P54_PokerHands.scoreStraightFlush(straightFlush);
        assert (straightFlushScore > 0);
    }

    @Test
    public void scoreFullHouse() throws Exception {
        String[] fullHouse = new String[]{"AH", "AD", "QH", "QD", "QC"};
        int fullHouseScore = P54_PokerHands.scoreFullHouse(fullHouse);
        assert (fullHouseScore > 0);
    }

    @Test
    public void scoreFlush() throws Exception {
        String[] flush = new String[]{"KH", "JH", "9H", "7H", "5H"};
        int flushScore = P54_PokerHands.scoreFlush(flush);
        assert (flushScore > 0);
    }

    @Test
    public void scoreStraight() throws Exception {
        String[] straight = new String[]{"AH", "KD", "JH", "TD", "9C"};
        int straightScore = P54_PokerHands.scoreStraight(straight);
        assert (straightScore > 0);
    }

    @Test
    public void scoreThreeOfAKind() throws Exception {
        String[] threeOfAKind = new String[]{"KH", "KD", "KC", "2D", "9H"};
        int threeOfAKindScore = P54_PokerHands.scoreThreeOfAKind(threeOfAKind);
        assert (threeOfAKindScore > 0);
    }

    @Test
    public void scorePairs() throws Exception {
        String[] onePair = new String[]{"KH", "KD", "7C", "2D", "9H"};
        int onePairScore = P54_PokerHands.scorePairs(onePair);
        assert (onePairScore > 0);
    }

    @Test
    public void scoreHighestCard() throws Exception {
        String[] hand = new String[]{"KH", "JD", "7C", "5D", "3H"};
        int score = P54_PokerHands.scoreHighestCard(hand);
        assert (score > 0);
    }

    @Test
    public void scoreHands() throws Exception {
        assertEquals(401, P54_PokerHands.scoreHands());
    }

    @Test
    public void scoreHandTest() throws Exception {
        String[] hand = new String[]{"5H", "5C", "6S", "7S", "KD"};
        int score = P54_PokerHands.scoreHand(hand);
        assert (score > 0);
    }

    @Test
    public void hasFlush() throws Exception {
        String[] flush = new String[]{"KH", "JH", "9H", "7H", "4H"};
        String[] notFlush = new String[]{"KH", "JH", "9H", "7H", "4D"};
        assert (P54_PokerHands.hasFlush(flush));
        assert (!P54_PokerHands.hasFlush(notFlush));
    }

    @Test
    public void hasThreeOfAKind() throws Exception {
        String[] threeOfAKind = new String[]{"KH", "KD", "KC", "2D", "9H"};
        assert (P54_PokerHands.hasThreeOfAKind(threeOfAKind));
    }

    @Test
    public void hasThreeOfAKind1() throws Exception {
        String[] threeOfAKind = new String[]{"KH", "KD", "KC", "2D", "9H"};
        assert (P54_PokerHands.hasThreeOfAKind(threeOfAKind, "K"));
        assert (P54_PokerHands.hasThreeOfAKind(threeOfAKind));
    }

    @Test
    public void hasPair() throws Exception {
        String[] onePair = new String[]{"KH", "KD", "9C", "8D", "6H"};
        assert (P54_PokerHands.hasPair(onePair, "K"));
        assert (P54_PokerHands.hasPair(onePair));
    }

    @Test
    public void hasRun() throws Exception {
        String[] onePair = new String[]{"KH", "KD", "7C", "2D", "9H"};
        assert (P54_PokerHands.hasRun(onePair, "K", 2));
    }

    @Test
    public void scoreCard() throws Exception {
        int score = P54_PokerHands.scoreCard("9D");
        assert (score > 0);
    }

    @Test
    public void getSortedValues() throws Exception {
        String[] hand = new String[]{"KH", "KD", "7C", "2D", "9H"};
        int[] values = P54_PokerHands.getSortedValues(hand);
        int[] expectedValues = new int[] {2, 7, 9, 13, 13};
        assert (expectedValues == values);

    }
}