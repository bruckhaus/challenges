public class ReverseString {
    public static String reverseString(String str) {
        System.out.println("\nstr = " + str);
        String result = "";
        for (int i = str.length()-1; i >= 0; i--) {
            result += str.charAt(i);
        }
        System.out.println("result = " + result);
        return result;
    }
}
