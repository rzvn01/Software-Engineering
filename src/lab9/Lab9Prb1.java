package lab9;

import java.util.Scanner;

/**Cacu Razvan GR-2023
 *  Write a Java application which contains a class which implements the Runnable interface. The class' constructor sets
 * the name of the instantiated object. Also, there is a class variable which counts the number of instantiated objects from
 * that class. The run( ) method of the class will print the object's name for a number of times equal to the counter's value,
 * each printing being delayed 1000 msec.
 * In a distinct class, create multiple threads built from separate objects of the previously described class. Analyze the
 * results.
 */
class Run implements Runnable {
    private String name;
    private static int count = 0;

    public Run(String name) {
        this.name = name;
        count++;
    }

    @Override
    public void run() {
        synchronized(this) {
            for (int i = 0; i < count; i++) {
                System.out.println("Instance name: " + this.name);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Could not wait: " + e.getMessage());
                }
            }
        }
    }
}

public class Lab9Prb1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number;
        do {
            System.out.println("How many instances to be created ?");
            number = scanner.nextInt();
        }
        while (number <= 0);

        for (int i = 0; i < number; i++) {
            System.out.println("Enter the name of a new instance");
            String name = scanner.next();
            Run run = new Run(name);
            new Thread(run).start();
        }
    }
}