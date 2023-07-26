package lab10;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 * Cacu Razvan GR-2023
 *  Write a Frame application that draws a circle colored in all the possible colors. The starting color is red and the color
 * transitions must be made as smooth as possible.
 */
public class Lab10Prb5 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Lab10 Prb5");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);
            frame.setVisible(true);
            CircleCanvas canvas = new CircleCanvas();
            frame.add(canvas);
            canvas.startAnimation();
            frame.setResizable(false);
        });
    }

    static class CircleCanvas extends Canvas {
        private float hue = 0f;

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            Graphics2D g2d = (Graphics2D) g;

            int width = getWidth();
            int height = getHeight();
            int diameter = Math.min(width, height);
            int x = (width - diameter) / 2;
            int y = (height - diameter) / 2;

            Color color = Color.getHSBColor(hue, 1, 1);
            g2d.setColor(color);
            g2d.fillOval(x, y, diameter, diameter);
        }

        void startAnimation() {
            new Timer(100, e -> {
                hue += 0.01;
                if (hue > 1) {
                    hue -= 1;
                }
                repaint();
            }).start();
        }
    }
}