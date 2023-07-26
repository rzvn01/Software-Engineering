package lab3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*Cacu Razvan GR-2023
  Write a Java application that reads an int value. If the int value is between 1-12, the corresponding string month
will be displayed. If the value entered is a string and if it corresponds to a month of the year, display the numeric
value of the month.
*/
public class Lab3Ex1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        List<String> months = new ArrayList<>(Arrays.asList(
                "january", "february", "march", "april", "may", "june",
                "july", "august", "september", "october", "november", "december"
        ));
        System.out.println("Please enter a value : ");
        input = scanner.nextLine();

        try {
            int value = Integer.parseInt(input);
            if (value > 0 && value <= 12) {
                String month = months.get(value - 1);
                System.out.println("The corresponding month is " + month.substring(0, 1).toUpperCase() + month.substring(1) + " .");
            } else {
                System.out.println("The number " + value + " does not have a corresponding month !");
            }
        } catch (NumberFormatException e) {
            int index = months.indexOf(input.toLowerCase());
            if (index != -1)
                System.out.println("The integer corresponding number of the month is " + (index + 1) + ".");
            else
                System.out.println("The input value is not a month ! ");

        }

    }
}