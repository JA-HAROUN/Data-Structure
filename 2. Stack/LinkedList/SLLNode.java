package LinkedList;

public class SLLNode {

    private Object element;
    private SLLNode next;

    // Constructor
    public SLLNode(Object element) {
        this.element = element;
        this.next = null;
    }

    // Getters and Setters
    public Object getElement() {
        return element;
    }
    
    public void setElement(Object element) {
        this.element = element;
    }
    
    public SLLNode getNext() {
        return next;
    }

    public void setNext(SLLNode next) {
        this.next = next;
    }
    
}
