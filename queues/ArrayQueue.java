package queues;

public class ArrayQueue {
    private int[] store;
    private int back;
    private int front;
    private int numItems;

    public ArrayQueue(int size) {
        store = new int[size];
        back = -1;
        front = 0;
        numItems = 0;
    }

    public boolean isFull() {
        return numItems == store.length;
    }

    public boolean isEmpty() {
        return numItems == 0;
    }

    public void insert(int item) {
        if (!isFull()) {
            if (back == store.length - 1) {
                back = -1;
            }
            back++;
            store[back] = item;
            numItems++;
        } else {
            System.out.println("Error: Full queue");
        }
    }

    public void delete() {
        if (!isEmpty()) {
            if (front == store.length - 1) {
                front = -1;
            }
            front++;
            numItems--;
        } else {
            System.out.println("Error: Empty queue");
        }

    }
}
