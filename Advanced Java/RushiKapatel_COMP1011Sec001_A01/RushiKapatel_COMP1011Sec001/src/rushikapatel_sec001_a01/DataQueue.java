package rushikapatel_sec001_a01;

import java.util.LinkedList;

public class DataQueue<T> {
    private LinkedList<T> queue;

    // Constructors
    public DataQueue() {
        this.queue = new LinkedList<>();
    }

    // Method to enqueue (add) an element to the queue
    public void enqueue(T element) {
        queue.addLast(element);
    }

    // Method to dequeue (remove) an element from the queue
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty. Cannot dequeue.");
        }
        return queue.removeFirst();
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    // Method to get the size of the queue
    public int size() {
        return queue.size();
    }

    // Method to print elements in the queue
    public void printQueue() {
        System.out.print("Queue: ");
        for (T element : queue) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
