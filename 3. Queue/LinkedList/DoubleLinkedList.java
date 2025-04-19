package LinkedList;

public class DoubleLinkedList {

    private DllNode header;
    private DllNode trailer;

    public DoubleLinkedList() {
        header = new DllNode(null);
        trailer = new DllNode(null);
        header.setNext(trailer);
        trailer.setPrev(header);
    }

    public void addLast(Object item) {
        DllNode newNode = new DllNode(item);
        newNode.setPrev(trailer.getPrev());
        newNode.setNext(trailer);
        trailer.getPrev().setNext(newNode);
        trailer.setPrev(newNode);
    }

    public Object removeFirst() {
        if (header.getNext() == trailer) {
            return null; // List is empty
        }
        DllNode firstNode = header.getNext();
        header.setNext(firstNode.getNext());
        firstNode.getNext().setPrev(header);
        return firstNode.getData();
    }

    public boolean isEmpty() {
        return header.getNext() == trailer;
    }

    public void clear() {
        header.setNext(trailer);
        trailer.setPrev(header);
    }

    public DllNode getHeader() {
        return header;
    }

    public DllNode getTrailer() {
        return trailer;
    }

    
}
