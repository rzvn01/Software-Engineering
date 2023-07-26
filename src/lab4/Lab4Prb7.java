package lab4;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.Scanner;

/**Cacu Razvan GR-2023
 * Write an application which defines a class named Child. Define the methods and member variables for this class
 * which enble a Child object to store/do the following:
 * - the name of the child
 * - the child’s birthday
 * - the child can introduce him/herself by „saying”: Hello my name is ...
 * - the child can tell his/her age
 * - the child can add two numbers smaller than 10 and return the result like so: The sum of X and Y is equal to Z
 * - the child knows how to say Goodbye!
 * - the child can speak the alphabet both in direct and inverse order
 * - the child can color a chess board given its dimensions by using alternative colors (for the colors use the
 * symbols 1 and 0)
 * - the child can play dots and crosses (X-0) by him/herself 😊 (use the application developed in the previous
 * homework)
 * Remarks: the child’s name and birthday cannot be accessed from outside the class.
 * All the information about a Child will be filled-in using a Child object and its associated methods and variables.
 * The interaction with teh child will be done through an object which is instantiated in the main method.
 */

class Child {
    private String name;
    private String birthday;


    public Child(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public Child() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void introduce() {
        System.out.println("Hello, my name is " + name + "!");
    }

    public void getAge() {
        String[] parts = birthday.split("-");
        int year = Integer.parseInt(parts[2]);
        System.out.println("I am "+(2023-year)+" years old !");
    }

    public void add(int x, int y) {
        int z = x + y;
        System.out.println("The sum of " + x + " and " + y + " is equal to " + z);
    }

    public void goodbye() {
        System.out.println("Goodbye!");
    }

    public void speakAlphabet() {
        System.out.println("Alphabet:");
        for (char c = 'A'; c <= 'Z'; c++) {
            System.out.print(c + " ");
        }
        System.out.println();
        System.out.println("Reverse Alphabet:");
        for (char c = 'Z'; c >= 'A'; c--) {
            System.out.print(c + " ");
        }
        System.out.println();
    }

    public void colorChessBoard(int width, int height) {
        System.out.println("Chess board:");
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if ((i + j) % 2 == 0) {
                    System.out.print("1 ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
    }

    public void playCrossesAndNoughts() {
        Lab3Ex11.main(null);
    }
}


public class Lab4Prb7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Child child = new Child();

        System.out.println("The child's name: ");
        child.setName(scanner.nextLine());

        do {
            System.out.println("The child's birthdate(mm-dd-yyyy): ");
            String birthDate = scanner.nextLine();
            child.setBirthday(birthDate);
        }
        while (!isValidDateFormat(child.getBirthday()));

        child.introduce();
        child.getAge();
        child.speakAlphabet();

        System.out.println("First number to add: ");
        int first = scanner.nextInt();
        System.out.println("Second number to add: ");
        int second = scanner.nextInt();
        child.add(first, second);

        System.out.println("The width of the chess board: ");
        int width = scanner.nextInt();
        System.out.println("The height of the chess board: ");
        int height = scanner.nextInt();

        child.colorChessBoard(width, height);
        child.playCrossesAndNoughts();
        child.goodbye();

    }

    public static boolean isValidDateFormat(String dateStr) {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(dateStr);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

}

class Lab3Ex11 {
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

