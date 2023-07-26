package lab12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Cacu Razvan GR-2023
 * Implement a graphical Java application that displays in the main frame a button labeled ”Start” and a Canvas
 * component. After pushing the button its label is changed to ”Stop” and a thread is started. The thread draws a circle on
 * the canvas. The circle is descending from the upper left corner and is moved to the right in the same time. When hitting
 * the canvas margins, the circle changes its moving direction. The drawing thread is stopped when the user presses the
 * button again.
 */
 class MovingCircle extends JFrame {
    private static final int DIAMETER = 50;

    private final JButton startStopButton;
    private final DrawingCanvas canvas;
    private Thread drawingThread;
    private AtomicBoolean running = new AtomicBoolean(false);

    public MovingCircle() {
        setLayout(new BorderLayout());

        startStopButton = new JButton("Start");
        canvas = new DrawingCanvas();

        startStopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (running.get()) {
                    running.set(false);
                    startStopButton.setText("Start");
                } else {
                    running.set(true);
                    startStopButton.setText("Stop");
                    startDrawingThread();
                }
            }
        });

        add(startStopButton, BorderLayout.NORTH);
        add(canvas, BorderLayout.CENTER);

        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void startDrawingThread() {
        drawingThread = new Thread(() -> {
            int x = 0;
            int y = 0;
            int xSpeed = 2;
            int ySpeed = 2;

            while (running.get()) {
                x += xSpeed;
                y += ySpeed;

                if (x <= 0 || x + DIAMETER >= canvas.getWidth()) {
                    xSpeed *= -1;
                }

                if (y <= 0 || y + DIAMETER >= canvas.getHeight()) {
                    ySpeed *= -1;
                }

                canvas.setCircleX(x);
                canvas.setCircleY(y);
                canvas.repaint();

                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        drawingThread.start();
    }

    private class DrawingCanvas extends Canvas {
        private int circleX = 0;
        private int circleY = 0;

        public void setCircleX(int circleX) {
            this.circleX = circleX;
        }

        public void setCircleY(int circleY) {
            this.circleY = circleY;
        }

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            g.fillOval(circleX, circleY, DIAMETER, DIAMETER);
        }
    }

}
public class Lab12Prb4 {

    public static void main(String[] args) {
        new MovingCircle();
    }
}
