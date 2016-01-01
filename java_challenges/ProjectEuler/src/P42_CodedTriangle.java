import java.io.IOException;

public class P42_CodedTriangle {
    // Project Euler - Coded triangle numbers - Problem 42
    // The nth term of the sequence of triangle numbers is given by, tn = ½n(n+1);
    // so the first ten triangle numbers are:
    // 1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...
    // By converting each letter in a word to a number corresponding to its alphabetical position
    // and adding these values we form a word value.
    // For example, the word value for SKY is 19 + 11 + 25 = 55 = t10.
    // If the word value is a triangle number then we shall call the word a triangle word.
    // Using words.txt (right click and 'Save Link/Target As...'), a 16K text file
    // containing nearly two-thousand common English words, how many are triangle words?

    public static void main(String[] args) throws IOException {
        int count;
        count = getCount();
        System.out.printf(
                "The count of triangle numbers among the provided list of common English words is %d.", count);
    }

    static int getCount() throws IOException {
        Triangular triangular = new Triangular();
        int count = 0;
        for (Object word : Words.words()) {
            int code = Words.wordCode(String.valueOf(word));
            if (triangular.isPolygonal(code)) count++;
        }
        return count;
    }
}
