package lab4;

import java.util.Scanner;

/**
 * Cacu Razvan GR-2023
 * Write a Java application which defines an authentication key with the format: XXXXX-XXXXX-XXXXX-XXXXX,
 * where X is a character which can be either a digit or a letter. The application should verify if this key has exactly
 * 4 groups of characters with 5 characters each, and separated by the symbol ‘-‘. Also, compute the number of
 * digits and letters from the authentication key. The number of digits should be greater than the number of
 * letters, and the number of letters cannot be 0.
 * If any of the above conditions are not met, display the message: “Invalid authentication key!”
 */
public class Lab4Prb8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Authentication key: ");
        String key = scanner.nextLine();

        if (firstCheck(key) && secondCheck(key))
            System.out.println("Authentication key is valid.");
        else
            System.out.println("Invalid authentication key!");
    }

    public static boolean firstCheck(String key) {
        String[] groups = key.split("-");
        return groups.length == 4 && groups[0].length() == 5 && groups[1].length() == 5 && groups[2].length() == 5 && groups[3].length() == 5;
    }

    public static boolean secondCheck(String key) {
        int digits = 0;
        int letters = 0;
        for (char c : key.toCharArray()) {
            if (Character.isDigit(c)) {
                digits++;
            } else if (Character.isLetter(c)) {
                letters++;
            }
        }

        return digits > letters && letters != 0;
    }
}