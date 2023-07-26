package lab2;/*Cacu Razvan GR2023
* Verify the functionalities of the Eclipse environment considering the applications given as
examples.
* */

import java.util.Scanner;

public class Lab2Prb1 {


    public static void main(String[] args) {
        String name;
        int a, b;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your name : ");
        name = scanner.nextLine();
        System.out.println("Please enter an int number : ");
        a = scanner.nextInt();
        System.out.println("Please enter a second int number : ");
        b = scanner.nextInt();

        System.out.println("Hello " + name + "! /n The sum of the 2 numbers is :" + (a + b));

    }
}
