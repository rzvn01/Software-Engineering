package lab6;

import java.awt.Color;
import java.util.Random;

/**
 * Cacu Razvan GR-2023
 * Write a Java application which implements an exception called lab6.OverSaturated. This exception is generated when the
 * saturation of a color has a value over 90 in the HSV color space. Write a method which randomly generated colors in the
 * RGB space and then converts them to the HSB/HSV space (<a href="https://www.cs.rit.edu/~ncs/color/t_convert.html">...</a>). If after
 * the conversion, the color's saturation is over 90, regenerate the color (In the testing phase,
 */
class OverSaturated extends Exception {
    public OverSaturated() {
        super("Color saturation is over 90%.");
    }
}

class RandomColorGenerator {
    private final Random random;

    public RandomColorGenerator() {
        this.random = new Random();
    }

    public Color generate() {
        int red = random.nextInt(256);
        int green = random.nextInt(256);
        int blue = random.nextInt(256);
        return new Color(red, green, blue);
    }
}


public class Lab6Prb6 {
    private static final int MAX_TRIES = 10;

    public static void main(String[] args) {
        RandomColorGenerator generator = new RandomColorGenerator();
        Color color = null;
        int count = 0;
        try {
            while (true) {

                color = generator.generate();
                System.out.println("Generated color: green: " + color.getGreen() + " red: " + color.getRed() + " blue: " + color.getBlue());

                float[] hsv = Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), null);
                System.out.println("Saturation: " + hsv[1]);
                try {
                    count++;
                    assert (hsv[1] * 100) >= 90;

                } catch (AssertionError error) {
                    System.out.println("This color satisfies the requirements!");
                    break;
                }
                if (count == MAX_TRIES)
                    throw new OverSaturated();
            }
        } catch (OverSaturated e) {
            System.out.println(e.getMessage());
        }
    }

}