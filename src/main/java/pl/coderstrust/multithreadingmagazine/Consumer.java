package pl.coderstrust.multithreadingmagazine;

import java.util.concurrent.BlockingQueue;

public class Consumer extends ProducerConsumerBase {

    public Consumer(int numberOfSeconds, BlockingQueue<Integer> queue) {
        super(numberOfSeconds, queue);
    }

    private String getHeader() {
        return "Consumer [" + Thread.currentThread().getId() + "]";
    }

    @Override
    public void processContainer(BlockingQueue<Integer> queue) throws InterruptedException {
        System.out.println(getHeader() + " is going to get element from container");
        Integer elementTaken = queue.take();
        System.out.println(getHeader() + " took: " + elementTaken);
    }
}
