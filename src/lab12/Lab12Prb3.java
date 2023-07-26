package lab12;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Cacu Razvan GR-2023
 *  Build an application which measures the user's response time. The application randomly generates 10 red and black
 * circles. The application includes two buttons labelled RED and BLACK. The user must press the correct button. At the end
 * of the game, the app will display the number of correct answers and the user's average reaction time (use the method
 * System.currentTimeMillis()).
 */
 class ResponseTimeTester extends JFrame {

    private static final int NUMBER_OF_CIRCLES = 10;
    private List<Color> colors = new ArrayList<>();
    private JButton redButton;
    private JButton blackButton;
    private JLabel circle;
    private int currentCircleIndex = 0;
    private int correctAnswers = 0;
    private long startTime;
    private List<Long> responseTimes = new ArrayList<>();

    public ResponseTimeTester() {
        Random random = new Random();

        for (int i = 0; i < NUMBER_OF_CIRCLES; i++) {
            colors.add(random.nextBoolean() ? Color.RED : Color.BLACK);
        }

        setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        redButton = new JButton("RED");
        blackButton = new JButton("BLACK");
        buttonPanel.add(redButton);
        buttonPanel.add(blackButton);

        circle = new JLabel();
        circle.setOpaque(true);
        circle.setPreferredSize(new Dimension(100, 100));

        add(buttonPanel, BorderLayout.NORTH);
        add(circle, BorderLayout.CENTER);

        redButton.addActionListener(new ButtonListener(Color.RED));
        blackButton.addActionListener(new ButtonListener(Color.BLACK));

        nextCircle();
    }

    private void nextCircle() {
        if (currentCircleIndex < NUMBER_OF_CIRCLES) {
            circle.setBackground(colors.get(currentCircleIndex));
            currentCircleIndex++;
            startTime = System.currentTimeMillis();
        } else {
            redButton.setEnabled(false);
            blackButton.setEnabled(false);

            double averageReactionTime = responseTimes.stream().mapToLong(Long::longValue).average().orElse(0);
            JOptionPane.showMessageDialog(this,
                    "Game Over. Correct Answers: " + correctAnswers + ". Average Reaction Time: " + averageReactionTime + " ms.");
        }
    }

    private class ButtonListener implements ActionListener {

        private Color color;

        public ButtonListener(Color color) {
            this.color = color;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            long endTime = System.currentTimeMillis();
            if (circle.getBackground() == color) {
                correctAnswers++;
                responseTimes.add(endTime - startTime);
            }
            nextCircle();
        }
    }

}
public class Lab12Prb3 {
    public static void main(String[] args) {
        ResponseTimeTester tester = new ResponseTimeTester();
        tester.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tester.pack();
        tester.setVisible(true);
    }
}