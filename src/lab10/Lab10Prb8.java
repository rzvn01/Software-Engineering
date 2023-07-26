package lab10;

import javax.swing.JFrame;

import javax.swing.SwingUtilities;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Cacu Razvan GR-2023
 * . Write a Java application that draws the trajectory of an object ”thrown” horizontally with a predefined velocity. The
 * trajectory is limited by the visual container’s lower bound. If the trajectory intersects the left or right container sides, the
 * object will bounce in the opposite direction. Display the object’s final vertical velocity.
 */
class BouncingBall extends JFrame {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int DIAMETER = 50;

    private float x = 0;
    private float y = 0;
    private float vx = 7.5f;
    private float vy = 0;
    private float gravity = 0.1f;

    private ArrayList<Point> trajectoryPoints = new ArrayList<>();


    public BouncingBall() {
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);



        Timer timer = new Timer(1000 / 60, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (x + DIAMETER > WIDTH || x < 0) {
                    vx *= -1;
                }
                if (y + DIAMETER > HEIGHT || y < 0) {
                    vy *= -1;
                } else {
                    vy += gravity;
                }
                x += vx;
                y += vy;

                trajectoryPoints.add(new Point((int)x, (int)y));

                double velocity = Math.sqrt(vx * vx + vy * vy);

                System.out.println("Velocity: "+velocity);

                repaint();
            }
        });
        timer.start();
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.MAGENTA);
        g.fillOval((int) x, (int) y, DIAMETER, DIAMETER);

        g.setColor(Color.BLUE);
        for (int i = 1; i < trajectoryPoints.size(); i++) {
            Point start = trajectoryPoints.get(i - 1);
            Point end = trajectoryPoints.get(i);
            g.drawLine(start.x, start.y, end.x, end.y);
        }
    }
}

public class Lab10Prb8 {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(BouncingBall::new);
    }
}