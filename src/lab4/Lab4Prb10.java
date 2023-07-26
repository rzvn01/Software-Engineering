package lab4;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Cacu Razvan GR-2023
 * mplement a class named Circle with the private attributes color (int), radius (float), planar position (2 integer).
 * Define the specific constructors and setter getter methods. The color is divided in 4 bytes, each of them
 * representing the transparency and the quantities of R, G and B.
 * In the main method (included in another class), read from the keyboard the data for n Circle objects.
 * Implement the methods that receive as parameter the array of objects and display:
 * - the circles whose center is included in one of the 4 quadrants
 * - the circles that are included entirely in one of the 4 quadrants
 * - the circles that have the centers on the same horizontal or vertical line
 * - the circles that have the R, G or B quantities in a certain specified interval
 */

class Circle {
    private int color;
    private float radius;
    private int[] position = new int[2];

    public Circle(int color, float radius, int[] position) {
        this.color = color;
        this.radius = radius;
        this.position = position;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public int[] getPosition() {
        return position;
    }

    public void setPosition(int[] position) {
        this.position = position;
    }

    public boolean isCenterInQuadrant(int quadrant) {
        int[] position = getPosition();
        switch (quadrant) {
            case 1:
                return position[0] >= 0 && position[1] >= 0;
            case 2:
                return position[0] < 0 && position[1] >= 0;
            case 3:
                return position[0] < 0 && position[1] < 0;
            case 4:
                return position[0] >= 0 && position[1] < 0;
            default:
                return false;
        }
    }

    public boolean isEntirelyInQuadrant(int quadrant) {
        int[] position = getPosition();
        float radius = getRadius();
        int maxX = position[0] + (int) radius;
        int maxY = position[1] + (int) radius;

        switch (quadrant) {
            case 1:
                return position[0] >= 0 && position[1] >= 0 && maxX <= 0 && maxY <= 0;
            case 2:
                return position[0] < 0 && position[1] >= 0 && maxX <= 0 && maxY <= 0;
            case 3:
                return position[0] < 0 && position[1] < 0 && maxX <= 0 && maxY <= 0;
            case 4:
                return position[0] >= 0 && position[1] < 0 && maxX <= 0 && maxY <= 0;
            default:
                return false;
        }
    }

    public static void displayCirclesInQuadrants(Circle[] circles) {
        for (Circle circle : circles) {
            for (int quadrant = 1; quadrant <= 4; quadrant++) {
                if (circle.isCenterInQuadrant(quadrant)) {
                    System.out.println("Circle " + (Arrays.asList(circles).indexOf(circle) + 1) + " is in quadrant " + quadrant);
                    break;
                }
            }
        }
    }

    public static void displayCirclesEntirelyInQuadrants(Circle[] circles) {
        for (Circle circle : circles) {
            for (int quadrant = 1; quadrant <= 4; quadrant++) {
                if (circle.isEntirelyInQuadrant(quadrant)) {
                    System.out.println("Circle " + (Arrays.asList(circles).indexOf(circle) + 1) + " is entirely in quadrant " + quadrant);
                    break;
                }
            }
        }
    }

    public boolean isCenterOnLine(int[] line) {
        int[] position = getPosition();
        return position[0] == line[0] && position[1] == line[1];
    }

    public boolean isColorInInterval(int[] interval) {
        int color = getColor();
        int red = (color >> 16) & 0xFF;
        int green = (color >> 8) & 0xFF;
        int blue = color & 0xFF;
        return (red >= interval[0] && red <= interval[1])
                || (green >= interval[0] && green <= interval[1])
                || (blue >= interval[0] && blue <= interval[1]);
    }

    public static void displayCirclesOnLine(Circle[] circles, int[] line) {
        for (Circle circle : circles) {
            if (circle.isCenterOnLine(line)) {
                System.out.println("Circle " + (Arrays.asList(circles).indexOf(circle) + 1) + " has its center on line " + Arrays.toString(line));
            }
        }
    }

    public static void displayCirclesInColorInterval(Circle[] circles, int[] interval) {
        for (Circle circle : circles) {
            if (circle.isColorInInterval(interval)) {
                System.out.println("Circle " + (Arrays.asList(circles).indexOf(circle) + 1) + " has R, G, or B value in the interval " + Arrays.toString(interval));
            }
        }
    }
}

public class Lab4Prb10 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of Circle objects: ");
        int n = input.nextInt();
        Circle[] circles = new Circle[n];

        for (int i = 0; i < n; i++) {
            System.out.println(" Circle " + (i + 1) + ":");
            System.out.print("Color (in hex): ");
            int color = Integer.parseInt(input.next());
            System.out.print("Radius: ");
            float radius = input.nextFloat();
            System.out.print("Position (x y): ");
            int[] position = {input.nextInt(), input.nextInt()};
            circles[i] = new Circle(color, radius, position);
        }

        Circle.displayCirclesInQuadrants(circles);
        System.out.println();

        Circle.displayCirclesEntirelyInQuadrants(circles);
        System.out.println();

        System.out.print("Line (x y) to check the  circles: ");
        int[] line = {input.nextInt(), input.nextInt()};
        Circle.displayCirclesOnLine(circles, line);
        System.out.println();

        System.out.print("Interval (min max) to check the color values: ");
        int[] interval = {input.nextInt(), input.nextInt()};
        Circle.displayCirclesInColorInterval(circles, interval);
    }
}
