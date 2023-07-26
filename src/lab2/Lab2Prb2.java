package lab2;

import java.util.Scanner;

/*Cacu Razvan Lab 1 Ex 2 GR-2023
   Write a Java application where you read from the keyboard an int value and the factorial of
        the number read, is displayed.*/
public class Lab2Prb2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please insert an int value : ");

        int value = scanner.nextInt();
        int result = factorial(value);

        System.out.println("The factorial of the number " + value + " is : " + result);
    }

    public static int factorial(int number) {
        if (number == 1)
            return 1;
        else
            return number * factorial(number - 1);

    }

}