public class RomanNumeral {

    private String roman = "";
    private int arabic = 0;

    public String arabicToRoman(int i) {
        roman = "";
        arabic = i;
        while (arabic >= 1000) add('M');
        while (arabic >= 500) add('D');
        while (arabic >= 100) add('C');
        while (arabic >= 50) add('L');
        while (arabic >= 10) add('X');
        while (arabic >= 5) add('V');
        while (arabic >= 1) add('I');
        roman = roman.replace("IIII", "IV");
        roman = roman.replace("XXXX", "XL");
        roman = roman.replace("CCCC", "CD");
        roman = roman.replace("VIV", "IX");
        roman = roman.replace("LXL", "XC");
        roman = roman.replace("CDC", "CM");
        roman = roman.replace("XXXIX", "IXL");
        roman = roman.replace("CCCXC", "XCD");
        return roman;
    }

    private void add(char m) {
        roman += m;
        arabic -= value(m);
    }

    public static int romanToArabic(String roman) {
        char token;
        int tokenValue = 0;
        int lastTokenValue = 0;
        int result = 0;

        for (int i = 0; i < roman.length(); i++) {
            token = roman.charAt(i);
            tokenValue = value(token);
            result += tokenValue;
            if (tokenValue > lastTokenValue) result -= 2 * lastTokenValue;
            lastTokenValue = tokenValue;
        }
//        System.out.println("Roman: " + roman + ", arabic: " + result);
        return result;
    }

    private static int value(char token) {
        int value = 0;
        switch (token) {
            case 'I':
                value = 1;
                break;
            case 'V':
                value = 5;
                break;
            case 'X':
                value = 10;
                break;
            case 'L':
                value = 50;
                break;
            case 'C':
                value = 100;
                break;
            case 'D':
                value = 500;
                break;
            case 'M':
                value = 1000;
                break;
        }
        return value;
    }
}