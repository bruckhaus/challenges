public class P40_ChampernownesConstant {

    // Project Euler - Problem 40: Champernowne's constant
    // An irrational decimal fraction is created by concatenating the positive integers, 1, 2, 3, etc.:
    // 0.123456789101112131415161718192021...
    // It can be seen that the 12th digit of the fractional part is 1.
    // If d(n) represents the nth digit of the fractional part, find the value of the following expression.
    // d(1) × d(10) × d(100) × d(1,000) × d(10,000) × d(100,000) × d(1,000,000)

    private static final int MAX_MAGNITUDE = 6;

    public static void main(String[] args) {
        int solution = findSolution(MAX_MAGNITUDE);
        String message = "The value of the solution expression is: %d\n";
        System.out.printf(message, solution);
    }

    static int findSolution(int maxMagnitude) {
        int magnitude = 0;
        int position = (int) Math.pow(10, magnitude);
        int finalPosition = (int) Math.pow(10, maxMagnitude);
        int length = 0;
        int solution = 1;
        for (int i = 1; length < finalPosition; i++) {
            length += String.valueOf(i).length();
            if (length >= position) {
                int stepBack = length - position;
                solution *= getValue(i, stepBack);
                magnitude++;
                position = (int) Math.pow(10, magnitude);
            }
        }
        return solution;
    }

    static int getValue(int i, int stepBack) {
        String s = String.valueOf(i);
        int offset = s.length() - 1 - stepBack;
        return Integer.valueOf(s.substring(offset, offset + 1));
    }
}
