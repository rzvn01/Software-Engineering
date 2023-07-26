package lab5;

import java.util.Scanner;

/**
 * Cacu Razvan GR-2023
 * . Develop a class hierarchy of shapes and write a program that computes the amount of paint needed to paint different
 * objects. The hierarchy will consist of a parent class Shape with three derived classes - Sphere, Rectangle, and Cylinder.
 * For the purposes of this exercise, the only attribute a shape will have is a name and the method of interest will be one
 * that computes the area of the shape (surface area in the case of three-dimensional shapes). Do the following.
 * A. Write an abstract class Shape with the following members:
 * - an instance variable shapeName of String type
 * - an abstract method area()
 * - a toString() method that returns the name of the shape
 * B. The file Sphere.java contains the Sphere class which is a descendant of Shape. A sphere has a radius as a private
 * integer variable and implements the body of the inherited abstract method area().
 * C. Define similar classes for a rectangle and a cylinder. The classes Rectangle and Cylinder are also derived from the
 * Shape class. A rectangle is defined by its length and width. A cylinder is defined by a radius and height.
 * Note: Each of the derived classes override the toString method and define specific mutator and accessor methods.
 * D. The file Paint.java contains an interface that has a float constant paintPerSurfaceUnit.
 * E. The file PaintThings.java implements the Paint interface and contains a program that computes the amount of paint
 * needed to paint various shapes.
 * Instantiate the three shape objects: deck <- Rectangle, bigBall <- Sphere and tank <- Cylinder. Make the appropriate
 * method calls to assign each object’s specific attributes with data read from the keyboard.
 * Compute the amount of paint needed for covering each created shape.
 */

abstract class Shape {
    protected String shapeName;

    public Shape(String name) {
        this.shapeName = name;
    }

    public abstract float area();

    @Override
    public String toString() {
        return shapeName;
    }
}

class Sphere extends Shape {
    private int radius;

    public Sphere(String name, int radius) {
        super(name);
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public float area() {
        return (float) (4 * Math.PI * radius * radius);
    }

    @Override
    public String toString() {
        return "Sphere: " + super.toString();
    }
}

class Rectangle extends Shape {
    private int length;
    private int width;

    public Rectangle(String name, int length, int width) {
        super(name);
        this.length = length;
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public float area() {
        return (float) (length * width);
    }

    @Override
    public String toString() {
        return "Rectangle: " + super.toString();
    }
}

class Cylinder extends Shape {
    private int radius;
    private int height;

    public Cylinder(String name, int radius, int height) {
        super(name);
        this.radius = radius;
        this.height = height;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public float area() {
        return (float) (2 * Math.PI * radius * height + 2 * Math.PI * radius * radius);
    }

    @Override
    public String toString() {
        return "Cylinder: " + super.toString();
    }
}

interface Paint {
    float paintPerSurfaceUnit = 2.5f;

}

public class Lab5Prb3 implements Paint {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter length for the rectangle:");
        int length = input.nextInt();
        System.out.println("Enter width for the rectangle:");
        int width = input.nextInt();
        Rectangle deck = new Rectangle("Deck", length, width);
        float deckPaint = deck.area() * paintPerSurfaceUnit;

        System.out.println("Enter radius for the sphere:");
        int radius = input.nextInt();
        Sphere bigBall = new Sphere("Big Ball", radius);
        float bigBallPaint = bigBall.area() * paintPerSurfaceUnit;

        System.out.println("Enter radius for the cylinder:");
        radius = input.nextInt();
        System.out.println("Enter height for the cylinder:");
        int height = input.nextInt();
        Cylinder tank = new Cylinder("Tank", radius, height);
        float tankPaint = tank.area() * paintPerSurfaceUnit;

        System.out.println("Amount of paint required per unit: " + paintPerSurfaceUnit);

        System.out.println("Amount of paint needed for the deck: " + deckPaint);
        System.out.println("Amount of paint needed for the big ball: " + bigBallPaint);
        System.out.println("Amount of paint needed for the tank: " + tankPaint);

        float totalPaint = deckPaint + bigBallPaint + tankPaint;
        System.out.println("Total amount of paint needed: " + totalPaint);
    }

}
