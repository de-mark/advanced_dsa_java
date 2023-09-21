package linked_lists;

public class DoubleEnded {
    // Can use the same Node for this one
    private Node head;
    private Node tail;

    public DoubleEnded() {
        this.head = null;
        this.tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public Node getHead() {
        return head;
    }

    public void insertFirst(int data) {
        Node newNode = new Node(data);

        newNode.setNext(head);

        if (isEmpty()) {
            tail = newNode;
        }

        head = newNode;
    }

    public void insertEnd(int data) {
        if (isEmpty()) {
            insertFirst(data);
        } else {
            Node newNode = new Node(data);

            tail.setNext(newNode);

            tail = newNode;
        }
    }

    public Node deleteFirst() {
        Node temp = head;

        head = head.getNext();

        if (isEmpty()) {
            tail = null;
        }

        return temp;
    }

    public void display() {
        Node curr = head;

        while (curr != null) {
            System.out.printf("%d -> ", curr.getData());
            curr = curr.getNext();
        }
    }
}
