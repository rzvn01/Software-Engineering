package lab10;


import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * Cacu Razvan GR-2023
 *  Write a Frame application that displays a TV test card. The card will contain at least 10 levels of grey and the basic
 * colors red, green, blue, yellow, cyan and magenta. The card will cover the entire surface of the component that displays
 * it (Canvas, etc.).
 */
class TVTestCardApp {

    private final Color[] colors = {Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.CYAN, Color.MAGENTA};

    public TVTestCardApp() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1600, 900);

        BufferedImage image = new BufferedImage(1600, 900, BufferedImage.TYPE_INT_ARGB);
        Graphics g = image.getGraphics();

        int greyLevels;

        do {
            String inputDialog = JOptionPane.showInputDialog(frame, "Enter the number of greys:");
            greyLevels = Integer.parseInt(inputDialog);
        }
        while (greyLevels < 10);

        for (int i = 0; i < greyLevels; i++) {
            g.setColor(new Color(i * 255 / (greyLevels - 1), i * 255 / (greyLevels - 1), i * 255 / (greyLevels - 1)));
            g.fillRect(i * image.getWidth() / greyLevels, 0, image.getWidth() / greyLevels, image.getHeight() / 2);
        }

        for (int i = 0; i < colors.length; i++) {
            g.setColor(colors[i]);
            g.fillRect(i * image.getWidth() / colors.length, image.getHeight() / 2, image.getWidth() / colors.length, image.getHeight() / 2);
        }

        JLabel label = new JLabel(new ImageIcon(image));
        frame.add(label);

        frame.setVisible(true);
        frame.setResizable(false);
    }

}

public class Lab10Prb4 {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TVTestCardApp::new);
    }
}







