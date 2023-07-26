package lab12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.util.Random;

/**
 * Cacu Razvan GR-2023
 *  Write an application which simulates a dice roll. The application will include a button labelled "Roll dice" which
 * triggers the event of drawing two dice in the app's window.
 * * Split the window into 2 areas, so that two players can play the game. The players with the highest dice score wins the
 * round. Count the number of games won, lost and finished with a draw by each player.
 */
class DiceRollGame extends JFrame {
    private final JLabel player1Label;
    private final JLabel player2Label;
    private final JLabel resultLabel;

    private int player1Score;
    private int player2Score;
    private int draws;

    private static final int DICE_SIZE = 50;

    public DiceRollGame() {
        setTitle("Dice Roll Game");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        player1Label = new JLabel("Player 1: 0");
        player2Label = new JLabel("Player 2: 0");
        resultLabel = new JLabel(" ");

        JButton rollButton = new JButton("Roll Dice");
        rollButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rollDice();
                repaint();
            }
        });

        JPanel dicePanel = new JPanel(new FlowLayout());
        dicePanel.add(player1Label);
        dicePanel.add(player2Label);

        add(dicePanel, BorderLayout.NORTH);
        add(resultLabel, BorderLayout.CENTER);
        add(rollButton, BorderLayout.SOUTH);
    }

    private void rollDice() {
        Random random = new Random();

        player1Score = random.nextInt(5) + 1;
        player2Score = random.nextInt(5) + 1;

        player1Label.setText("Player 1: " + player1Score);
        player2Label.setText("Player 2: " + player2Score);

        determineRoundWinner(player1Score, player2Score);
    }

    private void determineRoundWinner(int player1Score, int player2Score) {
        if (player1Score > player2Score) {
            resultLabel.setText(" Player 1 wins!");
            this.player1Score++;
        } else if (player1Score < player2Score) {
            resultLabel.setText("Player 2 wins!");
            this.player2Score++;
        } else {
            resultLabel.setText(" Draw!");
            draws++;
        }

        player1Label.setText("Player 1: " + this.player1Score);
        player2Label.setText("Player 2: " + this.player2Score);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        int x1 = 100;
        int x2 = 300;
        int y = 100;

        drawDice(g, x1, y, player1Score);
        drawDice(g, x2, y, player2Score);
    }

    private void drawDice(Graphics g, int x, int y, int value) {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, DICE_SIZE, DICE_SIZE);
        g.setColor(Color.BLACK);
        g.drawRect(x, y, DICE_SIZE, DICE_SIZE);

        if (value == 1) {
            drawDot(g, x + DICE_SIZE / 2, y + DICE_SIZE / 2);
        } else if (value == 2) {
            drawDot(g, x + DICE_SIZE / 4, y + DICE_SIZE / 4);
            drawDot(g, x + 3 * DICE_SIZE / 4, y + 3 * DICE_SIZE / 4);
        } else if (value == 3) {
            drawDot(g, x + DICE_SIZE / 4, y + DICE_SIZE / 4);
            drawDot(g, x + DICE_SIZE / 2, y + DICE_SIZE / 2);
            drawDot(g, x + 3 * DICE_SIZE / 4, y + 3 * DICE_SIZE / 4);
        } else if (value == 4) {
            drawDot(g, x + DICE_SIZE / 4, y + DICE_SIZE / 4);
            drawDot(g, x + 3 * DICE_SIZE / 4, y + DICE_SIZE / 4);
            drawDot(g, x + DICE_SIZE / 4, y + 3 * DICE_SIZE / 4);
            drawDot(g, x + 3 * DICE_SIZE / 4, y + 3 * DICE_SIZE / 4);
        } else if (value == 5) {
            drawDot(g, x + DICE_SIZE / 4, y + DICE_SIZE / 4);
            drawDot(g, x + 3 * DICE_SIZE / 4, y + DICE_SIZE / 4);
            drawDot(g, x + DICE_SIZE / 2, y + DICE_SIZE / 2);
            drawDot(g, x + DICE_SIZE / 4, y + 3 * DICE_SIZE / 4);
            drawDot(g, x + 3 * DICE_SIZE / 4, y + 3 * DICE_SIZE / 4);
        } else if (value == 6) {
            drawDot(g, x + DICE_SIZE / 4, y + DICE_SIZE / 4);
            drawDot(g, x + DICE_SIZE / 4, y + DICE_SIZE / 2);
            drawDot(g, x + DICE_SIZE / 4, y + 3 * DICE_SIZE / 4);
            drawDot(g, x + 3 * DICE_SIZE / 4, y + DICE_SIZE / 4);
            drawDot(g, x + 3 * DICE_SIZE / 4, y + DICE_SIZE / 2);
            drawDot(g, x + 3 * DICE_SIZE / 4, y + 3 * DICE_SIZE / 4);
        }
    }

    private void drawDot(Graphics g, int x, int y) {
        g.fillOval(x - 5, y - 5, 10, 10);
    }

}

public class Lab12Prb7 {


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                DiceRollGame game = new DiceRollGame();
                game.setVisible(true);
            }
        });
    }
}
