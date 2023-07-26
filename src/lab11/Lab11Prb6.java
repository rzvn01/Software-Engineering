package lab11;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Cacu Razvan GR 2023
 * . Write a Java application which includes a sign-up form for an online course. The form includes information regarding
 * the name, surname, year of study, faculty, financing (tax/budget) and the course. The year of study, faculty and course
 * are drop-down lists, and the financing is a check-box field. În a TextArea field print the filled-in information after the
 * Sign-up button is pressed.
 */
class SignUpFormApp {
    public static void run() {
        JFrame frame = new JFrame("Sign-up Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 2, 5, 5));

        JLabel nameLabel = new JLabel("Name:");
        JTextField nameTextField = new JTextField();
        JLabel surnameLabel = new JLabel("Surname:");
        JTextField surnameTextField = new JTextField();
        JLabel yearLabel = new JLabel("Year of Study:");
        JComboBox<String> yearComboBox = new JComboBox<>(new String[]{"1st Year", "2nd Year", "3rd Year", "4th Year"});
        JLabel facultyLabel = new JLabel("Faculty:");
        JComboBox<String> facultyComboBox = new JComboBox<>(new String[]{"Faculty 1", "Faculty 2", "Faculty 3"});
        JLabel financingLabel = new JLabel("Financing:");
        JComboBox<String> financingCheckBox = new JComboBox<>(new String[]{"Tax", "Budget"});
        JLabel courseLabel = new JLabel("Course:");
        JComboBox<String> courseComboBox = new JComboBox<>(new String[]{"Course 1", "Course 2", "Course 3"});
        JButton signUpButton = new JButton("Sign-up");
        JTextArea infoTextArea = new JTextArea();
        infoTextArea.setEditable(false);

        signUpButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameTextField.getText();
                String surname = surnameTextField.getText();
                String year = (String) yearComboBox.getSelectedItem();
                String faculty = (String) facultyComboBox.getSelectedItem();
                String financing = (String) financingCheckBox.getSelectedItem();
                String course = (String) courseComboBox.getSelectedItem();

                String info = "Name: " + name + "\nSurname: " + surname + "\nYear of Study: " + year +
                        "\nFaculty: " + faculty + "\nFinancing: " + financing +
                        "\nCourse: " + course;

                infoTextArea.setText(info);
            }
        });

        panel.add(nameLabel);
        panel.add(nameTextField);
        panel.add(surnameLabel);
        panel.add(surnameTextField);
        panel.add(yearLabel);
        panel.add(yearComboBox);
        panel.add(facultyLabel);
        panel.add(facultyComboBox);
        panel.add(financingLabel);
        panel.add(financingCheckBox);
        panel.add(courseLabel);
        panel.add(courseComboBox);
        panel.add(signUpButton);
        panel.add(infoTextArea);

        frame.getContentPane().add(panel);
        frame.setSize(1600, 900);
        frame.setVisible(true);
    }
}

public class Lab11Prb6 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(SignUpFormApp::run);
    }
}