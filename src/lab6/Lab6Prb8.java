package lab6;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Cacu Razvan GR-2023
 * Write an application which checks the Romanian vehicle registration numbers. Their format is the following:
 * [L{L}][NN{N}][LLL], where L represents a letter, N a digit, and the curly braces represent the fact that for Bucharest the
 * number is composed of a single letter in the first group, and the digit group can be composed of 3 digits. Implement a
 * method which checks the registration numbers and throw exceptions (instances of specialized exception classes) specific
 * to each error which may occur upon check-up (specialized messages). For example, if the county letters group is
 * composed of 2 letters, the digit group cannot be of size 3. The last letters group cannot contain "I" and "O" on the first
 * and last position.
 */
class InvalidLetterGroup extends Exception {
    public InvalidLetterGroup(String message) {
        super(message);
    }
}
class InvalidCountyLetters extends Exception {
    public InvalidCountyLetters(String message) {
        super(message);
    }
}
class InvalidVehicleRegistrationNumber extends Exception {
    public InvalidVehicleRegistrationNumber(String message) {
        super(message);
    }
}

class InvalidDigitsGroup extends Exception {
    public InvalidDigitsGroup(String message) {
        super(message);
    }
}


public class Lab6Prb8 {

    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        String response;

        do{

            System.out.println("Please enter a registration number: ");
            String registrationNumber= scanner.next();
            try {
                checkRegistrationNumber(registrationNumber);
                System.out.println(registrationNumber + " is valid.");
            } catch (Exception e) {
                System.out.println(registrationNumber + " is invalid: " + e.getMessage());
            }

            System.out.println("Do you want to check another number ?");
             response = scanner.next();
    }
        while(!response.equalsIgnoreCase("n")&&!response.equalsIgnoreCase("no"));
    }

    public static void checkRegistrationNumber(String registrationNumber) throws InvalidVehicleRegistrationNumber, InvalidCountyLetters, InvalidDigitsGroup, InvalidLetterGroup {
        Pattern pattern = Pattern.compile("^([A-Z]{1,2})(\\d{2,3})([A-Z]{3})$");
        Matcher matcher = pattern.matcher(registrationNumber);

        if (!matcher.matches()) {
            throw new InvalidVehicleRegistrationNumber("Invalid registration number format.");
        }

        String letters = matcher.group(1);
        String digits = matcher.group(2);
        String lastLetters = matcher.group(3);

        if (letters.length() == 1 && digits.length() != 3) {
            throw new InvalidCountyLetters("Bucharest county code must be followed by 3 digits.");
        } else if (letters.length() == 2 && digits.length() != 2) {
            throw new InvalidDigitsGroup("Non-Bucharest county code must be followed by 2 digits.");
        }

        if (lastLetters.charAt(0) == 'I' || lastLetters.charAt(2) == 'I'||lastLetters.charAt(0) == 'O' || lastLetters.charAt(2) == 'O') {
            throw new InvalidLetterGroup("The last letters group cannot contain 'I' and 'O' on the first position or the last position.");
        }
    }
}