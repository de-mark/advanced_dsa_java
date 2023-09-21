package linked_lists;

public class Queue {
    DoubleEnded store;

    public Queue() {
        this.store = new DoubleEnded();
    }

    public boolean isEmpty() {
        return store.isEmpty();
    }

    public void insert(int data) {
        store.insertEnd(data);
    }

    public int dequeue() {
        return store.deleteFirst().getData();
    }

    public int peek() {
        return store.getHead().getData();
    }
}
