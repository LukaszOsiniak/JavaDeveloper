package pl.coderstrust.multithreadingmagazine;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Container {

    private static final int NUMBER_OF_PRODUCERS = 5;
    private static final int NUMBER_OF_CONSUMERS = 2;
    private static int SIZE_OF_COLLECTION = 10;

    public static BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(SIZE_OF_COLLECTION);

    public static void main(String[] args) {
        boolean producerShouldSleep = true;
        boolean consumerShouldSleep = true;

        for (int i = 0; i < NUMBER_OF_PRODUCERS; i++) {
            Producer producer = new Producer(producerShouldSleep, 1);
            Thread producerThread = new Thread(producer);
            producerThread.start();
        }
        for (int i = 0; i < NUMBER_OF_CONSUMERS; i++) {
            Consumer consumer = new Consumer(consumerShouldSleep, 1);
            Thread consumerThread = new Thread(consumer);
            consumerThread.start();
        }
    }
}
