package pl.coderstrust.multithreadingmagazine;

public class Consumer implements Runnable {

    private static final int ONE_SECOND = 1000;

    boolean shouldUseSleep;
    int numberOfSeconds;

    public Consumer(boolean shouldUseSleep, int numberOfSeconds) {
        this.shouldUseSleep = shouldUseSleep;
        this.numberOfSeconds = numberOfSeconds;
    }

    public void run() {
        try {
            while (true) {
                if (Container.queue.peek() != null) {
                    Integer elementTaken = Container.queue.take();
                    System.out.println("Consumer " + Thread.currentThread().getId() + " took: " + elementTaken);
                } else {
                    System.out.println("Consumer " + Thread.currentThread().getId() + ": The container is empty");
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
