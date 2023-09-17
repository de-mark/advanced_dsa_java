package deque;

public class DequeStack {
    private Deque store;

    public DequeStack(int size) {
        store = new Deque(size);
    }

    public boolean isFull() {
        return store.isFull();
    }

    public boolean isEmpty() {
        return store.isEmpty();
    }

    public void push(int newItem) {
        if (!isFull()) {
            store.insertRight(newItem);
        } else {
            System.out.println("Stack is full; please remove before adding");
        }
    }

    public int pop() {
        if (!isEmpty()) {
            return store.deleteRight();
        } else {
            System.out.println("Stack is empty; please add items to stack before removing");
            return -1;
        }
    }

    public int peek() {
        if (!isEmpty()) {
            return store.peekRight();
        } else {
            System.out.println("Stack is empty; please add items to stack before peeking.");
            return -1;
        }
    }
}
