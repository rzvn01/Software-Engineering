package lab6;

/**
 * Cacu Razvan GR-2023
 * Write a Java class derived from the Exception class, called lab6.SuperException. Another class, called lab6.SmallerException is
 * derived from lab6.SuperException. Within the classes' constructors print a message which indicates which exception was
 * generated. In a third class create a method a() which throws an exception of type lab6.SmallerException, and a method b()
 * which throws a lab6.SuperException.
 * In the main() method call these two methods and try to determine the type of exception which occurs, as well as if the
 * corresponding catch block for the lab6.SmallerException can catch a lab6.SuperException.
 */

class SuperException extends Exception {
    public SuperException() {
        super("lab6.SuperException was generated.");
        System.out.println("lab6.SuperException was generated.");
    }
}

class SmallerException extends SuperException {
    public SmallerException() {
        super();
        System.out.println("lab6.SmallerException was generated.");
    }
}

class ThirdClass {
    public static void a() throws SmallerException {
        throw new SmallerException();
    }

    public static void b() throws SuperException {
        throw new SuperException();
    }
}

public class Lab6Prb4 {
    public static void main(String[] args) {

        try {
            ThirdClass.a();
        } catch (SmallerException e) {
            System.out.println("Caught lab6.SmallerException.");
        } catch (SuperException e) {
            System.out.println("Caught lab6.SuperException."); //already caught into smaller exception
        }

        try {
            ThirdClass.b();
        } catch (SuperException e) {
            System.out.println("Caught lab6.SuperException.");
        }
    }
}

