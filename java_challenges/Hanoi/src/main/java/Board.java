import java.util.Stack;

public class Board {

    private static final double WAIT_SECONDS = 1.2;
    private int disks;

    Board(int count) {
        disks = count;
    }

    void show(Hanoi hanoi) throws InterruptedException {
        String pegs = pegs(hanoi);
        CharacterDisplay.render(pegs, disks);
        wait_seconds(WAIT_SECONDS);
    }

    void start() {
        CharacterDisplay.message("Playing Hanoi for " + disks + " disks:\n");
    }

    void done() {
        CharacterDisplay.message("Solved.");
    }

    private String pegs(Hanoi hanoi) {
        StringBuilder pegs = new StringBuilder();
        for (int i = 1; i <= disks; i++) {
            String row = slot(i, hanoi.peg_1) +
                    slot(i, hanoi.peg_2) +
                    slot(i, hanoi.peg_3);
            pegs.insert(0, row + "\n");
        }
        return pegs.toString();
    }

    private String slot(int level, Stack<Integer> peg) {
        String slot;
        if (peg.size() >= level) {
            int diskSize = peg.get(level - 1);
            slot = CharacterDisplay.drawNumber(diskSize, disks);
        } else {
            slot = CharacterDisplay.drawSpace(disks);
        }
        return slot;
    }

    private void wait_seconds(double seconds) throws InterruptedException {
        Thread.sleep((long) (1000 * seconds));
    }
}