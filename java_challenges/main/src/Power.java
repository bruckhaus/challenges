public class Power {
    public double power(int base, int exponent) {
        double result = 1.0;
        for (int i = 1; i <= exponent; i++) {
            result = Power.multiply(result, base);
        }
        return result;
    }

    private static double multiply(double factor_1, int factor_2) {
        double result = 0.0;
        for (int i = 1; i <= factor_2; i++) {
            result += factor_1;
        }
        return result;
    }

    public double power(String message, int base, int exponent) {
        double p = power(base, exponent);
        System.out.println("message = " + message + p);
        return p;
    }
}
