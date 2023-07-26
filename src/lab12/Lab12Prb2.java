package lab12;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.GridLayout;

/**
 * Cacu Razvan Gr-2023
 *  Write a Java application which includes 3 sliders which enables the user to set the color of a 100x100 square. The
 * square will be drawn using a specific component (Canvas, etc.).
 */
class ColorSelector extends JFrame {
    private final Canvas canvas;
    private final JSlider redSlider, greenSlider, blueSlider;

    public ColorSelector() {
        super("Color Selector");

        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        canvas = new Canvas();
        canvas.setSize(100, 100);
        canvas.setBackground(Color.BLACK);

        JPanel sliderPanel = new JPanel();
        sliderPanel.setLayout(new GridLayout(3, 1));

        redSlider = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
        redSlider.addChangeListener(e -> updateColor());
        sliderPanel.add(new JLabel("Red"));
        sliderPanel.add(redSlider);

        greenSlider = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
        greenSlider.addChangeListener(e -> updateColor());
        sliderPanel.add(new JLabel("Green"));
        sliderPanel.add(greenSlider);

        blueSlider = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
        blueSlider.addChangeListener(e -> updateColor());
        sliderPanel.add(new JLabel("Blue"));
        sliderPanel.add(blueSlider);

        this.add(canvas, BorderLayout.CENTER);
        this.add(sliderPanel, BorderLayout.SOUTH);

        this.setVisible(true);
    }

    private void updateColor() {
        int red = redSlider.getValue();
        int green = greenSlider.getValue();
        int blue = blueSlider.getValue();
        canvas.setBackground(new Color(red, green, blue));
    }

}
public class Lab12Prb2 {

    public static void main(String[] args) {
        new ColorSelector();
    }
}

