package lab8;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Cacu Razvan GR-2023
 * Using a KB reading mechanism (BufferedReader/InputStreamReader) input: a message of String type, a day as an
 * integer, a month as a String and a year as an integer variable. The process will end by passing to a new line, or by typing
 * a special String. Separate and display the tokens on different rows. Display all fields extracted from the stream as
 * appeared.
 * Recommendation: use the StreamTokenizer class, the attributes sval, nval and the TT_EOL constant.
 * Consider the case in which the application is not aware of the entered data type (numbers, words). Use the constants
 * TT_NUMBER, TT_WORD.
 * 2. Implement the previous problem using a file as input source.
 */
public class Lab8Prb2 {
    public static void main(String[] args) {
        String inputFilePath = "C:\\Users\\razvan.cacu\\Desktop\\se labs\\src\\lab8\\text_file.txt";
        String specialString = "END";

        Path path = Paths.get(inputFilePath);
        try {
            List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);

            for (String line : lines) {
                if (line.equalsIgnoreCase(specialString)) {
                    break;
                }

                String[] tokens = line.split("\\s+");

                String message = tokens[0];
                int day = Integer.parseInt(tokens[1]);
                String month = tokens[2];
                int year = Integer.parseInt(tokens[3]);

                System.out.println("Message: " + message);
                System.out.println("Day: " + day);
                System.out.println("Month: " + month);
                System.out.println("Year: " + year);
            }
        } catch (IOException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
