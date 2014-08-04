import java.util.Stack;

class Hanoi {

    static int Disks = 4;

    Board board = new Board(Disks);

    Stack<Integer> peg_1 = new Stack<>();
    Stack<Integer> peg_2 = new Stack<>();
    Stack<Integer> peg_3 = new Stack<>();

    public static void main(String[] args) {
        new Hanoi().solve(Disks);
    }

    private void solve(int disks) {
        setUp(disks);
        board.start();
        board.show(this);
        move(disks, peg_1, peg_2, peg_3);
        board.done();
    }

    private void move(int n, Stack<Integer> sourcePeg, Stack<Integer> helperPeg, Stack<Integer> targetPeg) {
        if (n > 0) {
            move(n - 1, sourcePeg, targetPeg, helperPeg);
            targetPeg.push(sourcePeg.pop());
            board.show(this);
            move(n - 1, helperPeg, sourcePeg, targetPeg);
        }
    }

    private void setUp(int disks) {
        for (int i = disks; i > 0; i--) {
            peg_1.push(i);
        }
    }
}