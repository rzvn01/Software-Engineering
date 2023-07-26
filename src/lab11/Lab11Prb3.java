package lab11;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.Color;

/**
 * Cacu Razvan GR-2023
 * Implement a TabbedView Java application that displays in each graphical panel:
 * - a drawing area
 * - the necessary components for selecting a font type, size and color
 * - the necessary components for choosing a geometrical shape (from a predefined set) and a size for the side / radius (as
 * the case)
 */
class TabbedViewApp {

    public static void run() {
        JFrame frame = new JFrame("TabbedView");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Panel 1", createPanel());
        tabbedPane.addTab("Panel 2", createPanel());
        tabbedPane.addTab("Panel 3", createPanel());
        tabbedPane.addTab("Panel 4", createPanel());

        frame.getContentPane().add(tabbedPane);
        frame.setSize(600, 800);
        frame.setVisible(true);
    }

    private static JPanel createPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JPanel drawingArea = new JPanel();
        drawingArea.setBackground(Color.GRAY);
        panel.add(drawingArea, BorderLayout.CENTER);

        JPanel fontPanel = new JPanel();
        JLabel fontLabel = new JLabel("Font:");
        JComboBox<String> fontComboBox = new JComboBox<>(new String[]{"Arial", "Times New Roman", "Calibri"});
        fontPanel.add(fontLabel);
        fontPanel.add(fontComboBox);
        panel.add(fontPanel, BorderLayout.NORTH);

        JPanel fontSizePanel = new JPanel();
        JLabel fontSizeLabel = new JLabel("Font Size:");
        JComboBox<Integer> fontSizeComboBox = new JComboBox<>(new Integer[]{10, 12, 14, 16, 18,20,22,24});
        fontSizePanel.add(fontSizeLabel);
        fontSizePanel.add(fontSizeComboBox);
        panel.add(fontSizePanel, BorderLayout.SOUTH);

        JPanel shapePanel = new JPanel();
        JLabel shapeLabel = new JLabel("Shape:");
        JComboBox<String> shapeComboBox = new JComboBox<>(new String[]{"Circle", "Square", "Triangle","Hexagon"});
        shapePanel.add(shapeLabel);
        shapePanel.add(shapeComboBox);
        panel.add(shapePanel, BorderLayout.EAST);

        JPanel sizePanel = new JPanel();
        JLabel sizeLabel = new JLabel("Size:");
        JTextField sizeTextField = new JTextField(10);
        sizePanel.add(sizeLabel);
        sizePanel.add(sizeTextField);
        panel.add(sizePanel, BorderLayout.WEST);

        return panel;
    }

}
public class Lab11Prb3 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(TabbedViewApp::run);
    }
}