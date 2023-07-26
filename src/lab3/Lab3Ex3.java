package lab3;/*Cacu Razvan GR-2023
 Starting from the previous problem, copy the first 3 characters of the array to another array and display the
obtained result(use the arraycopy () method from the System class).
 * */


import java.util.Arrays;
import java.util.Scanner;

public class Lab3Ex3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        char[] result = new char[3];

        System.out.println("Please enter a string : ");
        input = scanner.nextLine();

        char[] array = input.toCharArray();
        System.arraycopy(array, 0, result, 0, 3);

        System.out.println("The result of arraycopy method  with the length 3 is : " + Arrays.toString(result));
    }
}
