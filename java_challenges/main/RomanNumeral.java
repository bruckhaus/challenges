public class RomanNumeral {

    public static int romanToArabic(String roman) {

        String state = "Start"; // I, V, X, L, C, D, M
        char token;
        Integer arabic = 0;

        System.out.print("Roman: " + roman);

        for (int i = 0; i < roman.length(); i++) {
            token = roman.charAt(i);
            switch (state) {
                case "Start":
                    switch (token) {
                        case 'I':
                            arabic += 1;
                            state = "I";
                            break;
                        case 'V':
                            arabic += 5;
                            state = "V";
                            break;
                        case 'X':
                            arabic += 10;
                            state = "X";
                            break;
                        case 'L':
                            arabic += 50;
                            state = "L";
                            break;
                    }
                    break;
                case "I":
                    switch (token) {
                        case 'I':
                            arabic += 1;
                            state = "I";
                            break;
                        case 'V':
                            arabic += 3;
                            state = "V";
                            break;
                        case 'X':
                            arabic += 8;
                            state = "X";
                            break;
                        case 'L':
                            arabic += 48;
                            state = "L";
                            break;
                    }
                    break;
                case "V":
                    switch (token) {
                        case 'I':
                            arabic += 1;
                            state = "I";
                            break;
                    }
                    break;
                case "X":
                    switch (token) {
                        case 'I':
                            arabic += 1;
                            state = "I";
                            break;
                        case 'V':
                            arabic += 5;
                            state = "V";
                            break;
                        case 'X':
                            arabic += 10;
                            state = "X";
                            break;
                        case 'L':
                            arabic += 30;
                            state = "L";
                            break;
                    }
                    break;
                case "L":
                    switch (token) {
                        case 'I':
                            arabic += 1;
                            state = "I";
                            break;
                        case 'V':
                            arabic += 5;
                            state = "V";
                            break;
                    }
                    break;
            }

        }

        System.out.println(", arabic: " + arabic);

        return arabic;
    }
}