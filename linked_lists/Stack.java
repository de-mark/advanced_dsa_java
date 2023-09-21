package linked_lists;

public class Stack {
    private SinglyLinkedList store;

    public Stack() {
        this.store = new SinglyLinkedList();
    }

    public boolean isEmpty() {
        return store.isEmpty();
    }

    public void push(int data) {
        store.insertFirst(data);
    }

    // This is a stack; we don't use Node for return type
    public int pop() {
        return store.deleteFirst().getData();
    }

    public int peek() {
        return store.getHead().getData();
    }
}
