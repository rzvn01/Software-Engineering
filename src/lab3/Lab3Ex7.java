package lab3;/*Cacu Razvan GR-2023
 Read from the keyboard an integer value bigger than 16.777.216. Use bit masks for isolating each of the 4 bytes
of the read value. Display the initial and the isolated values as decimal, binary and hexadecimal strings.
 */

import java.util.Scanner;

public class Lab3Ex7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int value = 0;
        do {
            System.out.print("Please enter an integer number bigger than 16.777.216 :  ");
            value = scanner.nextInt();
        }while (value <16777216);


        int byte1 = (value >> 24) & 0xFF;
        int byte2 = (value >> 16) & 0xFF;
        int byte3 = (value >> 8) & 0xFF;
        int byte4 = value & 0xFF;

        System.out.println("The value is : " + value);
        System.out.println("The first byte is : " + byte1 + ", binary value : " + Integer.toBinaryString(byte1) + ", hex value : " + Integer.toHexString(byte1));
        System.out.println("The second byte is : " + byte2 + ", binary value : " + Integer.toBinaryString(byte2) + ", hex value : " + Integer.toHexString(byte2));
        System.out.println("The third byte is : " + byte3 + ", binary value : " + Integer.toBinaryString(byte3) + ", hex value : " + Integer.toHexString(byte3));
        System.out.println("The fourth byte is : " + byte4 + ", binary value : " + Integer.toBinaryString(byte4) + ", hex value : " + Integer.toHexString(byte4));


    }
}
