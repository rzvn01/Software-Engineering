package lab2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
*Cacu Razvan lab2 prb4
* Write a Java application where you read from the keyboard an integer and display all the
dividers of the number you read .*/
public class Lab2Prb4 {

    public static void main(String[] args) {
        int number;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please insert an int number : ");
        number = scanner.nextInt();

        List<Integer> dividers = dividers(number);

        if (dividers.size() == 1) {
            System.out.println("The number " + number + " is a prime number and the single divisors are 1 and the number itself ");
        } else {
            System.out.print("The divisors of number " + number + " are : " + dividers);
        }

    }

    public static List<Integer> dividers(int number) {

        List<Integer> listOfDividers = new ArrayList<>();
        for (int i = 1; i <= number / 2; i++)
            if (number % i == 0)
                listOfDividers.add(i);

        return listOfDividers;

    }
}
