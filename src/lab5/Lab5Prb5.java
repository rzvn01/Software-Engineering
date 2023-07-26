package lab5;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Cacu Razvan
 * Define a String Array. Using lambda expressions sort it by the following criteria: length (small->large), inverse length
 * (large->small), alphabetical order, the strings which start with the letter M are first, then come the rest
 */


public class Lab5Prb5 {
    public static void main(String[] args) {
        String[] myArray = {"abc", "zxy", "abcd", "mabcde", "mabcdef"};

        Arrays.sort(myArray, Comparator.comparing(String::length));

        System.out.println("Sorted by length (small -> large):");

        System.out.println(Arrays.toString(myArray));

        Arrays.sort(myArray, Comparator.comparing(String::length).reversed());

        System.out.println("Sorted by inverse length (large -> small):");
        System.out.println(Arrays.toString(myArray));


        Arrays.sort(myArray);

        System.out.println("Sorted alphabetically:");
        System.out.println(Arrays.toString(myArray));


        Arrays.sort(myArray, (s1, s2) -> {
            if ((s1.startsWith("M") && !s2.startsWith("M")||(s1.startsWith("m") && !s2.startsWith("m")))) {
                return -1;
            } else if ((!s1.startsWith("M") && s2.startsWith("M")||(!s1.startsWith("m") && s2.startsWith("m")))) {
                return 1;
            } else {
                return s1.compareTo(s2);
            }
        });

        System.out.println("Sorted by strings starting with M first, then the rest:");
        System.out.println(Arrays.toString(myArray));

    }
}
