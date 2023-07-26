package lab10;


import javax.swing.JFrame;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Cacu Razvan GR-2023
 *  Write a Frame application that displays an image stored in a local file. Below the image display the filename with a
 * predefined Font. The text is drawn using a color composed of 3 predefined components (red, green, blue).
 */
class ImageFrame extends JFrame {
    private Image image;
    private String fileName;
    private final Font font = new Font("Arial", Font.ITALIC, 12);
    private final Color textColor = new Color(124, 167, 174, 255);

    ImageFrame(String fileName) {
        this.fileName = fileName;
        try {
            image = ImageIO.read(new File(fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
            System.exit(1);
        }

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(image.getWidth(null), image.getHeight(null) + 50);
        setVisible(true);
        setResizable(false);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(image, 0, 0, null);
        g.setColor(textColor);
        g.setFont(font);
        String [] name = fileName.split("\\\\");
        g.drawString(name[name.length-1], 50, getHeight()-30 );
    }
}

public class Lab10Prb3 {
    public static void main(String[] args) {
        new ImageFrame("C:\\Users\\razvan.cacu\\Desktop\\labs SE\\src\\lab10\\almond_blossoms.jpg");
    }
}
