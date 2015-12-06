public class Euler_43_SubstringDivisibility {
//    Sub-string divisibility
//    Problem 43
//    The number, 1406357289, is a 0 to 9 pandigital number
//    because it is made up of each of the digits 0 to 9 in some order,
//    but it also has a rather interesting sub-string divisibility property.
//    Let d1 be the 1st digit, d2 be the 2nd digit, and so on. In this way, we note the following:
//    d2d3d4=406 is divisible by 2
//    d3d4d5=063 is divisible by 3
//    d4d5d6=635 is divisible by 5
//    d5d6d7=357 is divisible by 7
//    d6d7d8=572 is divisible by 11
//    d7d8d9=728 is divisible by 13
//    d8d9d10=289 is divisible by 17
//    Find the sum of all 0 to 9 pandigital numbers with this property.

    private static int[] divisors = {2, 3, 5, 7, 11, 13, 17};

    public static void main(String[] args) {
        long result = Euler_43_SubstringDivisibility.sumSubStringDivisibles();
        System.out.printf("The sum of sub-string divisible pandigital numbers is %d.", result);
    }

    public static long sumSubStringDivisibles() {
        Pandigital.setLength(10);
        long sum = 0;
        while (Pandigital.hasNext()) {
            if (isSubStringDivisible()) sum += Pandigital.current;
            Pandigital.next();
        }
        return sum;
    }

    public static boolean isSubStringDivisible() {
        int substringNumber;
        for (int index = 0; index < divisors.length; index++) {
            substringNumber = getSubstringNumber(index + 1);
            if (substringNumber % divisors[index] != 0) return false;
        }
        return true;
    }

    public static int getSubstringNumber(int offset) {
        String pandigitalString = "" + Pandigital.current;
        String substring = "";
        for (int i = offset; i <= offset + 2; i++) {
            substring = substring + pandigitalString.charAt(i);
        }
        return Integer.parseInt(substring);
    }

    public static boolean isSubStringDivisible(long number) {
        Pandigital.setCurrent(number);
        return isSubStringDivisible();
    }
}
