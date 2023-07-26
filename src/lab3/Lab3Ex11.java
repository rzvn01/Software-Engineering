package lab3;

import java.util.Random;
import java.util.Scanner;

/*Cacu Razvan GR-2023
* Implement the naive dots and crosses game (X-O) as an automated game. The application will randomly select
at each step a position from the board at which to place the next symbol, alternating between X and O. The
selected position cannot be an already filled square. The game ends when either there are no more empty
squares on the board, or one of the symbols wins by completing a line, a column or a diagonal. Display on the
screen each step of the algorithm as a matrix. Unfilled squares will be represented by the * character.
Example:
X * *
* * *
* * *
--
X * *
* 0 *
* * *
--
X * *
* 0 *
X * *
--
X * 0
* 0 *
X * *
X * 0
X 0 *
X * *
Game over!
--------
*Extend the application so that the dimensions of the board (number of rows and columns) can be changed.
*/

public class Lab3Ex11 {
    private static final char EMPTY_PLACE = '*';
    private static final char CROSS = 'X';
    private static final char DOTS = 'O';


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] board;
        char currentPlayer = CROSS;
        int rowsNumber = 0, columnsNumber = 0, winningLength, currentRow, currentColumn;
        boolean gameOver = false;

        do {
            System.out.println("Please enter the number of rows (integer number >=3) : ");
            rowsNumber = scanner.nextInt();
        } while (rowsNumber < 3);

        do {
            System.out.println("Please enter the number of columns (integer number >=3) : ");
            columnsNumber = scanner.nextInt();
        } while (columnsNumber < 3);

        winningLength = Math.min(rowsNumber, columnsNumber);

        board = new char[rowsNumber][columnsNumber];

        for (int i = 0; i < rowsNumber; i++) {
            for (int j = 0; j < columnsNumber; j++) {
                board[i][j] = EMPTY_PLACE;
            }
        }

        while (!gameOver) {

            System.out.println("Current board:");
            printBoard(rowsNumber, columnsNumber, board);
            System.out.println(currentPlayer + "'s turn.");

            do {
                currentRow = new Random().nextInt(rowsNumber);
                currentColumn = new Random().nextInt(columnsNumber);
            } while (board[currentRow][currentColumn] != EMPTY_PLACE);

            board[currentRow][currentColumn] = currentPlayer;

            if (checkWin(currentRow, currentColumn, board, rowsNumber, columnsNumber, currentPlayer, winningLength)) {

                gameOver = true;
                System.out.println(currentPlayer + " wins!");

            } else if (checkDraw(rowsNumber, columnsNumber, board)) {

                gameOver = true;
                System.out.println("It's a tie!");

            } else {
                currentPlayer = (currentPlayer == CROSS) ? DOTS : CROSS;
            }

        }

        System.out.println("\nFinal board:");
        printBoard(rowsNumber, columnsNumber, board);

    }

    private static boolean checkWin(int currentRow, int currentColumn, char[][] board, int rowsNumber,
                                    int columnsNumber, char currentPlayer, int winningLength) {
        int count = 0;
        for (int j = 0; j < columnsNumber; j++) {
            if (board[currentRow][j] == currentPlayer) {
                count++;
                if (count == winningLength) {
                    return true;
                }
            } else {
                count = 0;
            }
        }

        count = 0;

        for (int i = 0; i < rowsNumber; i++) {
            if (board[i][currentColumn] == currentPlayer) {
                count++;
                if (count == winningLength) {
                    return true;
                }
            } else {
                count = 0;
            }
        }

        count = 0;
        for (int i = 0, j = 0; i < rowsNumber && j < columnsNumber; i++, j++) {
            if (board[i][j] == currentPlayer) {
                count++;
                if (count == winningLength) {
                    return true;
                }
            } else {
                count = 0;
            }
        }
        count = 0;
        for (int i = 0, j = columnsNumber - 1; i < rowsNumber && j >= 0; i++, j--) {
            if (board[i][j] == currentPlayer) {
                count++;
                if (count == winningLength) {
                    return true;
                }
            } else {
                count = 0;
            }
        }

        return false;
    }

    private static boolean checkDraw(int numRows, int numCols, char[][] board) {
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (board[i][j] == EMPTY_PLACE) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void printBoard(int numRows, int numCols, char[][] board) {
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("\n");
    }
}
