package lab9;

import java.math.BigInteger;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Cacu Razvan GR-2023
 * Write a Java app which computes the greatest common divisor for large numbers (>100.000). The app will continuosly
 * read from the keyboard pairs of numbers and launch threads for each of the pairs. The results will be displayed in the
 * console as soon as they are available
 */
class Pair {
    BigInteger num1;
    BigInteger num2;
    BigInteger gcd;

    Pair(BigInteger num1, BigInteger num2, BigInteger gcd) {
        this.num1 = num1;
        this.num2 = num2;
        this.gcd = gcd;
    }
}

public class Lab9Prb5 {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();
        ExecutorCompletionService<Pair> completionService = new ExecutorCompletionService<>(executor);
        Scanner scanner = new Scanner(System.in);
        BlockingQueue<Pair> resultsQueue = new LinkedBlockingQueue<>();

        System.out.println("Enter pairs of numbers separated by a space. Enter 'exit' to quit.");

        Thread computeResultsThread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    Future<Pair> completedResult = completionService.take();
                    Pair pair = completedResult.get();
                    resultsQueue.put(pair);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        computeResultsThread.start();

        while(true){
            System.out.print("Enter a pair of numbers: ");
            String input = scanner.nextLine();

            if ("exit".equalsIgnoreCase(input)) {
                break;
            }

            while (!resultsQueue.isEmpty()) {
                Pair pair = resultsQueue.poll();
                System.out.println("GCD of " + pair.num1 + " and " + pair.num2 + " is: " + pair.gcd);
            }

            String[] numbers = input.split(" ");
            if (numbers.length != 2) {
                System.out.println("Invalid input. Please enter two numbers separated by a space.");
                continue;
            }

            try {
                BigInteger num1 = new BigInteger(numbers[0]);
                BigInteger num2 = new BigInteger(numbers[1]);

                completionService.submit(() -> new Pair(num1, num2, gcd(num1, num2)));
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter valid numbers.");
            }
        }

        computeResultsThread.interrupt();
        computeResultsThread.join();
        executor.shutdown();
        scanner.close();
    }

    private static BigInteger gcd(BigInteger a, BigInteger b) {
        return a.gcd(b);
    }

}