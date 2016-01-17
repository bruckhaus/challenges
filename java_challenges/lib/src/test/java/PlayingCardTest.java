import org.junit.Test;

import static org.junit.Assert.*;

public class PlayingCardTest {

    @Test
    public void getValueChar() throws Exception {
        assertEquals('2', PlayingCard.getValueChar("2H"));
    }

    @Test
    public void getCharValue() throws Exception {
        assertEquals(2, PlayingCard.getCharValue('2'));
        assertEquals(3, PlayingCard.getCharValue('3'));
        assertEquals(4, PlayingCard.getCharValue('4'));
        assertEquals(5, PlayingCard.getCharValue('5'));
        assertEquals(6, PlayingCard.getCharValue('6'));
        assertEquals(7, PlayingCard.getCharValue('7'));
        assertEquals(8, PlayingCard.getCharValue('8'));
        assertEquals(9, PlayingCard.getCharValue('9'));
        assertEquals(10, PlayingCard.getCharValue('T'));
        assertEquals(11, PlayingCard.getCharValue('J'));
        assertEquals(12, PlayingCard.getCharValue('Q'));
        assertEquals(13, PlayingCard.getCharValue('K'));
        assertEquals(14, PlayingCard.getCharValue('A'));
    }

    @Test
    public void getCardValue() throws Exception {
        assertEquals(2, PlayingCard.getCardValue("2C"));
        assertEquals(3, PlayingCard.getCardValue("3S"));
        assertEquals(4, PlayingCard.getCardValue("4H"));
        assertEquals(5, PlayingCard.getCardValue("5D"));
        assertEquals(6, PlayingCard.getCardValue("6C"));
        assertEquals(7, PlayingCard.getCardValue("7S"));
        assertEquals(8, PlayingCard.getCardValue("8H"));
        assertEquals(9, PlayingCard.getCardValue("9D"));
        assertEquals(10, PlayingCard.getCardValue("TC"));
        assertEquals(11, PlayingCard.getCardValue("JS"));
        assertEquals(12, PlayingCard.getCardValue("QH"));
        assertEquals(13, PlayingCard.getCardValue("KD"));
        assertEquals(14, PlayingCard.getCardValue("AC"));
    }
}
