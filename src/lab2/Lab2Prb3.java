package lab2;

import java.util.Scanner;

/*Cacu Razvan Lab2 prb 3
* Write a Java application that reads from the keyboard 2 integer values and displays the
cmmdc of the values.
*/
public class Lab2Prb3 {


    public static void main(String[] args) {
        int a, b, result;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please insert an int value : ");
        a = scanner.nextInt();

        System.out.println("Please insert the second int value : ");
        b = scanner.nextInt();
        result = greatestCommonDivisor(a, b);

        System.out.println("The GCD of numbers " + a + " & " + b + " is : " + result);
    }

    public static int greatestCommonDivisor(int a, int b) {
        if (b == 0)
            return a;
        else
            return greatestCommonDivisor(b, a % b);
    }
}
