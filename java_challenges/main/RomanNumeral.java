public class RomanNumeral {

    private static final char[] NUMERALS = {'M', 'D', 'C', 'L', 'X', 'V', 'I'};
    private static final String[][] STYLE_RULES = new String[][]{
         // {"poor style", "good style"}
            {"IIII", "IV"},
            {"XXXX", "XL"},
            {"CCCC", "CD"},
            {"VIV", "IX"},
            {"LXL", "XC"},
            {"CDC", "CM"},
            {"XXXIX", "IXL"},
            {"CCCXC", "XCD"}};
    private String roman = "";
    private int arabic = 0;

    public String arabicToRoman(int i) {
        roman = "";
        arabic = i;
        for (char numeral : NUMERALS) applyNumeral(numeral);
        for (String[] rule : STYLE_RULES) applyRule(rule);
        return roman;
    }

    private void applyRule(String[] rule) {
        roman = roman.replace(rule[0], rule[1]);
    }

    private void applyNumeral(char n) {
        while (arabic >= numeralValue(n)) {
            roman += n;
            arabic -= numeralValue(n);
        }
    }

    public int romanToArabic(String roman) {
        arabic = 0;
        char token;
        int tokenValue;
        int lastTokenValue = 0;

        for (int i = 0; i < roman.length(); i++) {
            token = roman.charAt(i);
            tokenValue = numeralValue(token);
            arabic += tokenValue;
            if (tokenValue > lastTokenValue) arabic -= 2 * lastTokenValue;
            lastTokenValue = tokenValue;
        }
        return arabic;
    }

    private static int numeralValue(char token) {
        int value = 0;
        if (token == 'I') value = 1;
        else if (token == 'V') value = 5;
        else if (token == 'X') value = 10;
        else if (token == 'L') value = 50;
        else if (token == 'C') value = 100;
        else if (token == 'D') value = 500;
        else if (token == 'M') value = 1000;
        return value;
    }
}