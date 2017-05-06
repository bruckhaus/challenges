public class CharacterDisplay {

    public static void render(String content, int size) {
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

    public static String drawNumber(int number, int size) {
        return spacer(size - number) + numberLine(number) + "|" +
                numberLine(number) + spacer(size - number) + " ";
    }

    public static String drawSpace(int size) {
        return spacer(size) + "|" + spacer(size) + " ";
    }

    public static void message(String message) {
        System.out.println(message);
    }

    private static String numberLine(int number) {
        String line = "";
        for (int i = 1; i <= number; i++) {
            line += number;
        }
        return line;
    }

    private static String spacer(int size) {
        String line = "";
        for (int i = 1; i <= size; i++) {
            line += " ";
        }
        return line;
    }
}