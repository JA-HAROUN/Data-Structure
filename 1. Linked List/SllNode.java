public class SllNode {
    private Object data;
    private SllNode next;

    public SllNode(Object data) {
        this.data = data;
        this.next = null;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public SllNode getNext() {
        return next;
    }

    public void setNext(SllNode next) {
        this.next = next;
    }
}