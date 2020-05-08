package pl.coderstrust.multithreadingmagazine;

import java.util.concurrent.BlockingQueue;

public class Consumer extends ProducerConsumerBase {

    public Consumer(int numberOfSeconds, BlockingQueue<Integer> queue) {
        super(numberOfSeconds, queue);
    }

    @Override
    public void processContainer() throws InterruptedException {
        Integer elementTaken = queue.take();
        System.out.println("Consumer " + Thread.currentThread().getId() + " took: " + elementTaken);
    }
}
