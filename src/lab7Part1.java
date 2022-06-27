import java.util.Scanner;

public class lab7Part1 {
    public static void main(String[] args) {
        /* Creating a scanner object */
        Scanner input = new Scanner(System.in);
        /* Reading the elements of a binary vector inform of a single string. */
        System.out.println("Enter the elements of your string vector (comma separated).");
        String vec = input.next();
        /* Writing the sum of the binary vector elements in the console. */
        System.out.println("Sum of the entered vector elements is :" + BVS(vec));
    }

    private static String BVS(String vec) {

        /* Initiating the decimal summation. */
        int sum = 0;

        /* Calculating the decimal sum of binary elements by converting them into decimal. */
        String[] elements = vec.split(",");
        for (String element : elements) {
            sum += Integer.parseInt(element, 2);
        }

        /* Returning the summation after converting to binary string from its decimal value. */
        return Integer.toBinaryString(sum);
    }


}
