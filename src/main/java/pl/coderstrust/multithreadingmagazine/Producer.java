package pl.coderstrust.multithreadingmagazine;

import java.util.Random;

public class Producer implements Runnable {

    private static final int ONE_SECOND = 1000;

    boolean shouldUseSleep;
    int numberOfSeconds;

    public Producer(boolean shouldUseSleep, int numberOfSeconds) {
        this.shouldUseSleep = shouldUseSleep;
        this.numberOfSeconds = numberOfSeconds;
    }

    public void run() {
        try {
            while (true) {
                Random random = new Random();
                int element = random.nextInt();
                boolean added = Container.queue.offer(element);
                if (added) {
                    System.out.println("Producer " + Thread.currentThread().getId() + " put: " + element);
                } else {
                    System.out.println("Producer " + Thread.currentThread().getId() + ": The Container is full");
                }
                if (shouldUseSleep) {
                    Thread.sleep(ONE_SECOND);
                }
            }
        } catch (InterruptedException exception) {
            Thread.currentThread().interrupt();
        }
    }
}
