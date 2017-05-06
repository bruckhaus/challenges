import java.util.Stack;

class Hanoi {

    private static int Disks = 4;

    private Board board = new Board(Disks);

    Stack<Integer> peg_1 = new Stack<>();
    Stack<Integer> peg_2 = new Stack<>();
    Stack<Integer> peg_3 = new Stack<>();

    public static void main(String[] args) throws InterruptedException {
        new Hanoi().solve();
    }

    private void solve() throws InterruptedException {
        setUp();
        board.start();
        board.show(this);
        move(Disks, peg_1, peg_2, peg_3);
        board.done();
    }

    private void move(int n,
                      Stack<Integer> sourcePeg,
                      Stack<Integer> helperPeg,
                      Stack<Integer> targetPeg) throws InterruptedException {
        if (n > 0) {
            move(n - 1, sourcePeg, targetPeg, helperPeg);
            targetPeg.push(sourcePeg.pop());
            board.show(this);
            move(n - 1, helperPeg, sourcePeg, targetPeg);
        }
    }

    private void setUp() {
        for (int i = Disks; i > 0; i--) {
            peg_1.push(i);
        }
    }
}