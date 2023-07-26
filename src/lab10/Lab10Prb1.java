package lab10;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

/**
 * Cacu Razvan GR-2023
 *  Write a Frame application that will display in a panel your name and group. The text will be blue and centered both on
 * the horizontal and vertical, given the dimension of the panel.
 */
public class Lab10Prb1 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Name and Group");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);
            frame.setResizable(false);
            frame.setLocationRelativeTo(null);

            String name = JOptionPane.showInputDialog(frame, "Enter your name:");
            String group = JOptionPane.showInputDialog(frame, "Enter your group:");

            JPanel panel = new JPanel();
                panel.setLayout(new GridBagLayout());
            panel.setBackground(Color.MAGENTA);

            JLabel nameLabel = new JLabel(name + " - " + group);
            nameLabel.setForeground(Color.BLACK);
            nameLabel.setFont(new Font("Times new roman", Font.BOLD, 24));

            panel.add(nameLabel, new GridBagConstraints());
            frame.add(panel);
            frame.setVisible(true);
        });
    }
}