import java.util.Random;

public class IntegerThenString {
    public static void main(String[] args) {
        Random random = new Random();
        Integer band = 11;

        int n = 10;
        while (n-- > 0) {
            System.out.println(random.nextInt(11) + 10);
        }
    }
}