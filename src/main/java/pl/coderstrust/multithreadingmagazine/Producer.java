package pl.coderstrust.multithreadingmagazine;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Producer extends ProducerConsumerBase {

    private static final AtomicInteger COUNTER = new AtomicInteger();

    public Producer(int numberOfSeconds, BlockingQueue<Integer> queue) {
        super(numberOfSeconds, queue);
    }

    private String getHeader() {
        return "Producer [" + Thread.currentThread().getId() + "]";
    }

    @Override
    public void processContainer(BlockingQueue<Integer> queue) throws InterruptedException {
        int element = COUNTER.incrementAndGet();
        System.out.println(getHeader() + " is going to put: " + element);
        queue.put(element);
        System.out.println(getHeader() + " has put: " + element);
    }
}
