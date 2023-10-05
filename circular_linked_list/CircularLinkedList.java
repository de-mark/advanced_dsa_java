package circular_linked_list;

public class CircularLinkedList {
    private Node current;
    private int numItems;

    public CircularLinkedList() {
    }

    public boolean isEmpty() {
        return numItems == 0;
    }

    public void insert(int data) {
        Node newNode = new Node(data);

        if (isEmpty()) {
            newNode.setNext(newNode);
            current = newNode;
            numItems++;
        } else {
            newNode.setNext(current.getNext());
            current.setNext(newNode);
            current = newNode;
            numItems++;
        }

    }

    public void delete(int data) {
        Node currVal = current;

        for (int i = 0; i < numItems; i++) {
            if (currVal.getNext().getData() == data) {
                if (current == currVal.getNext()) {
                    current = currVal.getNext().getNext();
                }

                System.out.printf("Successfully deleted %d\n", data);
                currVal.setNext(currVal.getNext().getNext());
                numItems--;

                return;
            }
            currVal = currVal.getNext();
        }

        System.out.println("Item not found; could not delete");
    }

    public Node search(int data) {
        Node currVal = current;

        for (int i = 0; i < numItems; i++) {
            if (currVal.getNext().getData() == data) {
                System.out.printf("Found %d \n", data);
                return currVal.getNext();
            }
            currVal = currVal.getNext();
        }

        System.out.println("Item not found; could not delete");
        return null;
    }

    public void display() {
        Node currVal = current;

        for (int i = 0; i < numItems; i++) {
            if (i < numItems - 1) {
                System.out.printf("%d -> ", currVal.getNext().getData());
            } else {
                System.out.printf("%d \n", currVal.getNext().getData());
            }

            currVal = currVal.getNext();
        }
    }

    public void step() {

    }
}
