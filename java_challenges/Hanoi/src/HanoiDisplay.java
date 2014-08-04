import java.util.Stack;

public class HanoiDisplay {

    CharacterBoard board;

    public HanoiDisplay(int count) {
        board = new CharacterBoard(count);
    }

    public void showBoard(Hanoi hanoi) {
        String pegs = drawPegs(hanoi, board);
        board.renderBoard(pegs);
    }

    public void startMessage() {
        board.startMessage();
    }

    public void doneMessage() {
        board.doneMessage();
    }

    private String drawPegs(Hanoi hanoi, CharacterBoard board) {
        String pegs = "";
        for (int i = 1; i <= Hanoi.Disks; i++) {
            String row = drawSlot(board, i, hanoi.peg_1) +
                    drawSlot(board, i, hanoi.peg_2) +
                    drawSlot(board, i, hanoi.peg_3);
            pegs = row + "\n" + pegs;
        }
        return pegs;
    }

    private String drawSlot(CharacterBoard board, int level, Stack<Integer> peg) {
        String slot;
        if (peg.size() >= level) {
            int diskSize = peg.get(level - 1);
            slot = board.drawDisk(diskSize);
        } else {
            slot = board.drawSpace();
        }
        return slot;
    }

}
