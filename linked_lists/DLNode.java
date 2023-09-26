package linked_lists;

// Used for doubly linked list
public class DLNode {
    private DLNode prev;
    private DLNode next;
    private int data;

    public DLNode() {

    }

    public DLNode(int data) {
        this.data = data;
    }

    public DLNode getPrev() {
        return prev;
    }

    public DLNode getNext() {
        return next;
    }

    public int getData() {
        return data;
    }

    public void setPrev(DLNode prev) {
        this.prev = prev;
    }

    public void setNext(DLNode next) {
        this.next = next;
    }

    public void setData(int data) {
        this.data = data;
    }
}
