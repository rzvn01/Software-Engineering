package lab8;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Cacu Razvan GR-2023
 * Read from the keyboard some strings representing dates formated as DD/MM/YYYY. Print the dates as DD month
 * YYYY, where month is the expanded version of the MM, and also display messages if the year is leap. The program exits
 * when the user types in X or x from KB. You may use DateFormatSymbols class for month conversion
 */
public class Lab8Prb3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        SimpleDateFormat inputDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat outputDateFormat = new SimpleDateFormat("dd MMMM yyyy");

        while (true) {
            System.out.println("Enter a date in the format DD/MM/YYYY, or type 'X' to exit:");
            input = scanner.nextLine();

            if (input.equalsIgnoreCase("X")) {
                break;
            }

            try {
                Date date = inputDateFormat.parse(input);
                String outputDate = outputDateFormat.format(date);
                System.out.println(outputDate);

                String[] dateParts = input.split("/");
                int year = Integer.parseInt(dateParts[2]);
                if (isLeapYear(year)) {
                    System.out.println("The year " + year + " is a leap year.");
                } else {
                    System.out.println("The year " + year + " is not a leap year.");
                }
            } catch (ParseException e) {
                System.out.println("Invalid date format. Please try again.");
            }
        }

        scanner.close();
    }

    private static boolean isLeapYear(int year) {
        if (year % 4 != 0) {
            return false;
        } else if (year % 100 != 0) {
            return true;
        } else return year % 400 == 0;
    }
}