package lab5;

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

 class Operations {
    private Addition addition;
    private Subtraction subtraction;
    private Multiplication multiplication;
    private Division division;

    public Operations() {
        addition = (a, b) -> a + b;
        subtraction = (a, b) -> a - b;
        multiplication = (a, b) -> a * b;
        division = (a, b) -> a / b;
    }

    public double add(double a, double b) {
        return addition.add(a, b);
    }

    public double subtract(double a, double b) {
        return subtraction.subtract(a, b);
    }

    public double multiply(double a, double b) {
        return multiplication.multiply(a, b);
    }

    public double divide(double a, double b) {
        return division.divide(a, b);
    }

}public class Lab5Prb1V1{
    public static void main(String[] args) {
        Operations math = new Operations();

        double a = 10;
        double b = 5;

        System.out.println("a + b = " + math.add(a, b));
        System.out.println("a - b = " + math.subtract(a, b));
        System.out.println("a * b = " + math.multiply(a, b));
        System.out.println("a / b = " + math.divide(a, b));
    }
}
