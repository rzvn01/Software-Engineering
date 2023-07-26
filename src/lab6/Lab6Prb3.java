package lab6;

import java.util.Scanner;

/**
 * Cacu Razvan GR-2023
 * . Define a package that declares an interface named lab6.Int1 (2 integer variables and a sum() method that returns the sum
 * of 2 integer values). Include in the same package a class named lab6.Class1 (2 protected double variables, constructor, setters
 * and getters). In another source file, add in the same package a new interface named lab6.Int2 (2 double variables and a
 * method named product() that returns the product of 2 double values).
 * Implement a distinct source file and import everything from the defined package. Define a class named lab6.Class2 that is
 * derived from lab6.Class1 and implements both interfaces lab6.Int1 and lab6.Int2.
 * Instantiate lab6.Class2 and call the defined methods for determining the sum and product of some values read from the
 * keyboard.
 */

interface Int1 {
    int a = 10, b = 20;


    default int sum() {
        return a + b;
    }
}

interface Int2 {
    double a = 5d, b = 10d;

    default double product() {
        return a * b;
    }

}

class Class1 {
    protected double a;
    protected double b;

    public Class1(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public Class1() {
        this.a = 1;
        this.b = 1;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }
}

class Class2 extends Class1 implements Int1, Int2 {


    @Override
    public int sum() {
        return Int1.super.sum();
    }

    @Override
    public double product() {
        return Int2.super.product();
    }

    public int sum(int a, int b) {
        return a+b;
    }

    public double product(double a, double b) {
        return a * b;
    }
}


public class Lab6Prb3 {
    public static void main(String[] args) {
        Class2 instance = new Class2();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Method from lab6.Int1 returns: " + instance.sum());
        System.out.println("Method from lab6.Int2 returns: " + instance.product());

        System.out.println("Value for a: ");
        instance.setA(scanner.nextDouble());

        System.out.println("Value for b: ");
        instance.setB(scanner.nextDouble());

    }


}
