package lab4;

/** Cacu Razvan GR-2023
 * Build a Java application that tests the new methods of the String class, introduced in Java11
 */

public class Lab4Prb5 {
    public static void main(String[] args) {
        String str = "   Mesaj text  ";

        boolean isBlank = str.isBlank();
        System.out.println("isBlank(): " + isBlank);

        long numLines = str.lines().count();
        System.out.println("lines(): " + numLines);

        String strippedStr = str.strip();
        System.out.println("strip(): " + strippedStr);

        String repeatedStr = "repet ".repeat(3);
        System.out.println("repeat(): " + repeatedStr);
    }
}

