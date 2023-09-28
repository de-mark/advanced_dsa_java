package linked_lists;

public class DoublyLinkedList {
    private DLNode head;
    private DLNode tail;

    public DoublyLinkedList() {
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void insertFirst(int data) {
        DLNode newNode = new DLNode(data);

        newNode.setNext(head);

        if (!isEmpty()) {
            head.setPrev(newNode);
        } else {
            tail = newNode;
        }

        head = newNode;
    }

    public void insertLast(int data) {
        DLNode newNode = new DLNode(data);

        if (!isEmpty()) {
            newNode.setPrev(tail);
            tail.setNext(newNode);

        } else {
            head = newNode;
        }

        tail = newNode;
    }

    public DLNode deleteFirst() {
        DLNode temp = head;

        if (head.getNext() == null) {
            head = null;
            tail = null;
        } else if (isEmpty()) {
            return null;
        } else {
            head = head.getNext();
            head.setPrev(null);
        }

        return temp;
    }

    public DLNode deleteLast() {
        DLNode temp = tail;

        if (head.getNext() == null) {
            head = null;
            tail = null;
        } else if (isEmpty()) {
            return null;
        } else {
            tail.getPrev().setNext(null);
            tail = tail.getPrev();
        }

        return temp;
    }

    public void displayForward() {
        DLNode curr = head;

        while (curr != null) {
            System.out.print(curr.getData() + " ->");
            curr = curr.getNext();
        }
    }

    public void displayBackwards() {
        DLNode curr = tail;

        while (curr != null) {
            System.out.print(curr.getData() + " <-");
            curr = curr.getPrev();
        }
    }

    public void insertAfter(int key, int item) {
        DLNode curr = head;
        // Find the insertion point
        while (curr.getData() != key) {
            curr = curr.getNext();
            if (curr == null) {
                return;
            }
        }

        DLNode newNode = new DLNode(item);

        if (curr == tail) {
            newNode.setNext(null);
            newNode.setPrev(tail);
            tail = newNode;
        } else {
            newNode.setNext(curr.getNext());
            newNode.setPrev(curr);
            curr.getNext().setPrev(newNode);
            curr.setNext(newNode);
        }
    }

    public DLNode delete(int key) {
        DLNode curr = head;

        while (curr.getData() != key) {
            curr = curr.getNext();

            if (curr == null) {
                return null;
            }
        }

        if (curr == head) {
            head = head.getNext();
            head.setPrev(null);
        } else if (curr == tail) {
            tail = tail.getPrev();
            tail.setNext(null);
        } else {
            curr.getPrev().setNext(curr.getNext());
            curr.getNext().setPrev(curr.getPrev());
        }

        return curr;
    }
}
