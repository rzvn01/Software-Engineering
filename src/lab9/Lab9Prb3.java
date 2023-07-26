package lab9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Cacu Razvan GR-2023
 * Write a class for determining a certain value from Fibonacci’s array. The class has 2 methods, one for calculating and
 * the other for displaying the desired value. Use a synchronized multithreading mechanism in which one process displays
 * all the Fibonacci numbers smaller than the desired value computed by the other process.
 */
class Fibonacci {

    private final List<Integer> fibonacciNumbers = new ArrayList<>();
    private boolean sequenceComplete = false;

    public synchronized void generateFibonacciNumbersSmallerThanDesiredValue(int desiredValue) {
        int a = 0, b = 1;
        fibonacciNumbers.add(a);

        while (b < desiredValue) {
            fibonacciNumbers.add(b);
            int temp = a;
            a = b;
            b += temp;
        }

        sequenceComplete = true;
        notifyAll();
    }

    public synchronized void display() {
        while (!sequenceComplete) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.print("Fibonacci sequence: ");

        for (int i : fibonacciNumbers)
            System.out.print(i + " ");
    }
}

public class Lab9Prb3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Fibonacci fibonacci = new Fibonacci();
        int desiredValue = 100;

        Thread generateThread = new Thread(() -> fibonacci.generateFibonacciNumbersSmallerThanDesiredValue(desiredValue));
        Thread displayThread = new Thread(fibonacci::display);

        generateThread.start();
        displayThread.start();

    }

}