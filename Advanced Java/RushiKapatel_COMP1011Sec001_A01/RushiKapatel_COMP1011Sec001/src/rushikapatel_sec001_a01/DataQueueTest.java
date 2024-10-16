package rushikapatel_sec001_a01.rushikapatel_sec001_a01;

import rushikapatel_sec001_a01.DataQueue;

public class DataQueueTest {
    public static void main(String[] args) {
        // Testing with a queue of strings
        DataQueue<String> stringQueue = new DataQueue<>();

        stringQueue.enqueue("Hello");
        stringQueue.enqueue("World");
        stringQueue.enqueue("Java");

        System.out.println("String Queue:");
        stringQueue.printQueue();

        String dequeuedString = stringQueue.dequeue();
        System.out.println("Dequeued Element: " + dequeuedString);
        stringQueue.printQueue();

        // Testing with a queue of stock values (type double)
        DataQueue<Double> stockQueue = new DataQueue<>();

        stockQueue.enqueue(145.67);
        stockQueue.enqueue(156.78);
        stockQueue.enqueue(132.45);

        System.out.println("\nStock Queue:");
        stockQueue.printQueue();

        double dequeuedStock = stockQueue.dequeue();
        System.out.println("Dequeued Element: " + dequeuedStock);
        stockQueue.printQueue();
}
}

