package lab6;

import java.util.Scanner;

class Position {
    private String point_name;
    private int x, y, z;

    public Position(String point_name, int x, int y, int z) {
        this.point_name = point_name;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public String getPointName() {
        return point_name;
    }

    public void setPointName(String point_name) {
        this.point_name = point_name;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }
}

class PointTooCloseException extends Exception {
    public PointTooCloseException(String message) {
        super(message);
    }
}

public class Lab6Prb9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Position[] positions = new Position[3];
        Position hardcodedPoint = new Position("Hardcoded", 1, 0, -2);
        int minDistance = 5;

        System.out.println("Enter the number of desired objects (maximum 3):");
        int numObjects;
        try {
            numObjects = scanner.nextInt();
            if (numObjects > 3) {
                throw new ArrayIndexOutOfBoundsException("Too many points.");
            }

            for (int i = 0; i < numObjects; i++) {
                boolean pointValid;
                 
                do {
                    pointValid = true;
                    System.out.println("lab6.Point name:");
                    String pointName = scanner.next();

                    System.out.println("X coordinate:");
                    int x = scanner.nextInt();

                    System.out.println("Y coordinate:");
                    int y = scanner.nextInt();

                    System.out.println("Z coordinate:");
                    int z = scanner.nextInt();

                    Position newPosition = new Position(pointName, x, y, z);
                    positions[i] = newPosition;

                    int distance = (int) Math.sqrt(Math.pow(x - hardcodedPoint.getX(), 2) + Math.pow(y - hardcodedPoint.getY(), 2) + Math.pow(z - hardcodedPoint.getZ(), 2));

                    try {
                        System.out.println("Distance from the hardcoded point: "+distance);
                        if (distance < minDistance) {
                            throw new PointTooCloseException("lab6.Point  too close.");
                        }
                    } catch (PointTooCloseException e) {
                        System.out.println(e.getMessage());
                        pointValid = false;
                    }

                } while (!pointValid);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }
}