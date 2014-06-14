import java.util.Arrays;
import java.util.Stack;

public class Hanoi {

    Stack<Integer> sourcePeg = new Stack<Integer>();
    Stack<Integer> targetPeg = new Stack<Integer>();
    Stack<Integer> helperPeg = new Stack<Integer>();

    private void solve(int disks) {
        for (int i = disks; i > 0; i--) {
            sourcePeg.push(i);
        }
        System.out.println("Playing Hanoi for " + disks + " disks:\n");
        showPegs();
        move(disks, sourcePeg, targetPeg, helperPeg);
        System.out.println("Solved.");
    }

    private void move(int n, Stack<Integer> sourcePeg, Stack<Integer> targetPeg, Stack<Integer> helperPeg) {
        if (n > 0) {
            if (n > 1) {
                move(n - 1, sourcePeg, helperPeg, targetPeg);
            }
            targetPeg.push(sourcePeg.pop());
            showPegs();
            if (n > 1) {
                move(n - 1, helperPeg, targetPeg, sourcePeg);
            }
        }
    }

    private void showPegs() {
        System.out.println("sourcePeg = " + Arrays.toString(sourcePeg.toArray()));
        System.out.println("helperPeg = " + Arrays.toString(helperPeg.toArray()));
        System.out.println("targetPeg = " + Arrays.toString(targetPeg.toArray()) + "\n");
    }

    public static void main(String[] args) {
        Hanoi hanoi = new Hanoi();
        hanoi.solve(5);
    }
}
