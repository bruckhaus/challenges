package main.java;

import java.util.ArrayList;
import java.util.Arrays;

public class Fix34 {

    public static int[] fix34(int[] numbers) {
        ArrayList<Integer> list = arrayToArrayList(numbers);
        int lastPos = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 3) {
                int pos = findFourPosition(list, lastPos);
                swap(list, i + 1, pos);
                lastPos = pos;
            }
        }
        return arrayListToArray(list);
    }

    private static int findFourPosition(ArrayList<Integer> numbers, int start) {
        for (int i = start + 1; i < numbers.size(); i++) {
            if (numbers.get(i) == 4) {
                return i;
            }
        }
        return -1;
    }

    private static void swap(ArrayList<Integer> list, int i, int pos) {
        int temp = list.get(i);
        list.set(i, list.get(pos));
        list.set(pos, temp);
    }

    // Converts an array to an ArrayList.
    private static ArrayList<Integer> arrayToArrayList(int[] list) {
        ArrayList<Integer> newList = new ArrayList<>();
        for (int x : list)
            newList.add(x);
        return newList;
    }

    // Converts an ArrayList to an array.
    private static int[] arrayListToArray(ArrayList<Integer> list) {
        int[] newList = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            newList[i] = list.get(i);
        return newList;
    }

    private static void testFix34(int[] input) {
        int[] result = fix34(input);
        System.out.println(Arrays.toString(result));
    }

    public static void main(String[] args) {
        testFix34(new int[]{1, 2, 3, 5, 4});        // → [1, 2, 3, 4, 5]
        testFix34(new int[]{1, 3, 1, 4});           // → {1, 3, 4, 1}
        testFix34(new int[]{1, 3, 1, 4, 4, 3, 1});  // → {1, 3, 4, 1, 1, 3, 4}
        testFix34(new int[]{3, 2, 2, 4});           // → {3, 4, 2, 2}
    }
}
