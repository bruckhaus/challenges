import java.util.Stack;

public class Euler_40_ChampernownesConstant {
    //    Project Euler - Problem 40: Champernowne's constant
    //    An irrational decimal fraction is created by concatenating the positive integers:
    //    0.123456789101112131415161718192021...
    //    It can be seen that the 12th digit of the fractional part is 1.
    //    If dn represents the nth digit of the fractional part, find the value of the following expression.
    //    d1 × d10 × d100 × d1000 × d10000 × d100000 × d1000000

    private static final int MAX_EXPONENT = 6;

    private static boolean isInteractive = false;

    private static int solution = 1;
    private static int totalLength = 0;
    private static int nextNumber = 1;
    private static Stack<Integer> positions = new Stack<>();
    private static int position;

    public static void main(String[] args) {
        isInteractive = true;
        findSolution();
        System.out.printf("The value of the solution expression is: %d\n", solution);
    }

    private static int findSolution() {
        initializePositions();
        while (!positions.empty()) {
            totalLength += (nextNumber + "").length();
            if (totalLength >= position) {
                updateSolution();
            }
            nextNumber++;
        }
        return solution;
    }

    private static void updateSolution() {
        printStringInfo();
        int value = getValueAtPosition();
        solution *= value;
        getNextPosition();
    }

    private static int getValueAtPosition() {
        String numberString = nextNumber + "";
        int last = numberString.length() - 1;
        int stepBack = totalLength - position;
        String digit = numberString.charAt(last - stepBack) + "";
        int value = Integer.parseInt(digit);
        printValueInfo(stepBack, digit, value);
        return value;
    }

    private static void getNextPosition() {
        positions.pop();
        if (!positions.empty()) {
            position = positions.peek();
        }
    }

    private static void initializePositions() {
        for (int exponent = MAX_EXPONENT; exponent >= 0; exponent--) {
            positions.push((int) Math.pow(10, exponent));
        }
        position = positions.peek();
    }

    private static void printStringInfo() {
        if (!isInteractive) return;
        System.out.printf(
                "position: %d, number string: %s, length: %d, total length: %d\n",
                position, nextNumber + "", (nextNumber + "").length(), totalLength);
    }

    private static void printValueInfo(int stepBack, String digit, int value) {
        if (isInteractive) {
            System.out.printf("step back: %d, digit: %s, value: %d\n", stepBack, digit, value);
        }
    }

}
