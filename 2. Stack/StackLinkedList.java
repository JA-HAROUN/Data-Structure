import LinkedList.*;

public class StackLinkedList implements Stack {

    private SLL stackList;
    private int size = 0;

    // Constructor
    public StackLinkedList() {
        this.stackList = new SLL();
        this.size = 0;
    }

    @Override
    public void push(Object element) {

        if (element == null) {
            throw new NullPointerException("Element is null");
        }
        stackList.addFirst(element);
        size++;
    }

    @Override
    public Object pop() {
        if (size == 0) {
            throw new IllegalStateException("Stack is empty");
        }
        Object element = stackList.removeFirst();
        size--;
        return element;
    }

    @Override
    public Object top() {

        if (size == 0) {
            throw new IllegalStateException("Stack is empty");
        }

        return stackList.getHead().getNext();

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
        if (size == 0) {
            throw new IllegalStateException("Stack is empty");
        }

        stackList.setHead(null);
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

        SLLNode current = stackList.getHead();
        while (current != null) {
            if (current.getElement().equals(element)) {
                return true;
            }
            current = current.getNext();
        }

        return false;

    }

    @Override
    public Stack copy() {
        if (size == 0) {
            throw new IllegalStateException("Stack is empty");
        }

        StackLinkedList temp = new StackLinkedList();
        StackLinkedList copy = new StackLinkedList();

        for(int i = 0; i < size; i++) {
            temp.push(stackList.getHead().getElement());
            stackList.setHead(stackList.getHead().getNext());
        }

        for(int i = 0; i < size; i++) {
            Object element = temp.pop();
            copy.push(element);
            stackList.addFirst(element);
        }

        return copy;

    }
    
}
