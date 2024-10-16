package rushikapatel_sec001_ex01;

public class DataQueueTest {
    public static void main(String[] args) {
        // Testing with a queue of strings
        DataQueue<String> stringDataQueue = new DataQueue<>();

        stringDataQueue.enqueue("Rushi");
        stringDataQueue.enqueue("Barrie");
        stringDataQueue.enqueue("Java");

        System.out.println("String in the Queue:");
        stringDataQueue.printQueue();

        // Dequeueing an element from the string queue
        String dequeuedString = stringDataQueue.dequeue();
        System.out.println("Dequeued Element from string: " + dequeuedString);
        stringDataQueue.printQueue();

        // Testing with a queue of stock values (type double)
        DataQueue<Double> stockDataQueue = new DataQueue<>();

        stockDataQueue.enqueue(185.67);
        stockDataQueue.enqueue(196.78);
        stockDataQueue.enqueue(165.45);

        System.out.println("\nStock Queue:");
        stockDataQueue.printQueue();

        // Dequeueing an element from the stock queue
        double dequeuedStock = stockDataQueue.dequeue();
        System.out.println("Dequeued Element from stock: " + dequeuedStock);
        stockDataQueue.printQueue();
    }
}
