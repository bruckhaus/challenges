import java.util.HashMap;
import java.util.Map;

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
    private static final Map<String, Integer> numeralValues = new HashMap<>();
    private String roman = "";
    private int arabic = 0;

    public RomanNumeral() {
        numeralValues.put("I", 1);
        numeralValues.put("V", 5);
        numeralValues.put("X", 10);
        numeralValues.put("L", 50);
        numeralValues.put("C", 100);
        numeralValues.put("D", 500);
        numeralValues.put("M", 1000);
    }

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

    private Integer numeralValue(char token) {
        return numeralValues.get(String.valueOf(token));
    }
}