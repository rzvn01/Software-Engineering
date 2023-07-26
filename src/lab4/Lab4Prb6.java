package lab4;

import java.util.Random;
import java.util.Scanner;

/**
 * Cacu Razvan GR-2023
 * Define a one-dimensional array of char type, less than a value n introduced from the keyboard. Each value
 * contains some randomly generated alphanumerical characters. Generate a String object using the array.
 * Display the initial content of the array and after that, process all the elements so that all numbers will be
 * replaced with ‘*’. Display the result.
 */

public class Lab4Prb6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String alphabet = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        char[] charArray;
        int n;

        do {
            System.out.print("Please enter the size of the array : ");
            n = scanner.nextInt();
        }
        while (n <= 0);

        charArray = new char[n];

        for (int i = 0; i < n; i++) {
            charArray[i] = alphabet.charAt(random.nextInt(alphabet.length()));
        }

        System.out.println("Initial array :");
        System.out.println(new String(charArray));

        for (int i = 0; i < n; i++) {
            if (Character.isDigit(charArray[i])) {
                charArray[i] = '*';
            }
        }

        System.out.println("Array after replacing numbers with '*':");
        System.out.println(new String(charArray));
    }
}