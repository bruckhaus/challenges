import java.util.*;

public class P62_CubicPermutations {

    private static final int TARGET_COUNT = 5;

    private static Map<String, List<Integer>> countMap = new TreeMap<>();

    public static void main(String[] args) {
        String message = "The smallest cube for which exactly five permutations of its digits are cube is %,.0f.\n";
        double cube = findCube(TARGET_COUNT);
        System.out.printf(message, cube);
    }

    static void reset() {
        countMap = new TreeMap<>();
    }

    static double findCube(int targetCount) {
        Integer base = 1;
        while (true) {
            if (getCount(base) == targetCount) return getSmallestCube(base);
            base++;
        }
    }

    static double getSmallestCube(Integer base) {
        double cube = Math.pow(base, 3);
        String orderedDigits = getOrderedDigits(cube);
        Integer smallestBase = countMap.get(orderedDigits).get(0);
        return Math.pow(smallestBase, 3);
    }

    static int getCount(Integer base) {
        double cube = Math.pow(base, 3);
        String orderedDigits = getOrderedDigits(cube);
        List<Integer> cubeList = countMap.get(orderedDigits);
        if (cubeList == null) {
            cubeList = new ArrayList<>();
            countMap.put(orderedDigits, cubeList);
        }
        cubeList.add(base);
        return cubeList.size();
    }

    static String getOrderedDigits(double cube) {
        String s = String.format("%.0f", cube);
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
