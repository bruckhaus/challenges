import static java.lang.System.out;

public class FizzBuzz {
    public static void main(String args[]) {
        for (int i = 1; i <= 30; i++) {
            if (i % 15 == 0) {
                out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                out.println("Fizz");
            } else if (i % 5 == 0) {
                out.println("Buzz");
            } else {
                out.println(i);
            }
        }
    }
};

