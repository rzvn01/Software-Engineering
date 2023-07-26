package lab11;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridLayout;

/** Cacu Razvan GR-2023
 *  Implement a Java application that uses GridLayout for arranging the components specific to a computing application.
 * (TextField for I/O operations, buttons for numbers, mathematical operations, screen cleaning, etc.).
 */
 class CalculatorApp {
    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[4];
    JButton clearButton;
    JPanel panel;

    CalculatorApp() {

        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);
        frame.setLayout(null);


        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50);
        frame.add(textField);

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
        }

        functionButtons[0] = new JButton("+");
        functionButtons[1] = new JButton("-");
        functionButtons[2] = new JButton("*");
        functionButtons[3] = new JButton("/");

        clearButton = new JButton("C");

        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        for (int i = 1; i < 10; i++) {
            panel.add(numberButtons[i]);
        }

        for (JButton button : functionButtons) {
            panel.add(button);
        }

        panel.add(numberButtons[0]);
        panel.add(clearButton);

        frame.add(panel);
        frame.setVisible(true);
    }

}
public  class Lab11Prb1 {
    public static void main(String[] args) {
        new CalculatorApp();
    }
}