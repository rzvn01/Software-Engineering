package lab3;

import java.util.HashMap;
import java.util.Random;

/*Cacu Razvan GR-2023
*  Assume that there is a cryptographic algorithm which takes an input text ‘A’ composed of lower and upper case
characters. Separately a character string ‘B’ is defined. Each character from B has an associated random integer
value between 1 and 100. The algorithm checks if the letters from B are found in A and adds the associated
numerical values. To the final sum value, the algorithm also adds the positions from string A where characters
from string B were found. If the final sum is larger than 100, the encryption was valid. Display a message with
the result.
Example:
String A = ”aTmPpDsst”
String B =”ams”
Associated numerical values for string B: 11 33 7
Sum: (11+33+7+7)+(1+3+7+8)=77 -> INVALID ENCRYPTION
*/

public class Lab3Ex10 {
    public static void main(String[] args) {
        int sum;
        Random random = new Random();

        String inputText = getRandomString(random.nextInt(50 - 20) + 20);
        System.out.println("The string A : " + inputText);

        String encryptionText = getRandomString((inputText.length() / 10) + 1);
        System.out.println("The string B : " + encryptionText);

        HashMap<Character, Integer> values = new HashMap<>();

        for (char a : encryptionText.toCharArray()) {
            if (!values.containsKey(a))
                values.put(a, random.nextInt(100 - 1) + 1);
        }
        System.out.println("The values are :" + values);

        sum = encryptionResult(inputText, values);

        System.out.print("Sum : " + sum);

        if (sum > 100)
            System.out.println("---->VALID ENCRYPTION ");
        else
            System.out.println("---->INVALID ENCRYPTION ");
    }

    private static int encryptionResult(String inputText, HashMap<Character, Integer> values) {
        int sum = 0;
        char a;

        for (int i = 0; i < inputText.length(); i++) {
            a = inputText.charAt(i);
            if (values.containsKey(a)) {
                sum += i + values.get(a);
            }
        }

        return sum;
    }

    private static String getRandomString(int length) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(alphabet.length());
            char randomChar = alphabet.charAt(index);
            sb.append(randomChar);
        }

        return sb.toString();
    }

}
