
// IncrementThread.java
import java.util.Random;

// Counter.java
class Counter {
    private int count = 0;
    private final int MAX_COUNT = 3;
    private final int MIN_COUNT = 0;

    public synchronized void increment() {
        while (count >= MAX_COUNT) {
            System.out.println("Waiting to increment: count is at its maximum of " + MAX_COUNT);
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        count++;
        System.out.println("Incremented: count is now " + count);
        notifyAll();
    }

    public synchronized void decrement() {
        while (count <= MIN_COUNT) {
            System.out.println("Waiting to decrement: count is at its minimum of " + MIN_COUNT);
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        count--;
        System.out.println("Decremented: count is now " + count);
        notifyAll();
    }

    // Public method to get the value of count
    public synchronized int getCount() {
        return count;
    }
}



class IncrementThread extends Thread {
    private Counter counter;

    public IncrementThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        Random rand = new Random();
        for (int i = 0; i < 20; i++) {
            counter.increment();
            try {
                Thread.sleep(rand.nextInt(501)); // Sleep between 0 to 500 ms
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

class DecrementThread extends Thread {
    private Counter counter;

    public DecrementThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        Random rand = new Random();
        for (int i = 0; i < 20; i++) {
            counter.decrement();
            try {
                Thread.sleep(rand.nextInt(501)); // Sleep between 0 to 500 ms
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

// CounterUser.java
public class CounterUser {
    public static void main(String[] args) {
        Counter counter = new Counter();
        
        IncrementThread incrementThread = new IncrementThread(counter);
        DecrementThread decrementThread = new DecrementThread(counter);
        
        incrementThread.start();
        decrementThread.start();
        
        try {
            incrementThread.join();
            decrementThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        // Now you can safely access the count value
        System.out.println("Final count value: " + counter.getCount());
    }
}
