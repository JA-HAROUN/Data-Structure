public class DoubleLinkedList {

    private DllNode header;
    private DllNode trailer;
    private int size;

    public DoubleLinkedList() {
        this.header = new DllNode(null);
        this.trailer = new DllNode(null);
        this.header.setNext(trailer);
        this.trailer.setPrev(header);
        this.size = 0;
    }

    public void addFirst(Object data) {
        DllNode newNode = new DllNode(data);
        newNode.setNext(header.getNext());
        newNode.setPrev(header);
        header.getNext().setPrev(newNode);
        header.setNext(newNode);
        size++;
    }

    public void addLast(Object data) {
        DllNode newNode = new DllNode(data);
        newNode.setPrev(trailer.getPrev());
        newNode.setNext(trailer);
        trailer.getPrev().setNext(newNode);
        trailer.setPrev(newNode);
        size++;
    }

    public void removeFirst() {
        if (size == 0) {
            return;
        }
        header.getNext().getNext().setPrev(header);
        header.setNext(header.getNext().getNext());
        size--;
    }

    public void removeLast() {
        if (size == 0) {
            return;
        }
        trailer.getPrev().getPrev().setNext(trailer);
        trailer.setPrev(trailer.getPrev().getPrev());
        size--;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Object getFirst() {
        if (isEmpty()) {
            return null;
        }
        return header.getNext().getData();
    }

    public Object getLast() {
        if (isEmpty()) {
            return null;
        }
        return trailer.getPrev().getData();
    }

    public void clear() {
        header.setNext(trailer);
        trailer.setPrev(header);
        size = 0;
    }

    public void printList() {
        DllNode current = header.getNext();
        while (current != trailer) {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        }
        System.out.println();
    }

    public void get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        DllNode current = header.getNext();
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        System.out.println(current.getData());
    }

    public int indexOf(Object data) {
        DllNode current = header.getNext();
        int index = 0;
        while (current != trailer) {
            if (current.getData().equals(data)) {
                return index;
            }
            current = current.getNext();
            index++;
        }
        return -1; // Not found
    }

    public void remove(Object data) {
        DllNode current = header.getNext();
        while (current != trailer) {
            if (current.getData().equals(data)) {
                current.getPrev().setNext(current.getNext());
                current.getNext().setPrev(current.getPrev());
                size--;
                return;
            }
            current = current.getNext();
        }
    }

    public void add(int index, Object data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (index == 0) {
            addFirst(data);
        } else if (index == size) {
            addLast(data);
        } else {
            DllNode newNode = new DllNode(data);
            DllNode current = header.getNext();
            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }
            newNode.setPrev(current.getPrev());
            newNode.setNext(current);
            current.getPrev().setNext(newNode);
            current.setPrev(newNode);
            size++;
        }
    }

    public void set(int index, Object data) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        DllNode current = header.getNext();
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        current.setData(data);
    }

    public boolean contains(Object data) {
        DllNode current = header.getNext();
        while (current != trailer) {
            if (current.getData().equals(data)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }
}
