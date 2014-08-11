public class RomanNumeral {

    public static int romanToArabic(String roman) {
        char token;
        int tokenValue = 0;
        int lastTokenValue = 0;
        int result = 0;

        System.out.print("Roman: " + roman);
        for (int i = 0; i < roman.length(); i++) {
            token = roman.charAt(i);
            tokenValue = value(token);
            result += tokenValue;
            if (tokenValue > lastTokenValue) result -= 2 * lastTokenValue;
            lastTokenValue = tokenValue;
        }
        System.out.println(", arabic: " + result);
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