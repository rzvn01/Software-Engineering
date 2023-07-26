package lab11;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Cacu Razvan GR-2023
 * Implement a graphical application that displays 3 TextField components for setting the amounts of R, G and B from a
 * color. After pressing a button, a Label component will display a text representing the specified quantities, with the
 * resulting color, if the values are correct (numerical, between 0-255). Oherwise, an error message will be displayed with
 * red. Try to use exceptions for validating the input.
 */
class ColorInputApp {

    public static void createAndShowGUI() {
        JFrame frame = new JFrame("Color Input App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JTextField redTextField = new JTextField(5);
        JTextField greenTextField = new JTextField(5);
        JTextField blueTextField = new JTextField(5);

        JLabel redLabel = new JLabel("R:");
        JLabel greenLabel = new JLabel("G:");
        JLabel blueLabel = new JLabel("B:");

        JButton displayButton = new JButton("Display");
        JLabel infoLabel = new JLabel();

        displayButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int red = Integer.parseInt(redTextField.getText());
                    int green = Integer.parseInt(greenTextField.getText());
                    int blue = Integer.parseInt(blueTextField.getText());

                    if (isValidColorValue(red) && isValidColorValue(green) && isValidColorValue(blue)) {
                        Color color = new Color(red, green, blue);
                        infoLabel.setText("Color: RGB(" + red + ", " + green + ", " + blue + ")");
                        infoLabel.setForeground(color);
                    } else {
                        throw new IllegalArgumentException("Invalid color value!");
                    }
                } catch (NumberFormatException ex) {
                    infoLabel.setText("Error: Invalid input format!");
                    infoLabel.setForeground(Color.RED);
                } catch (IllegalArgumentException ex) {
                    infoLabel.setText("Error: " + ex.getMessage());
                    infoLabel.setForeground(Color.RED);
                }
            }
        });

        panel.add(redLabel);
        panel.add(redTextField);
        panel.add(greenLabel);
        panel.add(greenTextField);
        panel.add(blueLabel);
        panel.add(blueTextField);
        panel.add(displayButton);
        panel.add(infoLabel);

        frame.getContentPane().add(panel);
        frame.setSize(400, 200);
        frame.setVisible(true);
    }

    private static boolean isValidColorValue(int value) {
        return value >= 0 && value <= 255;
    }
}

public class Lab11Prb5 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(ColorInputApp::createAndShowGUI);
    }
}