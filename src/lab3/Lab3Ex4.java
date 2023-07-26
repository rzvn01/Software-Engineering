package lab3;

import java.util.Scanner;

/*Cacu Razvan GR-2023
  Write a Java application which defines an integer value and displays it as a binary, octal and hexadecimal string.
Write various bases conversion methods.
*/
public class Lab3Ex4 {
    public static void main(String[] args){
        Scanner scanner=  new Scanner(System.in);
        System.out.print("Please enter the integer value you want to convert : ");
        int value = scanner.nextInt();

        System.out.println("The number "+value + " converted into binary is " +toBinary(value));
        System.out.println("The number "+value + " converted into octal is 0o" +toOctal(value));
        System.out.println("The number "+value + " converted into hex is 0x" +toHex(value));
    }

    public static String toBinary(int value) {
        StringBuilder result = new StringBuilder();
        int mask = 1;

        while (mask <= value) {
            if ((value & mask) != 0) {
                result.insert(0, '1');
            } else {
                result.insert(0, '0');
            }
            mask <<= 1;
        }

        if (result.length() == 0) {
            result.append('0');
        }

        return result.toString();
    }

    public static String toOctal(int value) {
        StringBuilder result = new StringBuilder();

        do {
            int remainder = value % 8;
            result.insert(0, remainder);
            value /= 8;
        } while (value > 0);

        return result.toString();
    }
    public static String toHex(int value) {
        StringBuilder result = new StringBuilder();

        do {
            int remainder = value % 16;
            char digit;
            if (remainder < 10) {
                digit = (char) ('0' + remainder);
            } else {
                digit = (char) ('A' + remainder - 10);
            }
            result.insert(0, digit);
            value /= 16;
        } while (value > 0);

        return result.toString();
    }
}
