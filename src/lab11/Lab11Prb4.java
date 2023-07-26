package lab11;

import javax.naming.Name;
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
 * Create an application which takes from two text fields your name and the group you are part of and displays this info
 * in a label colored in RGB (122,123,129).
 */
class NameAndGroupApp {


    public static void start() {
        JFrame frame = new JFrame("Name and Group App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JLabel nameLabel = new JLabel("Name: ");
        JTextField nameTextField = new JTextField(50);
        panel.add(nameLabel);
        panel.add(nameTextField);

        JLabel groupLabel = new JLabel("Group: ");
        JTextField groupTextField = new JTextField(50);
        panel.add(groupLabel);
        panel.add(groupTextField);

        JButton displayButton = new JButton("Display");
        panel.add(displayButton);

        JLabel infoLabel = new JLabel();
        infoLabel.setOpaque(true);
        infoLabel.setBackground(new Color(122, 123, 129));
        infoLabel.setForeground(Color.WHITE);
        panel.add(infoLabel);

        displayButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameTextField.getText();
                String group = groupTextField.getText();

                infoLabel.setText("Name: " + name + ", Group: " + group);
            }
        });

        frame.getContentPane().add(panel);
        frame.setSize(600, 800);
        frame.setVisible(true);
    }
}

public class Lab11Prb4 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(NameAndGroupApp::start);
    }
}