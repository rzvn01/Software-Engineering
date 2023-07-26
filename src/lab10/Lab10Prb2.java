package lab10;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

/**
 * Cacu Razvan GR-2023
 *  Write a Frame application that will draw, inside a Canvas component, a circle tangent to smaller side of the canvas
 */
public class Lab10Prb2 {

        public static void main(String[] args) {
            SwingUtilities.invokeLater(() -> {
                JFrame frame = new JFrame("Tangent Circle");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(400, 300);
                frame.setResizable(false);
                frame.setLocationRelativeTo(null);

                TangentCircleCanvas canvas = new TangentCircleCanvas();
                frame.add(canvas);
                frame.setVisible(true);
            });
        }

        static class TangentCircleCanvas extends Canvas {

            @Override
            public void paint(Graphics g) {
                super.paint(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                int width = getWidth();
                int height = getHeight();

                int diameter = Math.min(width, height);
                int x = (width - diameter) / 2;
                int y = (height - diameter) / 2;

                g2d.drawOval(x, y, diameter, diameter);
            }
        }
    }