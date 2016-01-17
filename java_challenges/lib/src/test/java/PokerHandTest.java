import org.junit.Test;

import static org.junit.Assert.*;

public class PokerHandTest {
    @Test
    public void hasRoyalFlush() throws Exception {

    }

    @Test
    public void hasStraightFlush() throws Exception {
        String[] royalFlush = new String[]{"AH", "KH", "QH", "JH", "TH"};
        String[] regularFlush = new String[]{"KH", "QH", "JH", "TH", "9H"};
        assert (PokerHand.hasRoyalFlush(royalFlush));
        assert (!PokerHand.hasRoyalFlush(regularFlush));
    }

    @Test
    public void hasFullHouse() throws Exception {
        String[] fullHouse = new String[]{"KH", "KD", "KC", "9S", "9H"};
        String[] notFullHouse = new String[]{"KH", "KD", "KC", "TS", "9H"};
        assert (PokerHand.hasFullHouse(fullHouse));
        assert (!PokerHand.hasFullHouse(notFullHouse));
    }

    @Test
    public void hasFlush() throws Exception {
        String[] flush = new String[]{"KH", "JH", "9H", "7H", "4H"};
        String[] notFlush = new String[]{"KH", "JH", "9H", "7H", "4D"};
        assert (PokerHand.hasFlush(flush));
        assert (!PokerHand.hasFlush(notFlush));
    }

    @Test
    public void hasStraight() throws Exception {
        String[] straight = new String[]{"KH", "QD", "JH", "TH", "9S"};
        String[] notStraight = new String[]{"KH", "JH", "9H", "7H", "4D"};
        assert (PokerHand.hasStraight(straight));
        assert (!PokerHand.hasStraight(notStraight));
    }

    @Test
    public void hasThreeOfAKind() throws Exception {
        String[] threeOfAKind = new String[]{"KH", "KD", "KC", "2D", "9H"};
        String[] notThreeOfAKind = new String[]{"KH", "KD", "7C", "2D", "9H"};
        assert (PokerHand.hasThreeOfAKind(threeOfAKind));
        assert (!PokerHand.hasThreeOfAKind(notThreeOfAKind));
    }

    @Test
    public void hasTwoPairs() throws Exception {
        String[] twoPairs = new String[]{"KH", "KD", "2C", "2D", "9H"};
        String[] notTwoPairs = new String[]{"KH", "KD", "7C", "2D", "9H"};
        assert (PokerHand.hasTwoPairs(twoPairs));
        assert (!PokerHand.hasTwoPairs(notTwoPairs));
    }

    @Test
    public void hasOnePair() throws Exception {
        String[] noPair = new String[]{"AH", "KD", "9C", "8D", "6H"};
        String[] onePair = new String[]{"KH", "KD", "9C", "8D", "6H"};
        String[] twoPairs = new String[]{"KH", "KD", "9C", "9D", "6H"};
        assert (!PokerHand.hasOnePair(noPair));
        assert (PokerHand.hasOnePair(onePair));
        assert (!PokerHand.hasOnePair(twoPairs));
    }

    // of-a-kind helpers:

    @Test
    public void hasFourOfAKind() throws Exception {
        String[] fourOfAKind = new String[]{"KH", "KD", "KC", "KS", "9H"};
        String[] notFourOfAKind = new String[]{"KH", "KD", "KC", "QS", "9H"};
        assert (PokerHand.hasFourOfAKind(fourOfAKind, "K"));
        assert (!PokerHand.hasFourOfAKind(notFourOfAKind, "K"));
    }

    @Test
    public void hasThreeOfAKind1() throws Exception {
        String[] threeOfAKind = new String[]{"KH", "KD", "KC", "2D", "9H"};
        String[] notThreeOfAKind = new String[]{"KH", "KD", "JC", "2D", "9H"};
        assert (PokerHand.hasThreeOfAKind(threeOfAKind, "K"));
        assert (!PokerHand.hasThreeOfAKind(notThreeOfAKind, "K"));
    }

    @Test
    public void hasPair() throws Exception {
        String[] onePair = new String[]{"KH", "KD", "9C", "8D", "6H"};
        String[] noPair = new String[]{"AH", "KD", "9C", "8D", "6H"};
        assert (PokerHand.hasPair(onePair, "K"));
        assert (!PokerHand.hasPair(noPair, "K"));
    }

    @Test
    public void hasPair1() throws Exception {
        String[] onePair = new String[]{"KH", "KD", "9C", "8D", "6H"};
        String[] noPair = new String[]{"AH", "KD", "9C", "8D", "6H"};
        assert (PokerHand.hasPair(onePair));
        assert (!PokerHand.hasPair(noPair));
    }

    @Test
    public void hasOfAKind() throws Exception {
        String[] fourOfAKind = new String[]{"KH", "KD", "KC", "KS", "9H"};
        String[] threeOfAKind = new String[]{"KH", "KD", "KC", "2D", "9H"};
        String[] twoPairs = new String[]{"KH", "KD", "9C", "9D", "6H"};
        String[] onePair = new String[]{"KH", "KD", "9C", "8D", "6H"};
        String[] noPair = new String[]{"AH", "KD", "9C", "8D", "6H"};
        assert (PokerHand.hasOfAKind(fourOfAKind, "K", 4));
        assert (PokerHand.hasOfAKind(threeOfAKind, "K", 3));
        assert (PokerHand.hasOfAKind(twoPairs, "9", 2));
        assert (PokerHand.hasOfAKind(twoPairs, "K", 2));
        assert (PokerHand.hasOfAKind(onePair, "K", 2));
        assert (PokerHand.hasOfAKind(noPair, "A", 1));
        assert (PokerHand.hasOfAKind(noPair, "2", 0));
    }

    @Test
    public void getCountPairs() throws Exception {
        String[] noPair = new String[]{"AH", "KD", "9C", "8D", "6H"};
        String[] onePair = new String[]{"KH", "KD", "9C", "8D", "6H"};
        String[] twoPairs = new String[]{"KH", "KD", "9C", "9D", "6H"};
        assertEquals(0, PokerHand.getCountPairs(noPair));
        assertEquals(1, PokerHand.getCountPairs(onePair));
        assertEquals(2, PokerHand.getCountPairs(twoPairs));
    }

    // straight helpers:

    @Test
    public void hasStraight1() throws Exception {
        assert (PokerHand.hasStraight(new int[]{10, 11, 12, 13, 14}));
        assert (PokerHand.hasStraight(new int[]{2, 3, 4, 5, 14}));
        assert (PokerHand.hasStraight(new int[]{7, 8, 9, 10, 11}));
        assert (PokerHand.hasStraight(new int[]{2, 3, 4, 5, 6}));
        assert (!PokerHand.hasStraight(new int[]{2, 3, 4, 5, 7}));
    }

    @Test
    public void hasStraightWithHighAce() throws Exception {
        assert (PokerHand.hasStraightWithHighAce(new int[]{10, 11, 12, 13, 14}));
        assert (!PokerHand.hasStraightWithHighAce(new int[]{2, 3, 4, 5, 14}));
    }

    @Test
    public void hasStraightWithLowAce() throws Exception {
        assert (PokerHand.hasStraightWithLowAce(new int[]{2, 3, 4, 5, 14}));
        assert (!PokerHand.hasStraightWithLowAce(new int[]{10, 11, 12, 13, 14}));
    }

    // other helpers:

    @Test
    public void hasAce() throws Exception {
        String[] noAce = new String[]{"KH", "KD", "7C", "2D", "9H"};
        String[] oneAce = new String[]{"AH", "KD", "7C", "2D", "9H"};
        String[] twoAces = new String[]{"AH", "AD", "7C", "2D", "9H"};
        assert (!PokerHand.hasAce(noAce));
        assert (PokerHand.hasAce(oneAce));
        assert (PokerHand.hasAce(twoAces));
    }

    @Test
    public void getSortedValues() throws Exception {
        String[] hand = new String[]{"KH", "KD", "7C", "2D", "9H"};
        int[] values = PokerHand.getSortedValues(hand);
        int[] expectedValues = new int[]{2, 7, 9, 13, 13};
        assertArrayEquals(expectedValues, values);
    }
}
