import java.io.*;
import java.util.Arrays;

public class Sunil {

    //    public class Solution {
    public static void main(String args[]) throws Exception {
/* Enter your code here. Read input from STDIN. Print output to STDOUT */
// unable to read input using system console so not sure how to compile.
//LOGIC: sort using quick sort in O(nlogn) and take two pointers the first one is fixed and second one advance until a difference = or > K is reached, after that first pointer advance by 1 and second pointer advance until the difference = or > k repeat the process. I'm using java arrays.sort it's merge sort and performance is O(nlogn)
        String[] firstLine = System.console().readLine(" first Line").split(" "); // not sure what the delimiter is, involves a split and convert to int.
        int len = Integer.parseInt(firstLine[0]);
        int K = Integer.parseInt(firstLine[1]);
        String[] inArrayStr = System.console().readLine(" second Line").split(" "); // not sure what the delimiter is, involves a split and convert to int.
        int[] inArray = new int[len];
// convert literals to int
        for (int i = 0; i < len; i++) {
            inArray[i] = Integer.parseInt(inArrayStr[i]);
        }
//        int sArray = Arrays.sort(inArray); // merge sort
        Arrays.sort(inArray); // merge sort
        int lastI = 0;
        int lastJ = 1;
        int pcount = 0;
        int i, j;
        for (i = lastI; i < len - 1; i++) {
            for (j = lastJ; j < len; j++) {
                if (sArray[j] - sArray[i] == K) {
                    pcount++;
                    lastJ = j + 1;
                    lastI = i + 1;
                } else if (sArray[j] - sArray[i] > K) {
                    lastJ = j + 1;
                    lastI = i + 1;
                }
            }
        }
        System.out.println(pcount);
    }
}