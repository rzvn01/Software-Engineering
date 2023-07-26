package lab8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * Cacu Razvan GR-2023
 * Using a KB reading mechanism (BufferedReader/InputStreamReader) input: a message of String type, a day as an
 * integer, a month as a String and a year as an integer variable. The process will end by passing to a new line, or by typing
 * a special String. Separate and display the tokens on different rows. Display all fields extracted from the stream as
 * appeared.
 */
public class Lab8Prb1 {
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter the message, day, month, and year, separated by spaces:");

            StreamTokenizer tokenizer = new StreamTokenizer(bufferedReader);
            tokenizer.eolIsSignificant(true);

            while (tokenizer.nextToken() != StreamTokenizer.TT_EOF) {
                if (tokenizer.ttype == StreamTokenizer.TT_EOL) {
                    System.out.println("End of line!");
                    break;
                }

                if (tokenizer.ttype == StreamTokenizer.TT_NUMBER) {
                    System.out.println("Number: " + tokenizer.nval);
                } else if (tokenizer.ttype == StreamTokenizer.TT_WORD) {
                    System.out.println("Word: " + tokenizer.sval);
                }
            }

        } catch (IOException e) {
            System.out.println("Error: "+e.getMessage());
        }
    }
}
