import java.util.Scanner;
import java.util.Random;

public class GuessNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int score = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) {
            int numberToGuess = random.nextInt(100) + 1;
            int attempts = 5;
            boolean guessedCorrectly = false;

            System.out.println("\nI have generated a number between 1 and 100. Can you guess it?");
            System.out.println("You have " + attempts + " attempts.");

            while (attempts > 0 && !guessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts--;

                if (userGuess == numberToGuess) {
                    System.out.println("🎉 Congratulations! You guessed the correct number.");
                    guessedCorrectly = true;
                    score++;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low! Try again. You still have " + attempts + " attempts left.");
                } else {
                    System.out.println("Too high! Try again. You still have " + attempts + " attempts left.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("❌ Sorry, you've used all your attempts. The correct number was " + numberToGuess + ".");
            }

            System.out.println("Your current score is: " + score);

            System.out.print("\nDo you want to play another round? (yes/no): ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("yes");
        }

        System.out.println("\nThank you for playing! Your final score is: " + score);
        scanner.close();
    }
}
