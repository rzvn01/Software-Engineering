package lab5.v2;

import java.util.Scanner;

 interface GeometricForm {
    double getArea();
    double getPerimeter();
}

class Square implements GeometricForm {
    private double sideLength;

    public Square(double sideLength) {
        this.sideLength = sideLength;
    }

    public double getArea() {
        return sideLength * sideLength;
    }

    public double getPerimeter() {
        return 4 * sideLength;
    }
}

class Rectangle implements GeometricForm {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double getArea() {
        return length * width;
    }

    public double getPerimeter() {
        return 2 * (length + width);
    }
}

class Circle implements GeometricForm {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
}

class EquilateralTriangle implements GeometricForm {
    private double sideLength;

    public EquilateralTriangle(double sideLength) {
        this.sideLength = sideLength;
    }

    public double getArea() {
        return (Math.sqrt(3) / 4) * sideLength * sideLength;
    }

    public double getPerimeter() {
        return 3 * sideLength;
    }
}

class IsoscelesTriangle implements GeometricForm {
    private double baseLength;
    private double legLength;

    public IsoscelesTriangle(double baseLength, double legLength) {
        this.baseLength = baseLength;
        this.legLength = legLength;
    }

    public double getArea() {
        return 0.5 * baseLength * Math.sqrt(legLength * legLength - (0.5 * baseLength * 0.5 * baseLength));
    }

    public double getPerimeter() {
        return 2 * legLength + baseLength;
    }
}
public class Lab5Prb2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Number of geometric forms: ");
        int numForms = scanner.nextInt();

        GeometricForm[] forms = new GeometricForm[numForms];

        for (int i = 0; i < numForms; i++) {
            System.out.println("Form " + (i+1) + ":");
            System.out.print("Type (square/rectangle/circle/equilateral/isosceles): ");
            String type = scanner.next();

            switch (type) {
                case "square":
                    System.out.print("Side length: ");
                    double sideLength = scanner.nextDouble();
                    forms[i] = new Square(sideLength);
                    break;

                case "rectangle":
                    System.out.print("Length: ");
                    double length = scanner.nextDouble();
                    System.out.print("Width: ");
                    double width = scanner.nextDouble();
                    forms[i] = new Rectangle(length, width);
                    break;

                case "circle":
                    System.out.print("Radius: ");
                    double radius = scanner.nextDouble();
                    forms[i] = new Circle(radius);
                    break;

                case "equilateral":
                    System.out.print("Side length: ");
                    double eqSideLength = scanner.nextDouble();
                    forms[i] = new EquilateralTriangle(eqSideLength);
                    break;

                case "isosceles":
                    System.out.print("Base length: ");
                    double baseLength = scanner.nextDouble();
                    System.out.print("Leg length: ");
                    double legLength = scanner.nextDouble();
                    forms[i] = new IsoscelesTriangle(baseLength, legLength);
                    break;

                default:
                    System.out.println("Invalid form type.");
                    i--;
            }
        }

        double totalArea = 0;
        double totalPerimeter = 0;

        for (GeometricForm form : forms) {
            totalArea += form.getArea();
            totalPerimeter += form.getPerimeter();
        }

        System.out.println("Total area: " + totalArea);
        System.out.println("Total perimeter: " + totalPerimeter);
    }
}