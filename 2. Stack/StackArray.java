public class StackArray implements Stack {

    private static int size = 0;
    private static Object[] stackElements;

    // constructor
    StackArray(int capacity) {
        stackElements = new Object[capacity];
    }

    @Override
    public void push(Object element) {
        if (element == null) {
            throw new NullPointerException("Element is null");
        }
        else if (size == stackElements.length) {
            throw new IllegalStateException("Stack is full");
        }
        stackElements[size++] = element; 
    }

    @Override
    public Object pop() {
        if (size == 0) {
            throw new IllegalStateException("Stack is empty");
        }
        Object element = stackElements[--size];
        stackElements[size] = null; // Prevent memory leak
        return element;
    }

    @Override
    public Object top() {
        if (size == 0) {
            throw new IllegalStateException("Stack is empty");
        }
        return stackElements[size - 1];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            stackElements[i] = null; // Prevent memory leak
        }
        size = 0;
    }

    @Override
    public boolean contains(Object element) {
        if (element == null) {
            throw new NullPointerException("Element is null");
        }
        else if (size == 0) {
            throw new IllegalStateException("Stack is empty");
        }

        for (int i = 0; i < size; i++) {
            if (stackElements[i].equals(element)) {
                return true;
            }
        }

        return false;
        
    }

    @Override
    public Stack copy() {

        if (size == 0) {
            throw new IllegalStateException("Stack is empty");
        }

        StackArray copy = new StackArray(size);

        for (int i = 0; i < size; i++) {
            copy.push(stackElements[i]);
        }

        return copy;

    }

}