package rushikapatel_sec001_ex01;

import java.util.LinkedList;

public class DataQueue<T> {
    private LinkedList<T> data;

    // Constructor to initialize the queue
    public DataQueue() {
        this.data = new LinkedList<>();
    }

    // Method to enqueue (add) an element to the queue
    public void enqueue(T element) {
        data.addLast(element); // Add the element to the end of the queue
    }

    // Method to dequeue (remove) an element from the queue
    public T dequeue() {
        if (isEmpty()) { // Check if the queue is empty
            throw new IllegalStateException(" Cannot dequeue.Because Queue is empty. ");
        }
        return data.removeFirst(); // Remove and return the first element from the queue
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return data.isEmpty(); // Check if the queue is empty
    }

    // Method to get the size of the queue
    public int size() {
        return data.size(); // Return the size of the queue
    }

    // Method to print elements in the queue
    public void printQueue() {
        System.out.print("Queue: ");
        for (T element : data) { // Iterate over each element in the queue
            System.out.print(element + " "); // Print each element followed by a space
        }
        System.out.println(); // Print a new line after printing all elements
    }
}
