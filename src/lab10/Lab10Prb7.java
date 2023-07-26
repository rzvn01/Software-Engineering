package lab10;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

/**
 * Cacu Razvan GR-2023
 *  Implement a Frame application that fills a visual container with circles having randomly generated radii. The circles
 * are tangent and have random colors.
 */
class RandomCircleFrame extends JFrame {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int MAX_RADIUS = 60;
    private static final int DELAY = 500;

    public RandomCircleFrame() {
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);

        new Timer(DELAY, e -> repaint()).start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Random random = new Random();

        g.clearRect(0, 0, WIDTH, HEIGHT);

        int radius = random.nextInt(MAX_RADIUS);
        int x = random.nextInt(WIDTH - radius);
        int y = random.nextInt(HEIGHT - radius);

        int red = random.nextInt(256);
        int green = random.nextInt(256);
        int blue = random.nextInt(256);
        Color color = new Color(red, green, blue);

        g.setColor(color);
        g.fillOval(x, y, 2 * radius, 2 * radius);
    }
}

public class Lab10Prb7 {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(RandomCircleFrame::new);
    }
}