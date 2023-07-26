package lab12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

/**
 * Cacu Razvan GR-2023
 *  Implement a Java application which draws a maze made up of squares. One of the squares (the entry points) is
 * colored in a distinct color. Use the cursor to guide the square to the exit. Any mistake resets the position of the square
 * and sets it back to its original position. Display a message when the square reached the exit point.
 * * Instead of the cursor, use the mouse's position to navigate through the maze.
 * ** Touching the edges of the maze or exiting it, resets the game
 */
class MazeGame extends JFrame {

    private static final int SQUARE_SIZE = 30;
    private static final int MAZE_SIZE = 20;
    private static final Color WALL_COLOR = Color.BLACK;
    private static final Color START_COLOR = Color.GREEN;
    private static final Color END_COLOR = Color.RED;

    private int[][] maze = new int[MAZE_SIZE][MAZE_SIZE];
    private Point playerPosition;

    public MazeGame() {
        setSize(MAZE_SIZE * SQUARE_SIZE, MAZE_SIZE * SQUARE_SIZE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        maze = new int[][]{
                {2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1},
                {1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1},
                {1, 1, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1},
                {1, 0, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1},
                {1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1},
                {1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 1, 1, 1, 0, 1, 0, 0, 0, 1},
                {1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1},
                {1, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1},
                {1, 1, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 1},
                {1, 1, 1, 1, 0, 0, 1, 0, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1, 0, 1},
                {1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 1, 0, 1},
                {1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1},
                {1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1},
                {1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1},
                {1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 3}
        };

        playerPosition = new Point(1, 1);

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                int x = e.getX() / SQUARE_SIZE;
                int y = e.getY() / SQUARE_SIZE;
                if (x == playerPosition.x && y == playerPosition.y) {
                    return;
                }
                if (maze[y][x] == 1) {
                    JOptionPane.showMessageDialog(null, "Game Over!");
                    System.exit(0);
                } else if (maze[y][x] == 3) {
                    JOptionPane.showMessageDialog(null, "You win!");
                    playerPosition = new Point(1, 1);
                } else {
                    playerPosition = new Point(x, y);
                }
                repaint();
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        for (int i = 0; i < MAZE_SIZE; i++) {
            for (int j = 0; j < MAZE_SIZE; j++) {
                if (maze[i][j] == 1) {
                    g.setColor(WALL_COLOR);
                } else if (maze[i][j] == 2) {
                    g.setColor(START_COLOR);
                } else if (maze[i][j] == 3) {
                    g.setColor(END_COLOR);
                } else {
                    g.setColor(Color.WHITE);
                }
                g.fillRect(j * SQUARE_SIZE, i * SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE);
            }
        }

        g.setColor(Color.BLUE);
        g.fillRect(playerPosition.x * SQUARE_SIZE, playerPosition.y * SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE);
    }
}

public class Lab12Prb6 {

    public static void main(String[] args) {
        MazeGame game = new MazeGame();
        game.setVisible(true);
    }
}
