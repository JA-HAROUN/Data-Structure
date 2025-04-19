public class QueueArray implements Queue {

    private int front;
    private int rear;
    private Object[] queue;

    public QueueArray(int capacity) {
        this.front = -1;
        this.rear = 0;
        this.queue = new Object[capacity];
    }

    
    @Override
    public void enqueue(Object item) {

        if (isFull()) {
            throw new IllegalStateException("Queue is full");
        }
        if (front == -1) {
            front = 0;
        }
        if (rear == queue.length) {
            rear = 0;
        }
        queue[rear] = item;
        rear++;
        
    }

    @Override
    public Object dequeue() {

        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        Object item = queue[front];
        queue[front] = null;
        if (front == queue.length - 1) {
            front = 0;
        } else {
            front++;
        }
        if (front == rear) {
            front = -1;
            rear = 0;
        }
        return item;

    }

    @Override
    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }


    public boolean isFull() {

        if (front == 0) {
            if (rear == queue.length) {
                return true;
            }
            return false;
        }
        if (front == rear) {
            return true;
        }
        return false;

    }

    @Override
    public int size() {
        if (front == -1) {
            return 0;
        }
        return rear - front + 1;
    }

    @Override
    public Object front() {
        if (front == -1) {
            throw new IllegalStateException("Queue is empty");
        }
        return queue[front];
    }

    @Override
    public void clear() {
        // if empty get error
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        int index = front;
        while (index < rear) {
            queue[index] = null;
            index++;
        }
        front = -1;
        rear = 0;
    }

    @Override
    public boolean contains(Object item) {
        
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        for (int i = front; i < rear; i++) {
            if (queue[i].equals(item)) {
                return true;
            }
        }
        return false;
    }


    
}
