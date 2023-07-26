package lab3;/*Cacu Razvan GR-2023
 Read a string from the standard input. Turn the string into a character array. Look for in this array a character
specified in the program. Display the number of occurrences .
 */

import java.util.Scanner;

public class Lab3Ex2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        char value;
        int counter = 0;

        System.out.println("Please enter a string : ");
        input = scanner.nextLine();

        char[] array = input.toCharArray();
        System.out.println("Enter the character you want to get the number of occurrences for :");
        value = scanner.nextLine().charAt(0);

        for (char iterator : array) {
            if (iterator == value)
                counter++;
        }

        System.out.println("The number of occurrences for the char  \""+ value + "\" into the string \"" + input + "\"is : "+ counter);
    }
}
