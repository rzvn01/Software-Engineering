package lab4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Cacu Razvan GR-2023
 * Write a Java class that models a matrix of integer values. The dimensions and the array of elements are private
 * attributes and are controlled using appropriate setter-getter methods. Write the methods for displaying the
 * matrix, for determining and returning the number of 9 adjacent elements cells that don’t differ with more than
 * 5% from a threshold value
 */

class Matrix {

    private int[][] matrix;

    private int n;
    private int m;

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public int[][] getAdjacent(int[][] matrix, int row, int col, int threshold) {
        int[][] adjacent = new int[3][3];
        double thresholdDelta = 0.05 * threshold;
        int count = 0;
        for (int y = row - 1; y <= row + 1; y++) {
            for (int x = col - 1; x <= col + 1; x++) {
                if (x >= 0 && x < matrix[0].length && y >= 0 && y < matrix.length) {
                    int value = matrix[y][x];
                    if (Math.abs(value - matrix[row][col]) <= thresholdDelta) {
                        adjacent[y - row + 1][x - col + 1] = value;
                        count++;
                    }
                }
            }
        }
        if (count == 9) {
            return adjacent;
        } else {
            return null;
        }
    }

    public List<int[][]> findMatchingSubsets(int[][] matrix, int threshold) {
        List<int[][]> matchingSubsets = new ArrayList<>();
        for (int row = 1; row < matrix.length - 1; row++) {
            for (int col = 1; col < matrix[0].length - 1; col++) {
                int[][] subset = getAdjacent(matrix, row, col, threshold);
                if (subset != null) {
                    matchingSubsets.add(subset);
                }
            }
        }
        return matchingSubsets;
    }
}

public class Lab4Prb3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Matrix matrixInstance = new Matrix();

        int[][] matrix;
        int n, m, threshold;

        do {
            System.out.println("Please enter the number of rows (>=3):");
            n = scanner.nextInt();
            System.out.println("Please enter the number of columns(>=3) :");
            m = scanner.nextInt();
        } while (m < 3 || n < 3);

        matrix = new int[m][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.println("Enter a value for the cell [" + (i + 1) + "][" + (j + 1) + "] : ");
                matrix[i][j] = scanner.nextInt();
            }
        }

        matrixInstance.setM(m);
        matrixInstance.setN(n);
        matrixInstance.setMatrix(matrix);

        do {
            System.out.println("Please enter the value of the threshold :");
            threshold = scanner.nextInt();

        } while (threshold <= 0);

        List<int[][]> result = matrixInstance.findMatchingSubsets(matrixInstance.getMatrix(), threshold);
        if (!result.isEmpty()) {
            System.out.println("Number of matrices meeting the requirements : "+result.size());
            for (int[][] r : result) {
                list3x3Matrix(r);
            }
        } else {
            System.out.println("There are no matrices meeting the requirements ! ");
        }

    }

    private static void list3x3Matrix(int[][] matrix) {
        System.out.println("Matrix : ");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.print("\n");
        }
    }

}
