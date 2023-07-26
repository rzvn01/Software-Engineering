package lab6;

import java.util.Scanner;

/**
 * Cacu Razvan GR-2023
 * Write a Java program that defines an array of double values and read the appropriate data from the keyboard. Handle
 * the exception produced when the code tries to acces an element that has a negative index or an index greater than the
 * maximum number of elements (ArrayIndexOutOfBoundsException). Display a significant message when the exception
 * occurs.
 * Consider a matrix with a fixed number of elements for each line and protect the code against the exception mentioned
 * above. Consider also the case if each line has a different number of elements.
 */

public class Lab6Prb1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] array;
        int length;
        System.out.println("Array length: ");
        length = scanner.nextInt();

        array = new double[length];

        for (int i = 0; i < length; i++) {
            System.out.println("Enter a double value: ");
            array[i] = scanner.nextDouble();
        }

        try {
            System.out.println("Negative index: " + array[-1]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Tried to access array with negative index !");
        }
        try {
            System.out.println("Negative index: " + array[length]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Tried to access array with index greater than the maximum number !");
        }

        int[][] matrix = {{2, 2}, {2, 2}};

        System.out.println("The initial square matrix is : ");

        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.print("\n");
        }

        try {
            System.out.println(matrix[-1][-1]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Tried to access an element with negative index !");
        }

        try {
            System.out.println(matrix[matrix.length + 1][1]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Tried to access an element with an index grater than the maximum size!");
        }

        System.out.println("Unregulated matrix:");

        int[][] mat = {{1, 2, 3}, {1, 2}};
        for (int[] ints : mat) {
            for (int value : ints) {
                System.out.print(value + " ");
            }
            System.out.print("\n");
        }

        try {
            System.out.println(mat[-1][-1]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Tried to access an element with negative index of the non-square matrix!");
        }

        try {
            System.out.println(matrix[mat.length - 1][mat.length]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Tried to access an element with an index grater than the maximum size for the non-square matrix!");
        }
    }
}