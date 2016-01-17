import org.junit.Test;

import static org.junit.Assert.*;

public class PokerHandTest {
    @Test
    public void isStraight() throws Exception {
        int[] sortedValues = new int[]{7, 8, 9, 10, 11};
        assert (PokerHand.hasStraight(sortedValues));
    }

    @Test
    public void isStraightWithHighAce() throws Exception {
        int[] sortedValues = new int[]{10, 11, 12, 13, 14};
        assert (PokerHand.hasStraightWithHighAce(sortedValues));
        assert (!PokerHand.hasStraightWithLowAce(sortedValues));
    }

    @Test
    public void isStraightWithLowAce() throws Exception {
        int[] sortedValues = new int[]{2, 3, 4, 5, 14};
        assert (!PokerHand.hasStraightWithHighAce(sortedValues));
        assert (PokerHand.hasStraightWithLowAce(sortedValues));
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
        assert (PokerHand.hasThreeOfAKind(threeOfAKind));
    }

    @Test
    public void hasThreeOfAKind1() throws Exception {
        String[] threeOfAKind = new String[]{"KH", "KD", "KC", "2D", "9H"};
        assert (PokerHand.hasThreeOfAKind(threeOfAKind, "K"));
        assert (PokerHand.hasThreeOfAKind(threeOfAKind));
    }

    @Test
    public void hasFourOfAKind1() throws Exception {
        String[] fourOfAKind = new String[]{"KC", "KS", "KH", "KD", "9H"};
        assert (PokerHand.hasFourOfAKind(fourOfAKind, "K"));
        assert (PokerHand.hasFourOfAKind(fourOfAKind));
    }

    @Test
    public void hasPair() throws Exception {
        String[] onePair = new String[]{"KH", "KD", "9C", "8D", "6H"};
        assert (PokerHand.hasPair(onePair, "K"));
        assert (PokerHand.hasPair(onePair));
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

    @Test
    public void hasRun() throws Exception {
        String[] onePair = new String[]{"KH", "KD", "7C", "2D", "9H"};
        assert (PokerHand.hasOfAKind(onePair, "K", 2));
    }

    @Test
    public void getSortedValues() throws Exception {
        String[] hand = new String[]{"KH", "KD", "7C", "2D", "9H"};
        int[] values = PokerHand.getSortedValues(hand);
        int[] expectedValues = new int[]{2, 7, 9, 13, 13};
        assertArrayEquals(expectedValues, values);
    }

    @Test
    public void hasAce() throws Exception {
        String[] noAce = new String[]{"KH", "KD", "7C", "2D", "9H"};
        String[] oneAce = new String[]{"AH", "KD", "7C", "2D", "9H"};
        String[] twoAces = new String[]{"AH", "AD", "7C", "2D", "9H"};
        assert (!PokerHand.hasAce(noAce));
        assert (PokerHand.hasAce(oneAce));
        assert (PokerHand.hasAce(twoAces));
    }
}