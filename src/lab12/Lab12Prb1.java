package lab12;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Cacu Razvan GR-2023
 * Implement a Java application that uses GridBagLayout for arranging the components specific to a computing
 * application. (TextField for I/O operations, buttons for numbers, mathematical operations, screen cleaning, etc.)
 */
class CalculatorAppGridBagLayout {
    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[5];
    JButton clearButton;
    JPanel panel;

    private boolean operatorClicked = false;
    private double firstValue = 0;
    private char currentOperator;

    CalculatorAppGridBagLayout() {
        frame = new JFrame("Calculator using GridBagLayout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);

        textField = new JTextField();
        textField.setPreferredSize(new Dimension(200, 50));

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    if (operatorClicked) {
                        textField.setText("");
                        operatorClicked = false;
                    }
                    textField.setText(textField.getText() + e.getActionCommand());
                }
            });
        }

        functionButtons[0] = new JButton("+");
        functionButtons[1] = new JButton("-");
        functionButtons[2] = new JButton("*");
        functionButtons[3] = new JButton("/");
        functionButtons[4] = new JButton("="); // Equals button

        for(int i = 0; i < 4; i++) {
            functionButtons[i].addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    firstValue = Double.parseDouble(textField.getText());
                    currentOperator = e.getActionCommand().charAt(0);
                    operatorClicked = true;
                }
            });
        }

        // Equals button action
        functionButtons[4].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                double secondValue = Double.parseDouble(textField.getText());
                switch (currentOperator) {
                    case '+':
                        textField.setText(firstValue + secondValue + "");
                        break;
                    case '-':
                        textField.setText(firstValue - secondValue + "");
                        break;
                    case '*':
                        textField.setText(firstValue * secondValue + "");
                        break;
                    case '/':
                        textField.setText(firstValue / secondValue + "");
                        break;
                }
                operatorClicked = true;
            }
        });

        clearButton = new JButton("C");
        clearButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                textField.setText("");
            }
        });

        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        panel.add(textField, gbc);

        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;

        for(int i = 0; i < 9; i++) {
            gbc.gridx = i % 3;
            gbc.gridy = 1 + i / 3;
            panel.add(numberButtons[i+1], gbc);
        }

        gbc.gridx = 1;
        gbc.gridy = 4;
        panel.add(numberButtons[0], gbc);

        for(int i = 0; i < 4; i++) {
            gbc.gridx = i;
            gbc.gridy = 5;
            panel.add(functionButtons[i], gbc);
        }

        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(clearButton, gbc);

        gbc.gridx = 3;
        gbc.gridy = 4;
        panel.add(functionButtons[4], gbc);

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}


public class Lab12Prb1 {
    public static void main(String[] args) {
        new CalculatorAppGridBagLayout();
    }
}