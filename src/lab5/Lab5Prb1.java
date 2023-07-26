package lab5;

/**Cacu Razvan GR-2023
 * . Consider a Java interface that contains the prototypes of the methods of addition, subtraction, multiplication,
 * division, square root and raising a number to a certain power. All methods will have two double type parameters and
 * specify the returned double type.
 * Implement the interface so that operations are defined within a class. Instantiate the class and check the implemented
 * operations.
 */





 interface MathOperations {
    double add(double a, double b);
    double subtract(double a, double b);
    double multiply(double a, double b);
    double divide(double a, double b);
    double squareRoot(double a);
    double power(double a, double b);
}

 class MathOperationsImpl implements MathOperations {

    @Override
    public double add(double a, double b) {
        return a + b;
    }

    @Override
    public double subtract(double a, double b) {
        return a - b;
    }

    @Override
    public double multiply(double a, double b) {
        return a * b;
    }

    @Override
    public double divide(double a, double b) {
        return a / b;
    }

    @Override
    public double squareRoot(double a) {
        return Math.sqrt(a);
    }

    @Override
    public double power(double a, double b) {
        return Math.pow(a, b);
    }
}

public class Lab5Prb1 {
    public static void main(String[] args) {
        MathOperations math = new MathOperationsImpl();

        double a = 10;
        double b = 5;

        System.out.println("a + b = " + math.add(a, b));
        System.out.println("a - b = " + math.subtract(a, b));
        System.out.println("a * b = " + math.multiply(a, b));
        System.out.println("a / b = " + math.divide(a, b));
        System.out.println("sqrt(a) = " + math.squareRoot(a));
        System.out.println("a ^ b = " + math.power(a, b));
    }
}