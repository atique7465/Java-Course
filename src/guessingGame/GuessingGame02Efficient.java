package guessingGame;

import java.util.Random;

public class GuessingGame02Efficient {
    public static void main(String[] args) {

        int upperBand = 100;
        System.out.println("The answer is a number between 0 and " + upperBand);

        upperBand = upperBand + 1; //adding 1 with upper band to generate answer inclusive upper band.

        //generating game answer
        Random random = new Random();
        int gameAnswer = random.nextInt(upperBand);

        //start guessing by computer
        int guessCount = 1; //store the guess count
        int lower = 0, upper = upperBand, guess;
        while (lower <= upper) {
            guess = (lower + upper) / 2;
            System.out.println("The guess# " + guessCount + " is " + guess + ".");

            if (guess == gameAnswer) {
                System.out.println("Correct! Took " + guessCount + " guesses to find the answer.");
                break;
            } else if (guess > gameAnswer) {
                System.out.println("Guess is higher than the answer.");
                upper = guess - 1;
            } else {
                System.out.println("Guess is lower than the answer.");
                lower = guess + 1;
            }

            guessCount++;
        }
    }
}

//time complexity O(log n)

