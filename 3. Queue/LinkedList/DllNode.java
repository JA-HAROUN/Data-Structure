package LinkedList;

public class DllNode {

    private Object data;
    private DllNode next;
    private DllNode prev;

    public DllNode(Object data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public DllNode getNext() {
        return next;
    }

    public void setNext(DllNode next) {
        this.next = next;
    }

    public DllNode getPrev() {
        return prev;
    }

    public void setPrev(DllNode prev) {
        this.prev = prev;
    }
    
}
