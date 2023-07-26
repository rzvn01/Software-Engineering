package lab9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

/**
 * Cacu Razvan GR-2023
 * Write a Java application with a thread that writes some information into a file while another thread reads the written
 * data and displays it on the screen. Synchronize the threads
 */
class ReadWriteToFile {
    public static synchronized void writeData(String fileName) throws IOException {
        Scanner scanner = new Scanner(System.in);
        boolean exit = true;
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(fileName), StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
            while (exit) {
                System.out.println("Enter a line to write to the file: ");
                String data = scanner.next();
                writer.write(data);
                writer.newLine();
                writer.flush();
                System.out.println("Do you want to continue ?");
                if (scanner.next().equalsIgnoreCase("no"))
                    exit = false;

            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        scanner.close();
    }

    public static synchronized void readData(String fileName) throws IOException {
            try (BufferedReader reader = Files.newBufferedReader(Paths.get(fileName))) {
                String line;
                System.out.println("Data read from file!");
                while ((line = reader.readLine()) != null) {
                    System.out.println("Reading: " + line);
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

public class Lab9Prb6 {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the file: ");
        String name = scanner.nextLine();
        Thread writeThread = new Thread(() -> {

            try {
                ReadWriteToFile.writeData(name + ".txt");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        );
        Thread readThread = new Thread(() -> {

            try {
                ReadWriteToFile.readData(name + ".txt");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        );
        writeThread.start();
        readThread.start();

    }

}