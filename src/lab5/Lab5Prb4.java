package lab5;

import java.util.Scanner;

/**
 * Cacu Razvan GR-2023
 * Consider the Fraction class that has two protected attributes a and b for the counter and denominator, two set () and
 * get () methods for each of the class attributes. Define an explicit constructor without parameters that initiates a with 0
 * and b with 1, and an explicit constructor with two parameters that can be called if it is checked whether a fraction can
 * be defined (b! = 0). Define a method simplify () that simplifies and returns a Fraction object by calling the int
 * greatestCommonDivider (int, int) method (based on divisions). Define a method for adding two Fraction objects, which
 * returns a Fraction object. Define a ExtendedFraction class derived from Fraction, which will have a constructor with
 * parameters (which calls the constructor from the base class) and which will redefine the method simplify() using an int
 * greatestCommonDivider (int, int) algorithm based on subtractions. Add a method for subtracting two fractions.
 * Instantiate two Fraction objects without parameters. Set the attributes of the data objects read from the keyboard.
 * Display the original attributes of the objects and the new defined attributes. Simplify, add and display results. Instantiate
 * two ExtendedFraction objects with data read from the keyboard. Simplify, add and subtract objects and display results.
 * Make an upcast from ExtendedFraction to Fraction and try to subtract the items. All operations will be called from the
 * main() method.
 */


class Fraction {
    protected int a;
    protected int b;

    public Fraction() {
        a = 0;
        b = 1;
    }

    public Fraction(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("b cannot be 0");
        }
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        if (b == 0) {
            throw new IllegalArgumentException("b cannot be 0!");
        }
        this.b = b;
    }

    public Fraction simplify() {
        int gcd = greatestCommonDivider(a, b);
        return new Fraction(a / gcd, b / gcd);
    }

    public Fraction add(Fraction other) {
        int newA = a * other.getB() + b * other.getA();
        int newB = b * other.getB();
        return new Fraction(newA, newB).simplify();
    }

    private int greatestCommonDivider(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return greatestCommonDivider(b, a % b);
        }
    }
}

class ExtendedFraction extends Fraction {

    public ExtendedFraction(int a, int b) {
        super(a, b);
    }

    @Override
    public ExtendedFraction simplify() {
        int gcd = greatestCommonDivider(a, b);
        a /= gcd;
        b /= gcd;
        return this;
    }

    public ExtendedFraction subtract(ExtendedFraction other) {
        int newA = a * other.getB() - b * other.getA();
        int newB = b * other.getB();
        return new ExtendedFraction(newA, newB).simplify();
    }

    private int greatestCommonDivider(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}

public class
Lab5Prb4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Fraction f1 = new Fraction();
        Fraction f2 = new Fraction();

        System.out.print("Nominator for fraction 1: ");
        f1.setA(scanner.nextInt());
        System.out.print("Dominator for fraction 1: ");
        f1.setB(scanner.nextInt());
        System.out.print("Nominator for fraction 2: ");
        f2.setA(scanner.nextInt());
        System.out.print("Dominator for fraction 2: ");
        f2.setB(scanner.nextInt());

        System.out.println("Original attributes:");
        System.out.println("Fraction 1: " + f1.getA() + "/" + f1.getB());
        System.out.println("Fraction 2: " + f2.getA() + "/" + f2.getB());

        Fraction sum = f1.add(f2);
        System.out.println("Sum: " + sum.getA() + "/" + sum.getB());

        ExtendedFraction ef1 = new ExtendedFraction(f1.getA(), f1.getB());
        ExtendedFraction ef2 = new ExtendedFraction(f2.getA(), f2.getB());

        System.out.println("ExtendedFraction:");
        System.out.println("Original attributes:");
        System.out.println("ef1: " + ef1.getA() + "/" + ef1.getB());
        System.out.println("ef2: " + ef2.getA() + "/" + ef2.getB());
        ef1.simplify();
        ef2.simplify();
        System.out.println("Simplified attributes:");
        System.out.println("ef1: " + ef1.getA() + "/" + ef1.getB());
        System.out.println("ef2: " + ef2.getA() + "/" + ef2.getB());

        try {
            ExtendedFraction sum2 = (ExtendedFraction) ef1.add(ef2);
            System.out.println("Sum: " + sum2.getA() + "/" + sum2.getB());
        } catch (ClassCastException e) {
            System.out.println("Cannot subtract !");
        }

        ExtendedFraction diff = ef1.subtract(ef2);
        System.out.println("Difference: " + diff.getA() + "/" + diff.getB());

        Fraction diff2 = ((Fraction) ef1).add((Fraction) ef2);
        System.out.println("Upcast and subtract: " + diff2.getA() + "/" + diff2.getB());
    }
}
