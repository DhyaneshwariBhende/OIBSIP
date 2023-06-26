/*
 ---------------------------------------------------------------------------------------------------------
                            OASIS INFOBYTE
                        JAVA DEVELOPER INTERNSHIP
                           DHYANESHWARI BHENDE  
                                TASK-3
----------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------
 */

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;


public class task3 {
    public static void main(String[] args) {
        ATMInterface atmInterface = new ATMInterface();
        atmInterface.startATM();
    }
}

class ATMInterface {
    private Map<String, String> userCredentials;
    private double balance;

    public ATMInterface() {
        userCredentials = new HashMap<>();
        userCredentials.put("user123", "1234");
        balance = 5000.0;
    }

    public void startATM() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the ATM!");

        boolean isAuthenticated = false;
        while (!isAuthenticated) {
            System.out.print("Enter User ID: ");
            String userId = scanner.nextLine();
            System.out.print("Enter User PIN: ");
            String userPin = scanner.nextLine();

            isAuthenticated = authenticateUser(userId, userPin);

            if (!isAuthenticated) {
                System.out.println("Invalid User ID or PIN. Please try again.");
            }
        }

        System.out.println("Authentication successful!");
        showMenu(scanner);
    }

    private boolean authenticateUser(String userId, String userPin) {
        String storedPin = userCredentials.get(userId);
        return storedPin != null && storedPin.equals(userPin);
    }

    private void showMenu(Scanner scanner) {
        boolean quit = false;

        while (!quit) {
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    withdraw(scanner);
                    break;
                case 3:
                    deposit(scanner);
                    break;
                case 4:
                    transfer(scanner);
                    break;
                case 5:
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        System.out.println("Thank you for using the ATM. Have a Wonderfull Day!");
    }

    private void checkBalance() {
        System.out.println("Current balance: $" + balance);
    }

    private void withdraw(Scanner scanner) {
        System.out.print("Enter the amount to withdraw: $");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        if (amount > balance) {
            System.out.println("Insufficient Ballance. Unable to withdraw.");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful. Current balance: $" + balance);
        }
    }

    private void deposit(Scanner scanner) {
        System.out.print("Enter the amount to deposit: $");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        balance += amount;
        System.out.println("Deposit successful. Current balance: $" + balance);
    }

    private void transfer(Scanner scanner) {
        System.out.print("Enter the amount to transfer: $");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        if (amount > balance) {
            System.out.println("Insufficient funds. Unable to transfer.");
        } else {
            System.out.print("Enter the recipient's User ID: ");
            String recipientId = scanner.nextLine();

            if (userCredentials.containsKey(recipientId)) {
                balance -= amount;
                System.out.println("Transfer successful. Current balance: $" + balance);
            } else {
                System.out.println("Recipient User ID not found. Transfer canceled.");
            }
        }
    }
}
