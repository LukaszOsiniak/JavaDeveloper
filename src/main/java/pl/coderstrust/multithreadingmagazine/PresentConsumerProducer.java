package pl.coderstrust.multithreadingmagazine;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class PresentConsumerProducer {

    private static final int SIZE_OF_COLLECTION = 10;
    private static final int SECONDS_SCALE = 1000;

    public static void main(String[] args) throws InterruptedException {
        PresentConsumerProducer presentConsumerProducer = new PresentConsumerProducer();
        presentConsumerProducer.present(2, 4, 4);
        presentConsumerProducer.present(4, 2, 4);
    }

    public void present(int numberOfProducers, int numberOfConsumers, int presentationTimeoutSeconds) throws InterruptedException {
        System.out.println("=======================");
        System.out.println("Presenting Producer and Consumer. Nb of Producers: " + numberOfProducers + " Nb of Consumers: " + numberOfConsumers);
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(SIZE_OF_COLLECTION);
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < numberOfProducers; i++) {
            ProducerConsumerBase producer = new Producer(1, queue);
            threads.add(new Thread(producer));
        }
        for (int i = 0; i < numberOfConsumers; i++) {
            ProducerConsumerBase consumer = new Consumer(1, queue);
            threads.add(new Thread(consumer));
        }

        for (Thread thread : threads) {
            thread.start();
        }
        Thread.currentThread().join(presentationTimeoutSeconds * SECONDS_SCALE);

        for (Thread thread : threads) {
            thread.interrupt();
        }
        System.out.println("Producer Consumer threads stopped");
    }
}
