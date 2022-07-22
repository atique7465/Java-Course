package guessingGame;

import java.util.Random;

public class GuessingGame02 {
    public static void main(String[] args) {

        int upperBand = 100;
        System.out.println("The answer is a number between 0 and " + upperBand);

        upperBand = upperBand + 1; //adding 1 with upper band to generate answer inclusive upper band.

        //generating game answer
        Random random = new Random();
        int gameAnswer = random.nextInt(upperBand);

        //start guessing by computer
        int guessCount = 0; //store the guess count
        int guess = -1;     //initiate first guess as -1, as answer can't be < 0;
        int lower = 0, upper = upperBand;
        while (guess != gameAnswer) {
            guess = random.nextInt(upper - lower + 1) + lower;  //guessing randomly in current range
            System.out.println("The guess# " + ++guessCount + " is " + guess + ".");

            if (guess > gameAnswer) {
                System.out.println("Guess is higher than the answer.");
                upper = guess - 1;  //skipping numbers > (guess - 1) for next guess
            } else if (guess < gameAnswer) {
                System.out.println("Guess is lower than the answer.");
                lower = guess + 1;  //skipping numbers < (guess + 1) for next guess
            }
        }

        System.out.println("Correct! Took " + guessCount + " guesses to find the answer.");
    }
}

// time complexity O(n)
