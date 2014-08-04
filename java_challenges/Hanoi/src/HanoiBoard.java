import java.util.Stack;

public class HanoiBoard {

    int disks;

    public HanoiBoard(int count) {
        disks = count;
    }

    public void showBoard(Hanoi hanoi) {
        String pegs = drawPegs(hanoi);
        CharacterDisplay.show(pegs, disks);
    }

    public void startMessage() {
        CharacterDisplay.message("Playing Hanoi for " + disks + " disks:\n");
    }

    public void doneMessage() {
        CharacterDisplay.message("Solved.");
    }

    private String drawPegs(Hanoi hanoi) {
        String pegs = "";
        for (int i = 1; i <= Hanoi.Disks; i++) {
            String row = drawSlot(i, hanoi.peg_1) +
                    drawSlot(i, hanoi.peg_2) +
                    drawSlot(i, hanoi.peg_3);
            pegs = row + "\n" + pegs;
        }
        return pegs;
    }

    private String drawSlot(int level, Stack<Integer> peg) {
        String slot;
        if (peg.size() >= level) {
            int diskSize = peg.get(level - 1);
            slot = CharacterDisplay.drawNumbers(diskSize, disks);
        } else {
            slot = CharacterDisplay.drawSpace(disks);
        }
        return slot;
    }
}