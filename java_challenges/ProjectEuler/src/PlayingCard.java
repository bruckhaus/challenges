class PlayingCard {

    static final String[] CARD_VALUES = new String[]
            {"2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K", "A"};

    static int getCardValue(String card) {
        return getCharValue(getValueChar(card));
    }

    static char getValueChar(String card) {
        return card.charAt(0);
    }

    static int getCharValue(char charValue) {
        switch (charValue) {
            case 'A':
                return 14;
            case 'K':
                return 13;
            case 'Q':
                return 12;
            case 'J':
                return 11;
            case 'T':
                return 10;
            default:
                return Character.getNumericValue(charValue);
        }
    }
}
