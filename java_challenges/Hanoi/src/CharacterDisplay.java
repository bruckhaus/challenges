public class CharacterDisplay {

    public static void show(String content, int size) {
        System.out.print(content + drawBase(size));
    }

    public static String drawBase(int size) {
        String base = "";
        for (int i = 1; i < 3 * (2 * size + 2); i++) {
            base += "-";
        }
        base += "\n\n";
        return base;
    }

    public static String drawNumbers(int number, int size) {
        return spacer(number, size) + numberLine(number) + "|" +
                numberLine(number) + spacer(number, size) + " ";
    }

    public static String drawSpace(int size) {
        return spaceLine(size) + "|" + spaceLine(size) + " ";
    }

    public static void message(String message) {
        System.out.println(message);
    }

    private static String numberLine(int number) {
        String line = "";
        for (int j = 1; j <= number; j++) {
            line += number;
        }
        return line;
    }

    private static String spacer(int start, int size) {
        String spacer = "";
        for (int j = start; j < size; j++) {
            spacer += " ";
        }
        return spacer;
    }

    private static String spaceLine(int size) {
        String line = "";
        for (int j = 1; j <= size; j++) {
            line += " ";
        }
        return line;
    }
}