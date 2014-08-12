import java.util.Random;

public class PseudoRandom {
    public static void main(String[] args) throws InterruptedException {
        pseudoRandom();
        realRandom();
    }

    private static void pseudoRandom() {
        System.out.println("\nGenerating 2 trails of pseudo-random numbers:");
        for (int trial = 1; trial <= 2; trial++) {
            System.out.println("\nTrial " + trial + ":");
            Random r = new Random(123);
            for (int i = 1; i <= 10; i++) {
                System.out.println(i + ": " + r.nextInt(100));
            }
        }
    }

    private static void realRandom() throws InterruptedException {
        System.out.println("\nGenerating 2 trails of really random numbers:");
        for (int trial = 1; trial <= 2; trial++) {
            System.out.println("\nTrial " + trial + ":");
            for (int i = 1; i <= 10; i++) {
                pause();
                Random rand = new Random(System.currentTimeMillis());
                System.out.println(i + ": " + rand.nextInt(100));
            }
        }
    }

    private static void pause() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}
