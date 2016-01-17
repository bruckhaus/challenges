import org.junit.Test;

public class PokerScoreTest {
    @Test
    public void scoreRoyalFlushWin() throws Exception {
        // royal flush > straight flush
        String[] royalFlush = new String[]{"AH", "KH", "QH", "JH", "TH"};
        String[] straightFlush = new String[]{"KH", "QH", "JH", "TH", "9H"};
        int royalFlushScore = PokerScore.scoreHand(royalFlush);
        int straightFlushScore = PokerScore.scoreHand(straightFlush);
        assert (royalFlushScore > straightFlushScore);
    }

    @Test
    public void scoreStraightFlushWin() throws Exception {
        // straight flush > four of a kind
        String[] straightFlush = new String[]{"KH", "QH", "JH", "TH", "9H"};
        String[] fourOfAKind = new String[]{"KH", "KD", "KC", "KS", "9H"};
        int straightFlushScore = PokerScore.scoreHand(straightFlush);
        int fourOfAKindScore = PokerScore.scoreHand(fourOfAKind);
        assert (straightFlushScore > fourOfAKindScore);
    }

    @Test
    public void scoreFourOfAKindWin() throws Exception {
        // four of a kind > full house
        String[] fourOfAKind = new String[]{"KH", "KD", "KC", "KS", "9H"};
        String[] fullHouse = new String[]{"AH", "AD", "QH", "QD", "QC"};
        int fourOfAKindScore = PokerScore.scoreHand(fourOfAKind);
        int fullHouseScore = PokerScore.scoreHand(fullHouse);
        assert (fourOfAKindScore > fullHouseScore);
    }

    @Test
    public void scoreFullHouseWin() throws Exception {
        // full house > flush
        String[] fullHouse = new String[]{"AH", "AD", "QH", "QD", "QC"};
        String[] flush = new String[]{"KH", "JH", "9H", "7H", "5H"};
        int fullHouseScore = PokerScore.scoreHand(fullHouse);
        int flushScore = PokerScore.scoreHand(flush);
        assert (fullHouseScore > flushScore);
    }

    @Test
    public void scoreFlushWin() throws Exception {
        // flush > straight
        String[] flush = new String[]{"KH", "JH", "9H", "7H", "5H"};
        String[] straight = new String[]{"AH", "KD", "JH", "TD", "9C"};
        int flushScore = PokerScore.scoreHand(flush);
        int straightScore = PokerScore.scoreHand(straight);
        assert (flushScore > straightScore);
    }

    @Test
    public void scoreStraightWin() throws Exception {
        // straight > three of a kind
        String[] straight = new String[]{"AH", "KD", "QH", "JD", "TC"};
        String[] threeOfAKind = new String[]{"KH", "KD", "KC", "7H", "5H"};
        int straightScore = PokerScore.scoreHand(straight);
        int threeOfAKIndScore = PokerScore.scoreHand(threeOfAKind);
        assert (straightScore > threeOfAKIndScore);
    }

    @Test
    public void scoreThreeOfAKindWin() throws Exception {
        // three of a kind > two pairs
        String[] threeOfAKind = new String[]{"KH", "KD", "KC", "2D", "9H"};
        String[] twoPairs = new String[]{"AH", "AD", "QH", "QD", "2C"};
        int threeOfAKindScore = PokerScore.scoreHand(threeOfAKind);
        int twoPairsScore = PokerScore.scoreHand(twoPairs);
        assert (threeOfAKindScore > twoPairsScore);
    }

    @Test
    public void scoreTwoPairsWin() throws Exception {
        // two pairs > one pair
        String[] twoPairs = new String[]{"9H", "9D", "QH", "QD", "2C"};
        String[] onePair = new String[]{"KH", "KD", "7C", "2D", "9H"};
        int twoPairsScore = PokerScore.scoreHand(twoPairs);
        int onePairScore = PokerScore.scoreHand(onePair);
        assert (twoPairsScore > onePairScore);
    }

    @Test
    public void scoreOnePairWin() throws Exception {
        // one pair > high card
        String[] onePair = new String[]{"KH", "KD", "7C", "2D", "9H"};
        String[] highCard = new String[]{"AH", "9D", "7H", "5D", "2C"};
        int onePairScore = PokerScore.scoreHand(onePair);
        int highCardScore = PokerScore.scoreHand(highCard);
        assert (onePairScore > highCardScore);
    }

    @Test
    public void scoreHighCardWin() throws Exception {
        // higher card > high card
        String[] higherCard = new String[]{"AH", "9D", "7H", "5D", "2C"};
        String[] highCard = new String[]{"KH", "JD", "9C", "7D", "5H"};
        int higherCardScore = PokerScore.scoreHand(higherCard);
        int highCardScore = PokerScore.scoreHand(highCard);
        assert (higherCardScore > highCardScore);
    }

    @Test
    public void scoreRoyalFlush() throws Exception {
        String[] royalFlush = new String[]{"AH", "KH", "QH", "JH", "TH"};
        int royalFlushScore = PokerScore.scoreRoyalFlush(royalFlush);
        assert (royalFlushScore > 0);
    }

    @Test
    public void scoreStraightFlush() throws Exception {
        String[] straightFlush = new String[]{"KH", "QH", "JH", "TH", "9H"};
        int straightFlushScore = PokerScore.scoreStraightFlush(straightFlush);
        assert (straightFlushScore > 0);
    }

    @Test
    public void scoreFullHouse() throws Exception {
        String[] fullHouse = new String[]{"AH", "AD", "QH", "QD", "QC"};
        int fullHouseScore = PokerScore.scoreFullHouse(fullHouse);
        assert (fullHouseScore > 0);
    }

    @Test
    public void scoreFlush() throws Exception {
        String[] flush = new String[]{"KH", "JH", "9H", "7H", "5H"};
        int flushScore = PokerScore.scoreFlush(flush);
        assert (flushScore > 0);
    }

    @Test
    public void scoreStraight() throws Exception {
        // straight without ace
        String[] straight = new String[]{"JH", "TD", "9C", "8D", "7S"};
        int straightScore = PokerScore.scoreStraight(straight);
        assert (straightScore > 0);

        // straight with high ace
        straight = new String[]{"AH", "KD", "QH", "JD", "TC"};
        straightScore = PokerScore.scoreStraight(straight);
        assert (straightScore > 0);

        // straight with low ace
        straight = new String[]{"5H", "4D", "3H", "2D", "AC"};
        straightScore = PokerScore.scoreStraight(straight);
        assert (straightScore > 0);
    }

    @Test
    public void scoreFourOfAKind() throws Exception {
        String[] fourOfAKind = new String[]{"KC", "KS", "KH", "KD", "9H"};
        int fourOfAKindScore = PokerScore.scoreFourOfAKind(fourOfAKind);
        assert (fourOfAKindScore > 0);
    }

    @Test
    public void scoreThreeOfAKind() throws Exception {
        String[] threeOfAKind = new String[]{"KH", "KD", "KC", "2D", "9H"};
        int threeOfAKindScore = PokerScore.scoreThreeOfAKind(threeOfAKind);
        assert (threeOfAKindScore > 0);
    }

    @Test
    public void scorePairs() throws Exception {
        String[] onePair = new String[]{"KH", "KD", "7C", "2D", "9H"};
        int onePairScore = PokerScore.scorePairs(onePair);
        assert (onePairScore > 0);
    }

    @Test
    public void scoreHighestCard() throws Exception {
        String[] hand = new String[]{"KH", "JD", "7C", "5D", "3H"};
        int score = PokerScore.scoreHighestCard(hand);
        assert (score > 0);
    }

    @Test
    public void scoreHandTest() throws Exception {
        String[] hand = new String[]{"5H", "5C", "6S", "7S", "KD"};
        int score = PokerScore.scoreHand(hand);
        assert (score > 0);
    }

    @Test
    public void scoreCard() throws Exception {
        int score = PokerScore.scoreCard("9D");
        assert (score > 0);
    }

}