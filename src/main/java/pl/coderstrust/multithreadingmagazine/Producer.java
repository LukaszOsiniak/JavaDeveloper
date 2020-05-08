package pl.coderstrust.multithreadingmagazine;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Producer extends ProducerConsumerBase {

    public Producer(int numberOfSeconds, BlockingQueue<Integer> queue) {
        super(numberOfSeconds, queue);
    }

    @Override
    public void processContainer() {
        Random random = new Random();
        int element = random.nextInt();
        boolean added = queue.offer(element);
        if (added) {
            System.out.println("Producer " + Thread.currentThread().getId() + " put: " + element);
        } else {
            System.out.println("Producer " + Thread.currentThread().getId() + ": The Container is full");
        }
    }
}
