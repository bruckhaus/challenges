class PlayingCard {

    static final String[] CARD_VALUES = new String[]
            {"A", "K", "Q", "J", "T", "9", "8", "7", "6", "5", "4", "3", "2"};

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
