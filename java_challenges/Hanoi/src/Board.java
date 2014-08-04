import java.util.Stack;

public class Board {

    int disks;

    public Board(int count) {
        disks = count;
    }

    public void show(Hanoi hanoi) {
        String pegs = pegs(hanoi);
        CharacterDisplay.render(pegs, disks);
    }

    public void start() {
        CharacterDisplay.message("Playing Hanoi for " + disks + " disks:\n");
    }

    public void done() {
        CharacterDisplay.message("Solved.");
    }

    private String pegs(Hanoi hanoi) {
        String pegs = "";
        for (int i = 1; i <= Hanoi.Disks; i++) {
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
            slot = CharacterDisplay.number(diskSize, disks);
        } else {
            slot = CharacterDisplay.space(disks);
        }
        return slot;
    }
}