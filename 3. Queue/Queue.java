public interface Queue {

    // Adds an item to the end of the queue
    void enqueue(Object item);

    // Removes and returns the item at the front of the queue
    Object dequeue();

    // Returns true if the queue is empty, false otherwise
    boolean isEmpty();

    // Returns the number of items in the queue
    int size();

    // Returns the item at the front of the queue without removing it
    Object front();

    // Clears the queue
    void clear();

    // Returns true if the queue contains the specified item, false otherwise
    boolean contains(Object item);

}