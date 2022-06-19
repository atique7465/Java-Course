import java.util.Random;
import java.util.Scanner;

public class GuessingGame01 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //getting upper band input
        System.out.print("Please enter the upper range of the game: ");
        int upperBand = Integer.parseInt(scanner.nextLine()) + 1; //adding 1 with upper band to generate answer inclusive upper band.

        //generating game answer
        Random random = new Random();
        int gameAnswer = random.nextInt(upperBand);

        //start guessing
        int guessCount = 0; //store the guess count
        int guess = -1;     //initiate first guess as -1, as answer can't be < 0;
        while (guess != gameAnswer) {
            System.out.print("Enter a Guess: ");
            guess = Integer.parseInt(scanner.nextLine());

            if (guess > gameAnswer) {
                System.out.println("Guess is higher than the answer.");
            } else if (guess < gameAnswer) {
                System.out.println("Guess is lower than the answer.");
            }

            guessCount++;
        }

        System.out.println("Correct! Took " + guessCount + " guesses to find the answer.");
    }
}
