package lab5.v2;

@FunctionalInterface
 interface Addition {
    double add(double a, double b);
}

@FunctionalInterface
 interface Subtraction {
    double subtract(double a, double b);
}

@FunctionalInterface
 interface Multiplication {
    double multiply(double a, double b);
}

@FunctionalInterface
 interface Division {
    double divide(double a, double b);
}
public class Lab5Prb1V2 {
    public static void main(String[] args) {
        Addition addition = (a, b) -> a + b;
        Subtraction subtraction = (a, b) -> a - b;
        Multiplication multiplication = (a, b) -> a * b;
        Division division = (a, b) -> a / b;

        double a = 10;
        double b = 5;

        System.out.println("a + b = " + addition.add(a, b));
        System.out.println("a - b = " + subtraction.subtract(a, b));
        System.out.println("a * b = " + multiplication.multiply(a, b));
        System.out.println("a / b = " + division.divide(a, b));
    }
}
