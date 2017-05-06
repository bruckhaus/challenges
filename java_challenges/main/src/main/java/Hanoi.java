import java.util.Arrays;
import java.util.Stack;

public class Hanoi {

    private Stack<Integer> sourcePeg = new Stack<>();
    private Stack<Integer> helperPeg = new Stack<>();
    private Stack<Integer> targetPeg = new Stack<>();

    public static void main(String[] args) {
        new Hanoi().solve(5);
    }

    private void solve(int disks) {
        setUp(disks);
        System.out.println("Playing Hanoi for " + disks + " disks:\n");
        showPegs();
        move(disks, sourcePeg, targetPeg, helperPeg);
        System.out.println("Solved.");
    }

    private void move(int n, Stack<Integer> sourcePeg, Stack<Integer> targetPeg, Stack<Integer> helperPeg) {
        if (n > 0) {
            move(n - 1, sourcePeg, helperPeg, targetPeg);
            targetPeg.push(sourcePeg.pop());
            showPegs();
            move(n - 1, helperPeg, targetPeg, sourcePeg);
        }
    }

    private void showPegs() {
        System.out.println("sourcePeg = " + Arrays.toString(sourcePeg.toArray()));
        System.out.println("helperPeg = " + Arrays.toString(helperPeg.toArray()));
        System.out.println("targetPeg = " + Arrays.toString(targetPeg.toArray()) + "\n");
    }

    private void setUp(int disks) {
        for (int i = disks; i > 0; i--) {
            sourcePeg.push(i);
        }
    }
}