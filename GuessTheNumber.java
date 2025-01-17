import java.util.Scanner;
import java.util.Random;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 10;
        int totalScore = 0;
        boolean playAgain;

        System.out.println("Welcome to the Guess the Number Game!");
        System.out.println("Try to guess the number between " + minRange + " and " + maxRange + ".");

        do {
            int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nNew round started! You have " + maxAttempts + " attempts.");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == targetNumber) {
                    guessedCorrectly = true;
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    totalScore += (maxAttempts - attempts + 1) * 10; // Points decrease with attempts
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("The number is higher than your guess.");
                } else {
                    System.out.println("The number is lower than your guess.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("You've used all attempts! The number was: " + targetNumber);
            }

            System.out.println("Your current score is: " + totalScore);
            System.out.print("Do you want to play another round? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");

        } while (playAgain);

        System.out.println("\nGame Over! Your final score is: " + totalScore);
        System.out.println("Thanks for playing!");
        scanner.close();
    }
}
