public class StrDist {
//    Finding length of largest substring of string str, starting and ending in given string sub.
//    source: http://codingbat.com/prob/p195413

    public static int strDist(String str, String sub) {
        System.out.println("\nstr = " + str);
        System.out.println("sub = " + sub);
        int result = recursiveStrDist(str, sub);
        System.out.println("result = " + result);
        return result;
    }

    public static int recursiveStrDist(String str, String sub) {
        int result;
        if (str.length() < sub.length()) {
            result = 0;
        } else if (frontMatch(str, sub)) {
            if (backMatch(str, sub)) {
                result = str.length();
            } else {
                result = recursiveStrDist(clipBack(str), sub);
            }
        } else {
            result = recursiveStrDist(clipFront(str), sub);
        }
        return result;
    }

    private static String clipFront(String str) {
        return str.substring(1, str.length());
    }

    private static String clipBack(String str) {
        return str.substring(0, str.length() - 1);
    }

    private static boolean backMatch(String str, String sub) {
        return str.substring(str.length() - sub.length()).equals(sub);
    }

    private static boolean frontMatch(String str, String sub) {
        return str.substring(0, sub.length()).equals(sub);
    }
}
