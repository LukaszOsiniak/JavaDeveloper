package pl.coderstrust.multithreadingmagazine;

import java.util.concurrent.BlockingQueue;

public abstract class ProducerConsumerBase implements Runnable {

    private static final int ONE_SECOND = 1000;

    private int numberOfSeconds;
    protected BlockingQueue<Integer> queue;

    public ProducerConsumerBase(int numberOfSeconds, BlockingQueue<Integer> queue) {
        this.numberOfSeconds = numberOfSeconds;
        this.queue = queue;
    }

    public abstract void processContainer() throws InterruptedException;

    public void run() {
        try {
            while (true) {
                processContainer();
                Thread.sleep(ONE_SECOND * numberOfSeconds);
            }
        } catch (InterruptedException exception) {
            Thread.currentThread().interrupt();
        }
    }
}
