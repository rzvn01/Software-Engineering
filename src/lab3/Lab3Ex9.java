package lab3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/*Cacu Razvan GR2023
* Define an array of String variables that will be populated with all the playing cards from a complete package. A
series of randomly picked cards will be extracted until the current card will have the clubs sign and a value
greater than 8. At each step, the current card and the number of already extracted cards will be displayed.
Hint: Use a random numbers generator. The cards which were already used are eliminated.
*/

public class Lab3Ex9 {

    public static void main(String[] args) {
        Random random = new Random();
        List<String> colors = new ArrayList<>(Arrays.asList("clubs", "diamonds", "hearts", " spades"));
        List<String> cards = new ArrayList<>(Arrays.asList("ACE", "2", "3", " 4", "5", "6", "7", "8", "9", "10", "JACK", "QUEEN", "KING"));
        List<String> deck = new ArrayList<>();
        int index;

        for (String color : colors)
            for (String card : cards)
                deck.add(card + " of " + color);
        boolean flag;

        do {
            index = random.nextInt(deck.size() - 1);
            String extractedCard = deck.get(index);
            flag = checkCard(extractedCard);

            if (flag) {
                System.out.println("The last card extracted meeting the requirements : " + extractedCard);
            } else {
                System.out.println("The extracted  card :" + extractedCard);
                deck.remove(extractedCard);
            }
        } while (!flag);
    }

    public static boolean checkCard(String extractedCard) {
        try {
            int value = Integer.parseInt(String.valueOf(extractedCard.charAt(0)));

            return (value >= 8 && extractedCard.contains("clubs"));
        } catch (NumberFormatException exception) {

            return (!extractedCard.contains("ACE") && extractedCard.contains("clubs"));
        }
    }
}