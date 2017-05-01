public class P63_PowerfulDigitCounts {

    public static void main(String[] args) {
        String message = "There are %,d n-digit positive integers which are also an nth power.\n";
        int result = findCount();
        System.out.printf(message, result);
    }

    static int findCount() {
        // See: http://www.mathblog.dk/project-euler-63-n-digit-nth-power/
        int result = 0;
        int lower = 0;
        int n = 1;
        while (lower < 10) {
            lower = (int)Math.ceil(Math.pow(10,(n-1.0)/n));
            result += 10 - lower;
            n++;
        }
        return result;
    }
}
