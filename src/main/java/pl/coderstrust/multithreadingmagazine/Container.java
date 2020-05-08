package pl.coderstrust.multithreadingmagazine;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Container {

    private static final int NUMBER_OF_PRODUCERS = 5;
    private static final int NUMBER_OF_CONSUMERS = 2;
    private static final int SIZE_OF_COLLECTION = 10;

    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(SIZE_OF_COLLECTION);

        for (int i = 0; i < NUMBER_OF_PRODUCERS; i++) {
            Producer producer = new Producer(1, queue);
            Thread producerThread = new Thread(producer);
            producerThread.start();
        }
        for (int i = 0; i < NUMBER_OF_CONSUMERS; i++) {
            Consumer consumer = new Consumer(1, queue);
            Thread consumerThread = new Thread(consumer);
            consumerThread.start();
        }
    }
}
