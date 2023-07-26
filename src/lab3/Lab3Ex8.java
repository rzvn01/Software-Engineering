package lab3;

import java.util.Scanner;

/*Cacu Razvan GR-2023
Read from the keyboard the elements of a matrix of integer values with m lines (m taken from the command
line). For each line the number of elements will increase by 1 compared to the previous line, the first line having
only one element.
Implement the methods that:
- display the matrix, line by line and column by column;
- eliminate from the matrix (turns into 0) the values that are outside the interval defined by 2 specified limits;
- display the existent neighbour values of an element identified by its indexes (sent as parameters);
 */
public class Lab3Ex8 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] array = new int[0][];
        int m = 0, lowerLimit, upperLimit;

        try {
            m = Integer.parseInt(args[0]);
            array = new int[m][];
            for (int i = 0; i < m; i++) {
                array[i] = new int[i + 1];
            }
        } catch (ArrayIndexOutOfBoundsException r) {
            System.out.println("You need a value for m in the command line arguments !");
            System.exit(3);
        }
        readArrayFromKeyboard(array, m);
        System.out.println("The array printed row by row  :");
        printArrayRowByRow(array, m);
        System.out.println("The array printed column by column :");
        printArrayColumnByColumn(array, m);

        System.out.println("Please provide the lower limit : ");
        lowerLimit = scanner.nextInt();
        System.out.println("Please provide the upper limit : ");
        upperLimit = scanner.nextInt();

        eliminateValuesOutsideRange(array, m, lowerLimit, upperLimit);
        System.out.println("The array after eliminating the values outside the limits : ");
        printArrayRowByRow(array, m);

        System.out.println("Please enter the index of the value you want to get the neighbours for : ");
        lowerLimit = scanner.nextInt();
        upperLimit = scanner.nextInt();
        printNeighbors(array, lowerLimit, upperLimit);
    }

    public static void readArrayFromKeyboard(int[][] array, int m) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.print("Enter a value : ");
                array[i][j] = scanner.nextInt();
            }
        }
    }

    public static void printArrayRowByRow(int[][] array, int m) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void printArrayColumnByColumn(int[][] array, int m) {
        int maxColumns = array[m - 1].length;
        for (int j = 0; j < maxColumns; j++) {
            for (int i = 0; i < m; i++) {
                if (j < array[i].length) {
                    System.out.print(array[i][j] + " ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    public static void eliminateValuesOutsideRange(int[][] array, int m, int lowerLimit, int upperLimit) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < i + 1; j++) {
                if (array[i][j] < lowerLimit || array[i][j] > upperLimit) {
                    array[i][j] = 0;
                }
            }
        }
    }

    public static void printNeighbors(int[][] arr, int row, int col) {
        int numRows = arr.length;
        if (row >= numRows || col >= arr[row].length) {
            System.out.println("Invalid index!");
            System.exit(2);
        }

        System.out.print("Neighbors for " +arr[row][col]+" are : ");

        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if (i >= 0 && i < numRows && j >= 0 && j < arr[i].length && !(i == row && j == col)) {
                    System.out.print(arr[i][j] + " ");
                }
            }
        }

        System.out.println();
    }
}
