public class CharacterDisplay {

    static void render(String content, int size) {
        System.out.print(content + drawBase(size));
    }

    private static String drawBase(int size) {
        StringBuilder base = new StringBuilder();
        for (int i = 1; i < 3 * (2 * size + 2); i++) {
            base.append("-");
        }
        base.append("\n\n");
        return base.toString();
    }

    static String drawNumber(int number, int size) {
        return spacer(size - number) + numberLine(number) + "|" +
                numberLine(number) + spacer(size - number) + " ";
    }

    static String drawSpace(int size) {
        return spacer(size) + "|" + spacer(size) + " ";
    }

    static void message(String message) {
        System.out.println(message);
    }

    private static String numberLine(int number) {
        StringBuilder line = new StringBuilder();
        for (int i = 1; i <= number; i++) {
            line.append(number);
        }
        return line.toString();
    }

    private static String spacer(int size) {
        StringBuilder line = new StringBuilder();
        for (int i = 1; i <= size; i++) {
            line.append(" ");
        }
        return line.toString();
    }
}