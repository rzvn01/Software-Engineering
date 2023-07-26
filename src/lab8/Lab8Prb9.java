package lab8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 * Cacu Razvan GR-2023
 * Read from a text file a grayscale image represented as a matrix of integer values. The image is followed by multiple
 * convolution filters.txt (<a href="https://en.wikipedia.org/wiki/Kernel_(image_processing)">...</a>). Apply these filters.txt to the original image
 * and display both the original image, and the filtered results.
 */
public class Lab8Prb9 {
    public static void main(String[] args) {

        int[][] image = readImageFromFile("C:\\Users\\razvan.cacu\\Desktop\\labs SE\\src\\lab8\\image.txt");
        HashMap<String, int[][]> filters = readFiltersFromFile("C:\\Users\\razvan.cacu\\Desktop\\labs SE\\src\\lab8\\filters.txt", image);

        displayImage(image, "Original Image.");

        for (String key : filters.keySet()) {
            displayImage(filters.get(key), key);
        }
    }

    private static int[][] readImageFromFile(String filename) {


        int[][] image = new int[0][];
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String[] dimensions = reader.readLine().split(" ");
            int m = Integer.parseInt(dimensions[0]);
            int n = Integer.parseInt(dimensions[1]);

            image = new int[m][n];
            for (int i = 0; i < m; i++) {
                String[] row = reader.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    image[i][j] = Integer.parseInt(row[j]);
                }
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
        return image;
    }

    private static HashMap<String, int[][]> readFiltersFromFile(String filename, int[][] image) {
        HashMap<String, int[][]> filters = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            int filterSize = 0;
            String name;

            while ((line = reader.readLine()) != null) {
                name = line;
                line = reader.readLine();
                if (line != null)
                    filterSize = Integer.parseInt(line);

                int[][] filter = new int[filterSize][filterSize];
                for (int i = 0; i < filterSize; i++) {
                    String[] row = reader.readLine().split(" ");
                    for (int j = 0; j < filterSize; j++) {
                        filter[i][j] = Integer.parseInt(row[j]);
                    }
                }
                applyFilters(image, filter);
                filters.put(name, applyFilters(image, filter));
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }

        return filters;
    }

    private static int[][] applyFilters(int[][] image, int[][] filter) {
        int[][] filteredImage = new int[image.length][image[0].length];
        int filterSize = filter.length;
        int applicableAreaSize = filterSize / 2;

        for (int i = applicableAreaSize; i < image.length - applicableAreaSize; i++) {
            for (int j = applicableAreaSize; j < image[0].length - applicableAreaSize; j++) {
                int sum = 0;
                for (int k = -applicableAreaSize; k <= applicableAreaSize; k++) {
                    for (int l = -applicableAreaSize; l <= applicableAreaSize; l++) {
                        sum += image[i + k][j + l] * filter[k + applicableAreaSize][l + applicableAreaSize];
                    }
                }
                filteredImage[i][j] = Math.min(Math.max(sum, 0), 255);
            }
        }
        return filteredImage;
    }

    private static void displayImage(int[][] imageMatrix, String title) {
        int width = imageMatrix[0].length;

        System.out.println(title);

        for (int[] matrix : imageMatrix) {
            for (int x = 0; x < width; x++) {
                System.out.print(matrix[x] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
