package linked_lists;

public class Test {
    public static void main(String[] args) {
        SinglyLinkedList l = new SinglyLinkedList();

        l.insertFirst(12);
        l.insertFirst(13);
        l.insertFirst(14);
        l.display();
        l.deleteFirst();
        l.display();
    }
}
