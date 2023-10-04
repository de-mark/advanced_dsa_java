package linked_lists;

public class ListIterator {
    private Node curr;
    private Node prev;

    private SinglyLinkedList ourList;

    public ListIterator(SinglyLinkedList list) {
        ourList = list;
    }

    public void reset() {
        curr = ourList.getHead();
        prev = null;
    }

    public boolean atEnd() {
        return curr.getNext() == null;
    }

    public void nextNode() {
        if (atEnd()) {
            reset();
        } else {
            prev = curr;
            curr = curr.getNext();
        }
    }

    public Node getCurrent() {
        return curr;
    }
}
