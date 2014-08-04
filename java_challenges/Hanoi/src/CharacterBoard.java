public class CharacterBoard {

    public int disks;

    public CharacterBoard(int count) {
        disks = count;
    }

    public void renderBoard(String pegs) {
        System.out.print(pegs + drawTable());
    }

    public String drawTable() {
        String table = "";
        for (int i = 1; i < 3 * (2 * disks + 2); i++) {
            table += "-";
        }
        table += "\n\n";
        return table;
    }

    public String drawDisk(int diskSize) {
        return spacer(diskSize) + halfDisk(diskSize) + "|" +
                halfDisk(diskSize) + spacer(diskSize) + " ";
    }

    public String drawSpace() {
        return halfSpace() + "|" + halfSpace() + " ";
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
        for (int j = diskSize; j < disks; j++) {
            spacer += " ";
        }
        return spacer;
    }

    private String halfSpace() {
        String halfSpace = "";
        for (int j = 1; j <= disks; j++) {
            halfSpace += " ";
        }
        return halfSpace;
    }

    public void startMessage() {
        System.out.println("Playing Hanoi for " + disks + " disks:\n");
    }

    public void doneMessage() {
        System.out.println("Solved.");
    }
}
