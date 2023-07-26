package lab12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/** Cacu Razvan GR-2023
 * Write a Java GUI application which includes a course registration form. The interface contains 2 TextField components
 * for entering the name and the group and a ComboBox selection list for choosing the course name. The form has a
 * ”Register” button that saves in a file the data entered by the user. Monitor the keyboard events for allowing only letters
 * in the first TextField and only digits in the second one
 */
 class CourseRegistrationForm extends JFrame {
    private JTextField nameField;
    private JTextField groupField;
    private JComboBox<String> courseBox;
    private JButton registerButton;

    public CourseRegistrationForm() {
        setLayout(new GridLayout(4, 2));

        nameField = new JTextField();
        groupField = new JTextField();
        String[] courses = {"Course 1", "Course 2", "Course 3"};
        courseBox = new JComboBox<>(courses);
        registerButton = new JButton("Register");

        nameField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isLetter(c)) {
                    e.consume();  // ignore event
                }
            }
        });

        groupField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume();
                }
            }
        });

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String group = groupField.getText();
                String course = (String) courseBox.getSelectedItem();

                try (BufferedWriter writer = new BufferedWriter(new FileWriter("fisier.txt", true))) {
                    writer.write("Name: " + name + ", Group: " + group + ", Course: " + course);
                    writer.newLine();
                    JOptionPane.showMessageDialog(null, "Data Saved!");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });

        add(new JLabel("Name: "));
        add(nameField);
        add(new JLabel("Group: "));
        add(groupField);
        add(new JLabel("Course: "));
        add(courseBox);
        add(registerButton);

        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

}
public class Lab12Prb5 {
    public static void main(String[] args) {
        new CourseRegistrationForm();
    }
}