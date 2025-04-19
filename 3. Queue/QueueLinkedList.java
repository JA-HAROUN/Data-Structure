import LinkedList.DoubleLinkedList;
import LinkedList.DllNode;

public class QueueLinkedList implements Queue {

    private int size;
    private DllNode front;
    private DllNode rear;
    private DoubleLinkedList queue;

    // Constructor
    public QueueLinkedList() {
        this.queue = new DoubleLinkedList();
        this.size = 0;
        this.front = queue.getHeader();
        this.rear = queue.getTrailer();
    }


    @Override
    public void enqueue(Object item) {

        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }
        queue.addLast(item);
        size++;
        rear = queue.getTrailer();

    }

    @Override
    public Object dequeue() {

        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        Object item = queue.removeFirst();
        size--;
        front = queue.getHeader();
        return item;

    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    @Override
    public int size() {

        return size;

    }

    @Override
    public Object front() {

        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return queue.getHeader().getNext().getData();

    }

    @Override
    public void clear() {
        
        queue.clear();
        size = 0;


    }

    @Override
    public boolean contains(Object item) {

        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }
        DllNode current = queue.getHeader().getNext();
        while (current != queue.getTrailer()) {
            if (current.getData().equals(item)) {
                return true;
            }
            current = current.getNext();
        }
        return false;

    }
    
}
