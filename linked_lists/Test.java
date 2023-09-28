package linked_lists;

public class Test {
    public static void main(String[] args) {
        DoublyLinkedList dl = new DoublyLinkedList();

        dl.insertFirst(13);
        dl.insertLast(15);
        dl.insertAfter(13, 14);
        dl.displayForward();
    }
}
