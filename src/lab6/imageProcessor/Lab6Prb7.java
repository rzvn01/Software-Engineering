package lab6.imageProcessor;

import java.util.Random;
import java.util.Scanner;

class Pixel {
    private int R;
    private int G;
    private int B;

    public Pixel(int r, int g, int b) {
        R = r;
        G = g;
        B = b;
    }

    public int getR() {
        return R;
    }

    public void setR(int r) {
        R = r;
    }

    public int getG() {
        return G;
    }

    public void setG(int g) {
        G = g;
    }

    public int getB() {
        return B;
    }

    public void setB(int b) {
        B = b;
    }

}

 class MyImage {
    private final Pixel[][] pixels;
    private final int m;
    private final int n;

    public MyImage(int m, int n) {
        this.m = m;
        this.n = n;
        pixels = new Pixel[m][n];
        Random rand = new Random();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                pixels[i][j] = new Pixel(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
            }
        }
    }

    public void cancelPixels(int r, int g, int b) {
        long startTime = System.nanoTime();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pixels[i][j].getR() < r && pixels[i][j].getG() < g && pixels[i][j].getB() < b) {
                    pixels[i][j].setR(0);
                    pixels[i][j].setG(0);
                    pixels[i][j].setB(0);
                }
            }
        }
        long endTime = System.nanoTime();
        System.out.println("\nTime for cancelling pixels: " + (endTime - startTime) + " ns");
    }

    public void deleteComponent(char component) {
        long startTime = System.nanoTime();
        switch (component) {
            case 'R' -> {
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        pixels[i][j].setR(0);
                    }
                }
            }
            case 'G' -> {
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        pixels[i][j].setG(0);
                    }
                }
            }
            case 'B' -> {
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        pixels[i][j].setB(0);
                    }
                }
            }
            default -> System.out.println("\nInvalid component specified.");
        }
        long endTime = System.nanoTime();
        System.out.println("\nTime for deleting component: " + (endTime - startTime) + " ns");
    }

    public void grayscale() {
        long startTime = System.nanoTime();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int gray = (int) (0.21 * pixels[i][j].getR() + 0.71 * pixels[i][j].getG() + 0.07 * pixels[i][j].getB());
                pixels[i][j].setR(gray);
                pixels[i][j].setG(gray);
                pixels[i][j].setB(gray);
            }
        }
        long endTime = System.nanoTime();
        System.out.println("\nTime for grayscale conversion: " + (endTime - startTime) + " ns");
    }

    public void printPixels() {
        long startTime = System.nanoTime();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("(" + pixels[i][j].getR() + ", " + pixels[i][j].getG() + ", " + pixels[i][j].getB() + ") ");
            }
            System.out.println();
        }
        long endTime = System.nanoTime();
        System.out.println("\nTime for printing pixels: " + (endTime - startTime) + " ns");
    }

 }
public class Lab6Prb7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m,n,r,g,b;

        do {
            System.out.println("Value of m size:");
            m=scanner.nextInt();
        }while (m<1);

        do {
            System.out.println("Value of n size:");
            n=scanner.nextInt();
        }while (n<1);

        MyImage image = new MyImage(m,n);

        System.out.println("Original image:");
        image.printPixels();

        do {
            System.out.println("Red value limit: ");
            r=scanner.nextInt();
        }while (r<0);

        do {
            System.out.println("Blue value limit: ");
            b=scanner.nextInt();
        }while (b<0);

        do {
            System.out.println("Green value limit: ");
            g=scanner.nextInt();
        }while (g<0);

        image.cancelPixels(r, g, b);
        System.out.println("Image after cancelling pixels below R=" + r + ", G=" + g + ", B=" + b + ":");
        image.printPixels();

        System.out.println("Which component to delete ?(R,G,B):");
        String component = scanner.next().toUpperCase();
        image.deleteComponent(component.charAt(0));
        System.out.println("Image after deleting " + component + " component:");
        image.printPixels();

        image.grayscale();
        System.out.println("Image after grayscale conversion:");
        image.printPixels();
    }

}