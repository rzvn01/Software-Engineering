package lab7;

import java.util.Scanner;

/**
 * Cacu Razvan GR-2023
 * Write a class called Calculator which has the methods to do addition, subtraction, multiplication and division. The
 * methods will take generic input variables and will return the corresponding type. For example, the sum of two integers
 * should return an integer, and for floats it should return a float. Same for division. Adding and subtracting is allowed for
 * String variables as well, but the multiplication and division will print an error message.
 * Write the same class, but use method overloading
 */

class Calculator {
    public static <T extends Number> T add(T a, T b) {
        if (a instanceof Integer && b instanceof Integer) {
            return (T) (Object) ((Integer) a + (Integer) b);
        } else if (a instanceof Float && b instanceof Float) {
            return (T) (Object) ((Float) a + (Float) b);
        } else if (a instanceof Double && b instanceof Double) {
            return (T) (Object) ((Double) a + (Double) b);
        } else {
            return null;
        }
    }

    public static <T extends Number> T subtract(T a, T b) {
        if (a instanceof Integer && b instanceof Integer) {
            return (T) (Object) ((Integer) a - (Integer) b);
        } else if (a instanceof Float && b instanceof Float) {
            return (T) (Object) ((Float) a - (Float) b);
        } else if (a instanceof Double && b instanceof Double) {
            return (T) (Object) ((Double) a - (Double) b);
        } else {
            return null;
        }
    }

    public static <T extends Number> T multiply(T a, T b) {
        if (a instanceof Integer && b instanceof Integer) {
            return (T) (Object) ((Integer) a * (Integer) b);
        } else if (a instanceof Float && b instanceof Float) {
            return (T) (Object) ((Float) a * (Float) b);
        } else if (a instanceof Double && b instanceof Double) {
            return (T) (Object) ((Double) a * (Double) b);
        } else {
            return null;
        }
    }

    public static <T extends Number> T divide(T a, T b) {
        if (a instanceof Integer && b instanceof Integer) {
            if ((Integer) b == 0) {
                System.out.println("Error: lab5.v2.Division by zero is not allowed.");
                return null;
            }
            return (T) (Object) ((Integer) a / (Integer) b);
        } else if (a instanceof Float && b instanceof Float) {
            if ((Float) b == 0) {
                System.out.println("Error: lab5.v2.Division by zero is not allowed.");
                return null;
            }
            return (T) (Object) ((Float) a / (Float) b);
        } else if (a instanceof Double && b instanceof Double) {
            if ((Double) b == 0) {
                System.out.println("Error: lab5.v2.Division by zero is not allowed.");
                return null;
            }
            return (T) (Object) ((Double) a / (Double) b);
        } else {
            return null;
        }
    }

    public static <T extends String> String add(T a, T b) {
        return a + (String) b;
    }

    public static <T extends String> void subtract(T a, T b) {
        System.out.println("Error: lab5.v2.Subtraction is not allowed for strings.");
    }

    public static <T extends String> void multiply(T a, T b) {
        System.out.println("Error: lab5.v2.Multiplication is not allowed for strings.");
    }

    public static <T extends String> void divide(T a, T b) {
        System.out.println("Error: lab5.v2.Division is not allowed for strings.");
    }
}

class OverloadedCalculator {


    public static int add(int a, int b) {
        return a + b;
    }

    public static float add(float a, float b) {
        return a + b;
    }

    public static double add(double a, double b) {
        return a + b;
    }

    public static  String add(String a, String b) {
        return a + b;
    }

    public static int subtract(int a, int b) {
        return a - b;
    }

    public static float subtract(float a, float b) {
        return a - b;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static void subtract(String a, String b) {
        System.out.println("Error: lab5.v2.Subtraction is not allowed for strings.");
    }

    public static int multiply(int a, int b) {
        return a * b;
    }

    public static float multiply(float a, float b) {
        return a * b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }


    public  static void multiply(String a, String b) {
        System.out.println("Error: lab5.v2.Multiplication is not allowed for strings.");
    }

    public static int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }

    public static float divide(float a, float b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }

    public static double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }

    public static void divide(String a, String b) {
        System.out.println("Error: lab5.v2.Division is not allowed for strings.");
    }
}

public class Lab7Prb2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter first number: ");
        int a = scanner.nextInt();

        System.out.print("Enter second number: ");
        int b = scanner.nextInt();


        System.out.println("Using Calculator with generics:");
        System.out.println("lab5.v2.Addition: " + Calculator.add(a, b));
        System.out.println("lab5.v2.Subtraction: " + Calculator.subtract(a, b));
        System.out.println("lab5.v2.Multiplication: " + Calculator.multiply(a, b));
        System.out.println("lab5.v2.Division: " + Calculator.divide(a, b));

        System.out.println();

        System.out.println("Using OverloadedCalculator with method overloading:");
        System.out.println("lab5.v2.Addition: " + OverloadedCalculator.add(a, b));
        System.out.println("lab5.v2.Subtraction: " + OverloadedCalculator.subtract(a, b));
        System.out.println("lab5.v2.Multiplication: " + OverloadedCalculator.multiply(a, b));
        System.out.println("lab5.v2.Division: " + OverloadedCalculator.divide(a, b));

        System.out.println();

        System.out.print("Enter first string: ");
        scanner.nextLine(); // Consume newline left-over
        String s1 = scanner.nextLine();

        System.out.print("Enter second string: ");
        String s2 = scanner.nextLine();

        System.out.println("Using Calculator with generics:");
        System.out.println("String addition: " + Calculator.add(s1, s2));
        System.out.print("String subtraction: ");
        Calculator.subtract(s1, s2);
        Calculator.divide(s1,s2);
        Calculator.multiply(s1,s2);

        System.out.println();

        System.out.println("Using OverloadedCalculator with method overloading:");
        System.out.println("String addition: " + OverloadedCalculator.add(s1, s2));
        System.out.print("String subtraction: ");
        OverloadedCalculator.subtract(s1, s2);
        OverloadedCalculator.divide(s1,s2);
        OverloadedCalculator.multiply(s1,s2);
    }
}
