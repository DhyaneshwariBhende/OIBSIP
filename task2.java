/* ----------------------------------------------------------------------------------------------------
                    OASIS INFOBYTE
                JAVA DEVELOPER INTERNSHIP
                   DHYANESHWARI BHENDE  
                        TASK-2
                   NUMBER GUESSING GAME
 -------------------------------------------------------------------------------------------------------
 ------------------------------------------------------------------------------------------------------*/

import java.util.Random;
import java.util.Scanner;

public class task2 {
    public static void main(String[] args) {
        numberGuessingGame();
    }

    public static void numberGuessingGame() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int secretNumber = random.nextInt(100) + 1;

        System.out.println("\t\t\t\t\t\tHELLO ALL-\n\t\t\t\tWelcome to the Number Guessing Game!");
        System.out.println("\t\tHey..! I'm Thinking Of a Number Between 1 and 100, And You Need To Guess The Number:");
        int chances = getChancesFromUser(scanner);

        for (int attempt = 1; attempt <= chances; attempt++) {
            System.out.printf("Attempt %d of %d. \nEnter your guess: ", attempt, chances);
            int guess = scanner.nextInt();

            if (guess == secretNumber) {
                System.out.println("Congratulations Player!! You Guessed The Correct Number.");
                return;
            } else if (guess < secretNumber) {
                System.out.println("The Number Is Too Low! Try Guessing a Higher Number.");
            } else {
                System.out.println("The Number Is Too High! Try Guessing a Low Number.");
            }
        }

        System.out.println("Game Over! Sorry But You Have Exhausted All Your Chances.");
        System.out.println("The Secret Number (The Number Which I Think) Was: " + secretNumber);
    }

    public static int getChancesFromUser(Scanner scanner) {
        System.out.print("Enter The Number Of Chances You Want To Guess The Number: ");
        return scanner.nextInt();
    }
}


 