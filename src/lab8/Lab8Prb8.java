package lab8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Cacu Razvan GR-2023
 * . Write a Java application which reads a file with the following format:
 * rnd1_001.lab
 * A 0001
 * C 0003
 * D 0004
 * F 0003
 * A 0006
 * .
 * " *rnd2_002.lab
 * C 0003
 * F 0001
 * Z 0010
 * M 0011
 * .
 * …..
 * Separate the information from the file into distinct files which are named according to the line which starts with
 */
public class Lab8Prb8 {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\razvan.cacu\\Desktop\\labs SE\\src\\lab8\\input.txt"))) {
            String line;
            String fileName = "default.txt";

            while ((line = reader.readLine()) != null) {
                if (line.startsWith("*/")) {
                    fileName = line.substring(2) + ".txt";
                }
                FileWriter writer = new FileWriter(fileName, true);
                if (!line.startsWith("*/"))
                    writer.write(line + "\n");
                writer.close();
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
