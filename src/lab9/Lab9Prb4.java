package lab9;


/**
 * Cacu Razvan GR-2023
 * . Write a Java app which uses the synchronized method acces for mutual exclusion. Create 3 separate threads which
 * simultaneously call methods to increment and decrement a separate class' class variable. Check if the results are what
 * you expect them to be. Remove the synchronized blocks and reevaluate the results.
 */

class Counter {
    private static int count = 0;

    public static synchronized void increment() {
        count++;
        System.out.println("Incremented counter to: " + count);
    }

    public static synchronized void decrement() {
        count--;
        System.out.println("Decremented counter to: " + count);
    }
}

class IncrementThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            Counter.increment();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


class DecrementThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            Counter.decrement();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Lab9Prb4 {

    public static void main(String[] args) {
        IncrementThread incrementThread = new IncrementThread();
        DecrementThread decrementThread = new DecrementThread();
        IncrementThread incrementThread1 = new IncrementThread();

        incrementThread.start();
        decrementThread.start();
        incrementThread1.start();

    }
}