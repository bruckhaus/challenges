import java.util.Stack;

class Hanoi {

    static int Disks = 4;

    Stack<Integer> peg_1 = new Stack<>();
    Stack<Integer> peg_2 = new Stack<>();
    Stack<Integer> peg_3 = new Stack<>();

    public static void main(String[] args) {
        new Hanoi().solve(Disks);
    }

    private void solve(int disks) {
        setUp(disks);
        System.out.println("Playing Hanoi for " + disks + " disks:\n");
        showBoard();
        move(disks, peg_1, peg_2, peg_3);
        System.out.println("Solved.");
    }

    private void move(int n, Stack<Integer> sourcePeg, Stack<Integer> helperPeg, Stack<Integer> targetPeg) {
        if (n > 0) {
            move(n - 1, sourcePeg, targetPeg, helperPeg);
            targetPeg.push(sourcePeg.pop());
            showBoard();
            move(n - 1, helperPeg, sourcePeg, targetPeg);
        }
    }

    private void setUp(int disks) {
        for (int i = disks; i > 0; i--) {
            peg_1.push(i);
        }
    }

    private void showBoard() {
        System.out.print(drawPegs() + drawTable());
    }

    private String drawPegs() {
        String pegs = "";
        for (int i = 1; i <= Disks; i++) {
            String row = drawSlot(i, peg_1) +
                    drawSlot(i, peg_2) +
                    drawSlot(i, peg_3);
            pegs = row + "\n" + pegs;
        }
        return pegs;
    }

    private String drawTable() {
        String table = "";
        for (int i = 1; i < 3 * (2 * Disks + 2); i++) {
            table += "-";
        }
        table += "\n\n";
        return table;
    }

    private String drawSlot(int level, Stack<Integer> peg) {
        String slot;
        if (peg.size() >= level) {
            int diskSize = peg.get(level - 1);
            slot = drawDisk(diskSize);
        } else {
            slot = drawSpace();
        }
        return slot;
    }

    private String drawDisk(int diskSize) {
        return spacer(diskSize) + halfDisk(diskSize) + "|" +
                halfDisk(diskSize) + spacer(diskSize) + " ";
    }

    private String halfDisk(int diskSize) {
        String halfDisk = "";
        for (int j = 1; j <= diskSize; j++) {
            halfDisk += diskSize;
        }
        return halfDisk;
    }

    private String spacer(int diskSize) {
        String spacer = "";
        for (int j = diskSize; j < Disks; j++) {
            spacer += " ";
        }
        return spacer;
    }

    private String drawSpace() {
        return halfSpace() + "|" + halfSpace() + " ";
    }

    private String halfSpace() {
        String halfSpace = "";
        for (int j = 1; j <= Disks; j++) {
            halfSpace += " ";
        }
        return halfSpace;
    }
}