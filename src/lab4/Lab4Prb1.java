package lab4; /** Cacu Razvan GR-2023
Write a class named Methods having 3 methods: a method with a variable number of integer parameters, which
returns the arithmetic mean of the parameters; another method in which will be defined a one-dimensional
array of n double-type numbers (n being the parameter of the method and which will be read in main () from
the keyboard), its elements will receive randomly generated values and the method will return this array; a
static method that receives as a parameter a character array, converts the respective characters into uppercase
letters and forms a String object from this array, which wiil be returned by the function. From the main ()
method, defined in another class, call the methods of the Methods class and display the results on the screen
(the call values for the first method and the character string for the 3rd method will be defined in main ()).
 **/

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class Methods {

    public Double arithmeticMean(int... a) {
        int count = 0, sum = 0;

        for (int i : a) {
            sum += i;
            count++;
        }
        return (double) (sum / count);
    }

    public Double[] getArray(int size) {
        Random random = new Random();
        Double[] array = new Double[size];

        for (int i = 0; i < size; i++) {
            array[i] = random.nextDouble();
        }

        return array;
    }

    public static String getString(Character[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = Character.toUpperCase(array[i]);

        }
        return Arrays.toString(array);
    }
}

public class Lab4Prb1 {
    public static void main(String[] args) {
        int size;
        Methods methods = new Methods();
        Scanner scanner = new Scanner(System.in);
        Character[] array = {'a', 'b', 'c'};

        System.out.println("Please enter the size of the array : ");
        size = scanner.nextInt();

        System.out.println("The arithmetic mean of 1 3 67 is : " + methods.arithmeticMean(1, 3, 67));

        System.out.println("The array is :" + Arrays.toString(methods.getArray(size)));

        System.out.println("The result of changing the initial array  " + Arrays.toString(array) + " is " + Methods.getString(array));
    }
}
