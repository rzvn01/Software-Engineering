package lab9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Cacu Razvan GR-2023
 * There is an urn which contains 1000 losing tickets and 1 winning ticket. There are N people around the urn (N is read
 * from the keyboard) which simultaneously extract tickets from it. The tickets are not placed back into the urn. When one
 * person extracts the winning ticket, the game stops.
 * The tickets are placed back into the urn.
 */
class Urn {
    private List<Integer> tickets;
    private int winningTicket;

    Urn() {
        tickets = new ArrayList<>(1001);
        for (int i = 0; i < 1001; i++) {
            tickets.add(i);
        }
        Collections.shuffle(tickets);
        winningTicket = (int) (Math.random() * 1001);
        System.out.println("Winning ticket: "+ winningTicket);
    }

    synchronized Integer drawTicket() {
        if (tickets.isEmpty()) {
            return null;
        }
        int drawnIndex = (int) (Math.random() * tickets.size());
        System.out.println("Ticket withdrawn: "+tickets.get(drawnIndex));
        return tickets.get(drawnIndex);
    }

    boolean isWinningTicket(int ticket) {
        return ticket == winningTicket;
    }
}

class TicketDrawer implements Runnable {
    private final Urn urn;
    private final int personNumber;
    private static volatile boolean gameIsRunning = true;

    TicketDrawer(Urn urn, int personNumber) {
        this.urn = urn;
        this.personNumber = personNumber;
    }

    @Override
    public void run() {
        while (gameIsRunning) {
            Integer drawnTicket = urn.drawTicket();
            if (drawnTicket != null && urn.isWinningTicket(drawnTicket)) {
                gameIsRunning = false;
                System.out.println("Person " + personNumber + " got the winning ticket!");
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Lab9Prb7 {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of people (N): ");
        int N = scanner.nextInt();

        Urn urn = new Urn();
        Thread[] threads = new Thread[N];

        for (int i = 0; i < N; i++) {
            threads[i] = new Thread(new TicketDrawer(urn, i + 1));
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Game over.");
    }
}