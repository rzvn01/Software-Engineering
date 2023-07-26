package lab2;

import java.util.Scanner;

/*Cacu Razvan lab2 prb5
Write a Java application where you can read several integers from the keypad and check
that they are prime numbers. The number of read values is taken from the KB or command
line.*/

public class Lab2prb5 {

    public static void main(String[] args) {
        int number;
        Scanner scanner = new Scanner(System.in);

        try {
            number = Integer.parseInt(args[0]);
            System.out.println("The number of values from the command line is : " + number);
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.print("The number of values in not present into the command line , please introduce the number of values : ");
            number = scanner.nextInt();
        }

        assert (number > 0);

        for (int i = 0; i < number; i++) {
            System.out.print("Please enter a number to check if it is prime : ");
            primeCheck(scanner.nextInt());
        }
    }

    public static void primeCheck(int number) {
        boolean isPrime = number > 1;

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                isPrime = false;
                break;
            }
        }

        if (isPrime)
            System.out.println("The number " + number + " is prime");
        else
            System.out.println("The number " + number + " is not prime");

    }
}

