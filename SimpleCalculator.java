import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * A simple command-line calculator that supports basic arithmetic operations.
 * Designed as part of the Coding Samurai Java Internship project.
 * Author: Himanshu Garg
 * Date: July 2025
 */

public class SimpleCalculator {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        displayWelcomeMessage();

        while (true) {
            printMenu();
            int choice = getUserChoice();

            if (choice == 5) {
                System.out.println("Thank you for using the calculator. Stay curious!");
                break;
            }

            double num1 = getNumber("Enter the first number: ");
            double num2 = getNumber("Enter the second number: ");
            performOperation(choice, num1, num2);
        }

        scanner.close();
    }

    private static void displayWelcomeMessage() {
        System.out.println("======================================");
        System.out.println("     Welcome to Java SmartCalc!      ");
        System.out.println("   Designed by Himanshu for Coding   ");
        System.out.println("          Samurai Internship         ");
        System.out.println("======================================\n");
    }

    private static void printMenu() {
        System.out.println("Choose an operation:");
        System.out.println("1 → Addition (+)");
        System.out.println("2 → Subtraction (-)");
        System.out.println("3 → Multiplication (×)");
        System.out.println("4 → Division (÷)");
        System.out.println("5 → Exit");
        System.out.print("Enter your choice (1-5): ");
    }

    private static int getUserChoice() {
        int choice = -1;
        while (choice < 1 || choice > 5) {
            try {
                choice = scanner.nextInt();
                if (choice < 1 || choice > 5) {
                    System.out.print("Invalid choice. Please enter a number between 1 and 5: ");
                }
            } catch (InputMismatchException e) {
                System.out.print("Please enter a valid number: ");
                scanner.next(); // Clear the invalid input
            }
        }
        return choice;
    }

    private static double getNumber(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextDouble()) {
            System.out.print("Invalid input. Please enter a numeric value: ");
            scanner.next(); // discard invalid input
        }
        return scanner.nextDouble();
    }

    private static void performOperation(int choice, double num1, double num2) {
        double result;
        switch (choice) {
            case 1:
                result = num1 + num2;
                System.out.printf("Result: %.2f + %.2f = %.2f%n%n", num1, num2, result);
                break;
            case 2:
                result = num1 - num2;
                System.out.printf("Result: %.2f - %.2f = %.2f%n%n", num1, num2, result);
                break;
            case 3:
                result = num1 * num2;
                System.out.printf("Result: %.2f × %.2f = %.2f%n%n", num1, num2, result);
                break;
            case 4:
                if (num2 == 0) {
                    System.out.println("Error: Division by zero is undefined.\n");
                } else {
                    result = num1 / num2;
                    System.out.printf("Result: %.2f ÷ %.2f = %.2f%n%n", num1, num2, result);
                }
                break;
            default:
                System.out.println("Unexpected error occurred.\n");
        }
    }
}