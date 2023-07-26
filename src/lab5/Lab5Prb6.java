package lab5;

import java.util.Scanner;

/**
 * Cacu Razvan
 * Define an interface called ChessPiece which defines the prototype for the method move(). Create the specific classes
 * for each of the chess pieces and implement the move() method according to the rules of movement on the chess board.
 * The method takes as input the chess piece’s current location and the direction of the move given by the geographical
 * coordinates (N, S, E, V, NE, NV, SE, SV), and returns the final position of the piece. Pay attention to the pieces which can
 * move a different number of cells!!
 */

interface ChessPiece {
    int[] move(int[] currentPos, String direction);

    default void checkFinalPosition(int[] finalPosition) {
        if (finalPosition[0] < 0 || finalPosition[0] > 7 || finalPosition[1] < 0 || finalPosition[1] > 7) {
            throw new IllegalArgumentException("Invalid move: out of bounds");
        }
    }

    void printValidDirections();

    String getPieceForm();
}

class Pawn implements ChessPiece {
    public int[] move(int[] currentPosition, String direction) {
        int[] finalPosition = new int[2];

        switch (direction.toUpperCase()) {
            case "N" -> {
                finalPosition[0] = currentPosition[0];
                finalPosition[1] = currentPosition[1] + 1;
            }
            case "NE" -> {
                finalPosition[0] = currentPosition[0] + 1;
                finalPosition[1] = currentPosition[1] + 1;
            }
            case "NV" -> {
                finalPosition[0] = currentPosition[0] - 1;
                finalPosition[1] = currentPosition[1] + 1;
            }
            default -> System.out.println("Invalid direction for pawn");
        }

        checkFinalPosition(finalPosition);

        return finalPosition;
    }

    @Override
    public void printValidDirections() {
        System.out.println("Valid directions for Pawn: N, NE, NV");
    }

    @Override
    public String getPieceForm() {
        return "♙";
    }

}

class Rook implements ChessPiece {

    public int[] move(int[] currentPosition, String direction) {
        int[] finalPosition = new int[2];
        int increment = Lab5Prb6.getIncrement();


        switch (direction.toUpperCase()) {
            case "N" -> {
                finalPosition[0] = currentPosition[0];
                finalPosition[1] = currentPosition[1] + increment;
            }
            case "S" -> {
                finalPosition[0] = currentPosition[0];
                finalPosition[1] = currentPosition[1] - increment;
            }
            case "E" -> {
                finalPosition[0] = currentPosition[0] + increment;
                finalPosition[1] = currentPosition[1];
            }
            case "V" -> {
                finalPosition[0] = currentPosition[0] - increment;
                finalPosition[1] = currentPosition[1];
            }
            default -> {
                System.out.println("Invalid direction for rook!");
            }

        }
        checkFinalPosition(finalPosition);

        return finalPosition;

    }


    @Override
    public void printValidDirections() {
        System.out.println("Valid directions for Rook: N, S, E, V");
    }

    @Override
    public String getPieceForm() {
        return "♖";
    }
}

class King implements ChessPiece {
    public int[] move(int[] currentPosition, String direction) {
        int[] finalPosition = new int[2];

        switch (direction.toUpperCase()) {
            case "N" -> {
                finalPosition[0] = currentPosition[0];
                finalPosition[1] = currentPosition[1] + 1;
            }
            case "S" -> {
                finalPosition[0] = currentPosition[0];
                finalPosition[1] = currentPosition[1] - 1;
            }
            case "E" -> {
                finalPosition[0] = currentPosition[0] + 1;
                finalPosition[1] = currentPosition[1];
            }
            case "V" -> {
                finalPosition[0] = currentPosition[0] - 1;
                finalPosition[1] = currentPosition[1];
            }
            case "NE" -> {
                finalPosition[0] = currentPosition[0] + 1;
                finalPosition[1] = currentPosition[1] + 1;
            }
            case "NV" -> {
                finalPosition[0] = currentPosition[0] - 1;
                finalPosition[1] = currentPosition[1] + 1;
            }
            case "SE" -> {
                finalPosition[0] = currentPosition[0] + 1;
                finalPosition[1] = currentPosition[1] - 1;
            }
            case "SV" -> {
                finalPosition[0] = currentPosition[0] - 1;
                finalPosition[1] = currentPosition[1] - 1;
            }
            default -> System.out.println("Invalid direction for king!");
        }

        checkFinalPosition(finalPosition);

        return finalPosition;
    }

    public void printValidDirections() {
        System.out.println("Valid directions for King: N, S, E, V, NE, NV, SE, SV");
    }

    @Override
    public String getPieceForm() {
        return "♔";
    }
}

class Bishop implements ChessPiece {
    public int[] move(int[] currentPosition, String direction) {
        int[] finalPosition = new int[2];
        int increment = Lab5Prb6.getIncrement();

        switch (direction.toUpperCase()) {
            case "NE" -> {
                finalPosition[0] = currentPosition[0] + increment;
                finalPosition[1] = currentPosition[1] + increment;
            }
            case "NV" -> {
                finalPosition[0] = currentPosition[0] - increment;
                finalPosition[1] = currentPosition[1] + increment;
            }
            case "SE" -> {
                finalPosition[0] = currentPosition[0] + increment;
                finalPosition[1] = currentPosition[1] - increment;
            }
            case "SV" -> {
                finalPosition[0] = currentPosition[0] - increment;
                finalPosition[1] = currentPosition[1] - increment;
            }
            default -> System.out.println("Invalid direction for bishop!");
        }

        checkFinalPosition(finalPosition);

        return finalPosition;
    }


    @Override
    public void printValidDirections() {
        System.out.println("Valid directions for Bishop: NE, NV, SE, SV");
    }

    @Override
    public String getPieceForm() {
        return "♗";
    }
}

class Knight implements ChessPiece {
    public int[] move(int[] currentPosition, String direction) {
        int[] finalPosition = new int[2];

        switch (direction.toUpperCase()) {
            case "NNV" -> {
                finalPosition[0] = currentPosition[0] - 1;
                finalPosition[1] = currentPosition[1] + 2;
            }
            case "NNE" -> {
                finalPosition[0] = currentPosition[0] + 1;
                finalPosition[1] = currentPosition[1] + 2;
            }
            case "NVV" -> {
                finalPosition[0] = currentPosition[0] - 2;
                finalPosition[1] = currentPosition[1] + 1;
            }
            case "NEE" -> {
                finalPosition[0] = currentPosition[0] + 2;
                finalPosition[1] = currentPosition[1] + 1;
            }
            case "SSV" -> {
                finalPosition[0] = currentPosition[0] - 1;
                finalPosition[1] = currentPosition[1] - 2;
            }
            case "SSE" -> {
                finalPosition[0] = currentPosition[0] + 1;
                finalPosition[1] = currentPosition[1] - 2;
            }
            case "SVV" -> {
                finalPosition[0] = currentPosition[0] - 2;
                finalPosition[1] = currentPosition[1] - 1;
            }
            case "SEE" -> {
                finalPosition[0] = currentPosition[0] + 2;
                finalPosition[1] = currentPosition[1] - 1;
            }
            default -> System.out.println("Invalid direction for knight!");
        }

        checkFinalPosition(finalPosition);
        return finalPosition;
    }

    @Override
    public void printValidDirections() {
        System.out.println("Valid directions for Knight: NNV, NNE, NVV, NEE, SSV, SSE, SVV, SEE");
    }

    @Override
    public String getPieceForm() {
        return "♘";
    }
}

class Queen implements ChessPiece {
    public int[] move(int[] currentPosition, String direction) {
        int[] finalPosition = new int[2];
        int increment = Lab5Prb6.getIncrement();

        switch (direction.toUpperCase()) {
            case "N" -> {
                finalPosition[0] = currentPosition[0];
                finalPosition[1] = currentPosition[1] + increment;
            }
            case "S" -> {
                finalPosition[0] = currentPosition[0];
                finalPosition[1] = currentPosition[1] - increment;
            }
            case "E" -> {
                finalPosition[0] = currentPosition[0] + increment;
                finalPosition[1] = currentPosition[1];
            }
            case "V" -> {
                finalPosition[0] = currentPosition[0] - increment;
                finalPosition[1] = currentPosition[1];
            }
            case "NE" -> {
                finalPosition[0] = currentPosition[0] + increment;
                finalPosition[1] = currentPosition[1] + increment;
            }
            case "NV" -> {
                finalPosition[0] = currentPosition[0] - increment;
                finalPosition[1] = currentPosition[1] + increment;
            }
            case "SE" -> {
                finalPosition[0] = currentPosition[0] + increment;
                finalPosition[1] = currentPosition[1] - increment;
            }
            case "SV" -> {
                finalPosition[0] = currentPosition[0] - increment;
                finalPosition[1] = currentPosition[1] - increment;
            }
            default -> {
                System.out.println("Invalid direction for queen !");
            }

        }

        checkFinalPosition(finalPosition);

        return finalPosition;
    }


    @Override
    public void printValidDirections() {
        System.out.println("Valid directions for Queen: N, S, E, V, NE, NV, SE, SV");
    }

    @Override
    public String getPieceForm() {
        return "♕";
    }

}

public class Lab5Prb6 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean continuePlaying = true;
        ChessPiece currentPiece = null;
        int[] currentPosition = null;
        String direction;
        String pieceName = null;

        do {
            if (currentPiece == null) {
                System.out.println("Choose a chess piece to move (type the name of the piece, or 'quit' to exit):");
                pieceName = input.nextLine();
                if (pieceName.equalsIgnoreCase("quit")) {
                    continuePlaying = false;
                    break;
                }

                switch (pieceName.toLowerCase()) {
                    case "pawn" -> {
                        currentPiece = new Pawn();
                        currentPosition = getCurrentPosition(input, "pawn");
                    }
                    case "rook" -> {
                        currentPiece = new Rook();
                        currentPosition = getCurrentPosition(input, "rook");
                    }
                    case "knight" -> {
                        currentPiece = new Knight();
                        currentPosition = getCurrentPosition(input, "knight");
                    }
                    case "bishop" -> {
                        currentPiece = new Bishop();
                        currentPosition = getCurrentPosition(input, "bishop");
                    }
                    case "queen" -> {
                        currentPiece = new Queen();
                        currentPosition = getCurrentPosition(input, "queen");
                    }
                    case "king" -> {
                        currentPiece = new King();
                        currentPosition = getCurrentPosition(input, "king");
                    }
                    default -> System.out.println("Invalid input. Please choose a valid chess piece.");
                }
            }

            if (currentPiece != null) {
                currentPiece.printValidDirections();
                System.out.println("Choose the direction to move the " + pieceName + " :");
                direction = input.nextLine().toUpperCase();

                try {
                    int[] finalPosition = currentPiece.move(currentPosition, direction);
                    System.out.println("The " + pieceName + " moved from (" + (currentPosition[0] + 1) + ", " + (currentPosition[1] + 1) + ") to (" + (finalPosition[0] + 1) + ", " + (finalPosition[1] + 1) + ").");
                    currentPosition = finalPosition;
                    displayBoardPosition(currentPosition, currentPiece.getPieceForm());
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid move: out of bounds.");
                }

                System.out.println("Do you want to continue playing with the " + pieceName + "? (Type 'yes' to continue or 'no' to choose a different chess piece)");
                String continuePlayingResponse = input.nextLine();
                if (continuePlayingResponse.equalsIgnoreCase("no")) {
                    currentPiece = null;
                }

            }
        } while (continuePlaying);

    }

    static int[] getCurrentPosition(Scanner input, String pieceName) {
        int[] position;
        do {
            System.out.println("Choose the current position of the " + pieceName + " (type two integers between 1 and 8, separated by a space):");
            int x = input.nextInt();
            int y = input.nextInt();
            input.nextLine();

            position = new int[]{x - 1, y - 1};
        }
        while (position[0] < 0 || position[0] > 7 || position[1] < 0 || position[1] > 7);

        return position;
    }

    public static void displayBoardPosition(int[] finalPosition, String pieceForm) {
        String[][] board = new String[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (j % 2 == 0) {
                    if (i % 2 == 0) {
                        board[i][j] = "□";
                    } else {
                        board[i][j] = "■";
                    }
                } else {
                    if (i % 2 == 0)
                        board[i][j] = "■";
                    else {
                        board[i][j] = "□";
                    }
                }
            }

        }
        board[finalPosition[1]][finalPosition[0]] = pieceForm;

        System.out.println("  a b c d e f g h ");
        for (int i = 7; i >= 0; i--) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < 8; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println(i + 1);
        }
        System.out.println("  a b c d e f g h ");
    }

    static int getIncrement() {
        Scanner scanner = new Scanner(System.in);
        int increment = -1;

        do {
            System.out.println("Number of squares you want to move: ");
            increment = scanner.nextInt();
        }
        while (increment < 0 || increment > 8);

        return increment;
    }
}