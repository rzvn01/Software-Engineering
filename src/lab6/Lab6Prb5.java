package lab6;

import java.util.Scanner;

/**
 * Cacu Razvan GR-2023
 * Write an application which checks if 3 random points form an obtuse triangle. If the condition is not met, a specific
 * exception is thrown: lab6.AcuteTriangle, lab6.RightTriangle. If the 3 points are on the same line or if the segments determined by
 * the 3 points cannot make up a triangle, throw an ObstuseTriangle exception, and within the corresponding catch
 * block print a warning and throw a RuntimeException.
 */
class Point {
    private double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}

class AcuteTriangle extends Exception {
    public AcuteTriangle() {
        super("The points form an acute triangle.");
    }
}

class RightTriangle extends Exception {
    public RightTriangle() {
        super("The points form a right triangle.");
    }
}

class ImpossibleTriangle extends Exception {
    public ImpossibleTriangle() {
        super("The points cannot form a triangle.");
    }
}

class ObtuseTriangle extends Exception {
    public ObtuseTriangle() {
        super("The points form an obtuse triangle.");
    }
}

public class Lab6Prb5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter x coordinate of first point: ");
        double x1 = scanner.nextDouble();
        System.out.print("Enter y coordinate of first point: ");
        double y1 = scanner.nextDouble();
        Point p1 = new Point(x1, y1);

        System.out.print("Enter x coordinate of second point: ");
        double x2 = scanner.nextDouble();
        System.out.print("Enter y coordinate of second point: ");
        double y2 = scanner.nextDouble();
        Point p2 = new Point(x2, y2);

        System.out.print("Enter x coordinate of third point: ");
        double x3 = scanner.nextDouble();
        System.out.print("Enter y coordinate of third point: ");
        double y3 = scanner.nextDouble();
        Point p3 = new Point(x3, y3);

        try {
            checkTriangle(p1, p2, p3);
        } catch (AcuteTriangle e) {
            System.out.println("Caught lab6.AcuteTriangle: " + e.getMessage());
        } catch (RightTriangle e) {
            System.out.println("Caught lab6.RightTriangle: " + e.getMessage());
        } catch (ObtuseTriangle e) {
            System.out.println("Caught lab6.ObtuseTriangle: " + e.getMessage());
            System.out.println("Warning: Points form a Obtuse triangle!.");
            throw new RuntimeException();
        } catch (ImpossibleTriangle e) {
            System.out.println("Caught lab6.ImpossibleTriangle: " + e.getMessage());
        }
    }

    public static void checkTriangle(Point p1, Point p2, Point p3) throws AcuteTriangle, RightTriangle, ObtuseTriangle, ImpossibleTriangle {
        double a = Math.sqrt(Math.pow(p1.getX() - p2.getX(), 2) + Math.pow(p1.getY() - p2.getY(), 2));
        double b = Math.sqrt(Math.pow(p2.getX() - p3.getX(), 2) + Math.pow(p2.getY() - p3.getY(), 2));
        double c = Math.sqrt(Math.pow(p3.getX() - p1.getX(), 2) + Math.pow(p3.getY() - p1.getY(), 2));

        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new ImpossibleTriangle();
        }

        double cosA = (b * b + c * c - a * a) / (2 * b * c);
        double cosB = (c * c + a * a - b * b) / (2 * c * a);
        double cosC = (a * a + b * b - c * c) / (2 * a * b);

        if (cosA < 0 || cosB < 0 || cosC < 0) {
            throw new ObtuseTriangle();
        } else if (cosA == 0 || cosB == 0 || cosC == 0) {
            throw new RightTriangle();
        } else {
            throw new AcuteTriangle();
        }
    }
}
