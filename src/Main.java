import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Integer N, M;
        String inputVectorAsString;
        Scanner scanner = new Scanner(System.in);

        System.out.println("This program receives an integer vector and checks if it has any element divisible by N nad M.");
        System.out.println("Note that you should only enter numbers (do not use any letter or space) otherwise the execution will be terminated.");

        System.out.print("Enter an integer value for N: ");
        N = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter an integer value for M: ");
        M = Integer.parseInt(scanner.nextLine());

        System.out.println("Please enter your vector elements (comma separated) below.");
        inputVectorAsString = scanner.nextLine();

        //get processing start time in millis
        long processingTimeStart = System.currentTimeMillis();

        //validate the input, terminate for any letter/space input
        for (int i = 0; i < inputVectorAsString.length(); i++) {
            char c = inputVectorAsString.charAt(i);
            if (Character.isLetter(c) || c == ' ') {
                System.exit(0);
            }
        }

        //find the position of the integer which is divisible by N and M
        String[] elements = inputVectorAsString.split(",");
        int position = 1;
        boolean found = false;
        for (String element : elements) {
            Integer integer = Integer.parseInt(element);
            if (integer % N == 0 && integer % M == 0) {
                found = true;
                break;
            }
            position++;
        }

        //calculate total processing time in millis
        long processingTime = System.currentTimeMillis() - processingTimeStart;

        if (found) {
            System.out.println("Element " + position + " of the entered vector is divisible by both " + N + " and " + M + ".");
        }

        System.out.println("The entered vector is processed in " + processingTime + " milliseconds.");
    }
}