import java.util.Stack;

public class Board {

    private int disks;

    public Board(int count) {
        disks = count;
    }

    public void show(Hanoi hanoi) throws InterruptedException {
        String pegs = pegs(hanoi);
        CharacterDisplay.render(pegs, disks);
        wait_seconds(1.2);
    }

    public void start() {
        CharacterDisplay.message("Playing Hanoi for " + disks + " disks:\n");
    }

    public void done() {
        CharacterDisplay.message("Solved.");
    }

    private String pegs(Hanoi hanoi) {
        String pegs = "";
        for (int i = 1; i <= disks; i++) {
            String row = slot(i, hanoi.peg_1) +
                    slot(i, hanoi.peg_2) +
                    slot(i, hanoi.peg_3);
            pegs = row + "\n" + pegs;
        }
        return pegs;
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