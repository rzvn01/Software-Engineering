package lab8;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Cacu Razvan GR-2023
 * Write a Java application which enables the serialization and deserialization of objects that represent arrays of int
 * values. Populate an object with keyboard entered data, order the values and store the object in a file. Read the file and
 * display the reconstructed array of values.
 */

public class Lab8Prb7 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileName = "serialized_array.ser";
        int size;

        System.out.print("Enter array size: ");
         size = scanner.nextInt();
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
        }

        Arrays.sort(array);

        serializeArray(array, fileName);

        int[] deserializedArray = deserializeArray(fileName);
        System.out.println("Deserialized array: " + Arrays.toString(deserializedArray));
    }

    public static void serializeArray(int[] array, String fileName) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeObject(array);
            System.out.println("Array serialized to " + fileName);
        } catch (IOException exception) {
            System.out.println("Error: "+ exception.getMessage());
        }
    }

    public static int[] deserializeArray(String fileName) {
        int[] array = null;

        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            array = (int[]) inputStream.readObject();
        } catch (IOException | ClassNotFoundException exception) {
            System.out.println("Error: "+ exception.getMessage());
        }
        return array;
    }
}

