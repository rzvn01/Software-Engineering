package lab3;

import java.util.Random;

/*Cacu Razvan GR2023
Write a Java program that generates 2 random values and performs some mathematical operations on them.
*/
public class Lab3Ex6 {
    public static void main(String[] args) {
        Random rand = new Random();
        int a = rand.nextInt(100);
        int b = rand.nextInt(100);

        System.out.println("a = " + a);
        System.out.println("b = " + b);


        System.out.println("Sum = " + (a+b));
        System.out.println("Difference = " + (a-b));
        System.out.println("Product = " + (a*b));
        System.out.println("Quotient = " + (a/b));
        System.out.println("Remainder = " + (a%b));

}
}
