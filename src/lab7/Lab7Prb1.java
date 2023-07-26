package lab7;

import java.util.Scanner;

/**Cacu Razvan GR-2023
 * . Create an interface called Generator<T> with a single method next(T var). Implement the interface so that you can
 * generate the following values when applying it to certain data types (Integer, Character, etc.). The class will be
 * instantiated in the main( ) method, located in a separate class.
 */

interface Generator<T> {
    T next(T var);
}

class IntegerGenerator implements Generator<Integer> {
    @Override
    public Integer next(Integer var) {
        return var + 1;
    }
}

class CharacterGenerator implements Generator<Character> {
    @Override
    public Character next(Character var) {
        return (char) (var + 1);
    }
}

class DoubleGenerator implements Generator<Double> {
    @Override
    public Double next(Double var) {
        return (double) (var + 1.0);
    }
}

class FloatGenerator implements Generator<Float> {
    @Override
    public Float next(Float var) {
        return var + 1.0f;
    }
}

class Lab7prb1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Generator<Integer> intGen = new IntegerGenerator();
        Generator<Character> charGen = new CharacterGenerator();
        Generator<Double> doubleGen = new DoubleGenerator();
        Generator<Float> floatGen = new FloatGenerator();

        System.out.print("Enter an integer value: ");
        Integer intVal = scanner.nextInt();

        System.out.print("Enter a character value: ");
        Character charVal = scanner.next().charAt(0);

        System.out.print("Enter a double value: ");
        Double doubleVal = scanner.nextDouble();

        System.out.print("Enter a float value: ");
        Float floatVal = scanner.nextFloat();

        System.out.println("Next Integer: " + intGen.next(intVal));
        System.out.println("Next Character: " + charGen.next(charVal));
        System.out.println("Next Double: " + doubleGen.next(doubleVal));
        System.out.println("Next Float: " + floatGen.next(floatVal));
    }
}