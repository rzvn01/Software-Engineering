package lab10;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.Color;
import java.awt.Graphics;

/**
 * Cacu Razvan GR-2023
 * Write a Frame application that draws a schematic car. Use different colors for different car parts (doors, wheels, etc.).
 */
 class CarFrame extends JFrame {

    CarFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.add(new CarPanel());
        this.setVisible(true);
        this.setResizable(false);

    }

    public static class CarPanel extends JPanel {
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            drawCar(g);
        }

        private void drawCar(Graphics g) {

            g.setColor(Color.GRAY);
            g.fillRect(100, 300, 400, 100);

            g.setColor(Color.BLACK);
            g.fillRect(200, 250, 200, 50);

            g.setColor(Color.CYAN);
            g.fillRect(220, 260, 60, 30);
            g.fillRect(320, 260, 60, 30);

            g.setColor(Color.DARK_GRAY);
            g.fillOval(120, 380, 80, 80);
            g.fillOval(400, 380, 80, 80);
        }
    }
}
public  class Lab10Prb6 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(CarFrame::new);
    }
}