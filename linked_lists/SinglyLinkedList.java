package linked_lists;

public class SinglyLinkedList {
    private Node head;

    public SinglyLinkedList() {
        // head will automatically be set to NULL
    }

    public boolean isEmpty() {
        return head == null;
    }

    public Node getHead() {
        return head;
    }

    // Linked list = new LinkedList();
    // ListIterator iter1 = list.getIterator();
    // Node n = iter1.getCurrent();
    // iter1.nextNode();
    public ListIterator getIterator() {
        return new ListIterator(this);
    }

    // Only happens if the list is empty
    public void insertFirst(int data) {
        Node newNode = new Node(data);

        newNode.setNext(head);

        head = newNode;
    }

    public Node deleteFirst() {
        Node temp = head;

        head = head.getNext();

        return temp;
    }

    public Node find(int key) {
        Node curr = head;

        while (curr != null) {
            if (curr.getData() == key) {
                return curr;
            }
            curr = curr.getNext();
        }

        return curr;
    }

    // This still needs to be optimized and stuff
    // For example, if
    public Node delete(int key) {
        Node curr = head;
        Node prev = null;

        while (curr.getData() != key) {
            if (curr.getNext() == null) {
                return null;
            }

            prev = curr;
            curr = curr.getNext();
        }

        if (curr == head) {
            head = head.getNext();
        }

        prev.setNext(curr.getNext());

        return curr;

    }

    // We'll add display method in next class
    public void display() {
        Node curr = head;

        while (curr != null) {
            System.out.printf("%d -> ", curr.getData());
            curr = curr.getNext();
        }
    }
    // That and double-ended linked list
    // Also doubly linked list
}
