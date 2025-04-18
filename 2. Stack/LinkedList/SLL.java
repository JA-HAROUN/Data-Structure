package LinkedList;

public class SLL {

    private SLLNode head;
    private int size;

    // Constructor
    public SLL() {
        this.head = null;
    }

    // Getters
    public SLLNode getHead() {
        return head.getNext();
    }

    // Setters
    public void setHead(SLLNode head) {
        this.head = head;
    }

    // Add a new node at the head of the list
    public void addFirst(Object element) {
        SLLNode newNode = new SLLNode(element);
        newNode.setNext(head);
        head = newNode;
        size++;
    }

    // remove the first node
    public Object removeFirst() {
        if (head == null) {
            throw new IllegalStateException("List is empty");
        }
        Object element = head.getElement();
        head = head.getNext();
        size--;
        return element;
    }
    
}
