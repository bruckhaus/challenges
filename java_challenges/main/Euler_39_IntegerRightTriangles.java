public class Euler_39_IntegerRightTriangles {
// Integer right triangles
//    Problem 39
//    If p is the perimeter of a right angle triangle
//    with integral length sides, {a,b,c},
//    there are exactly three solutions for p = 120.
//    {20,48,52}, {24,45,51}, {30,40,50}
//    For which value of p ≤ 1000, is the number of solutions maximised?
//    Credit: http://www.mathblog.dk/files/euler/Problem39.cs

    public static void main(String[] args) {
        Euler_39_IntegerRightTriangles e = new Euler_39_IntegerRightTriangles();
        e.BruteForce();
        e.NumberTheory();
        e.Arithmetic();
    }

    public void BruteForce() {
        int[] p = new int[1001];
        int result = 0;
        for (int a = 1; a <= 998; a++) {
            for (int b = 1; b + a <= 999; b++) {
                for (int c = 1; c + b + a <= 1000; c++) {
                    if (a * a + b * b == c * c) {
                        p[a + b + c]++;
                    }
                }
            }
        }
        for (int i = 1; i < p.length; i++) {
            if (p[i] > p[result]) {
                result = i;
            }
        }
        System.out.printf(
                "The number of solutions is maximized for p=%d resulting in %d solutions\n",
                result, p[result]);
    }


    public void NumberTheory() {
        int pMax = 0, tMax = 0;
        int m, k;

        for (int s = 1; s <= 1000; s++) {
            int t = 0;
            int mLimit = (int) Math.sqrt(s / 2);
            for (m = 2; m <= mLimit; m++) {
                if ((s / 2) % m == 0) { // m found
                    if (m % 2 == 0) { // ensure that we find an odd number for k
                        k = m + 1;
                    } else {
                        k = m + 2;
                    }
                    while (k < 2 * m && k <= s / (2 * m)) {
                        if (s / (2 * m) % k == 0 && gcd(k, m) == 1) {
                            t++;
                        }
                        k += 2;
                    }
                }
            }
            if (t > tMax) {
                tMax = t;
                pMax = s;
            }
        }
        System.out.printf(
                "The number of solutions is maximized for p=%d resulting in %d solutions\n",
                pMax, 2 * tMax);
    }


    public int gcd(int a, int b) {
        int y;
        int x;
        if (a > b) {
            x = a;
            y = b;
        } else {
            x = b;
            y = a;
        }
        while (x % y != 0) {
            int temp = x;
            x = y;
            y = temp % x;
        }
        return y;
    }

    public void Arithmetic() {
        int numberOfSolutions = 0;
        long result = 0, resultSolutions = 0;
        for (long p = 2; p <= 1000; p += 2) {
            numberOfSolutions = 0;
            for (long a = 2; a < (p / 3); a++) {
                if (p * (p - 2 * a) % (2 * (p - a)) == 0) {
                    numberOfSolutions++;
                }
            }
            if (numberOfSolutions > resultSolutions) {
                resultSolutions = numberOfSolutions;
                result = p;
            }
        }
        System.out.printf(
                "The number of solutions is maximized for p=%d resulting in %d soltuions\n",
                result, resultSolutions);
    }
}
