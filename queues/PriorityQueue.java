package queues;

public class PriorityQueue {
    private int[] store;
    private int nItems;

    public PriorityQueue(int size) {
        store = new int[size];
        nItems = 0;
    }

    public boolean isEmpty() {
        return nItems == 0;
    }

    public boolean isFull() {
        return nItems == store.length;
    }

    public void insert(int item) {
        if (isEmpty()) {
            store[nItems++] = item;
        } else if (isFull()) {
            System.out.println("Error - Priority Queue is full. Please delete before adding.");
        } else {
            int i;
            for (i = nItems - 1; i >= 0; i--) {
                if (item < store[i]) {
                    store[i + 1] = store[i];
                } else {
                    break;
                }
            }
            store[i + 1] = item;
            nItems++;
        }
    }

    public int delete() {
        if (!isEmpty()) {
            return store[--nItems];
        } else {
            System.out.println("Error - Priority Queue is empty. Please add before deleting.");
            return -1;
        }
    }

    public int peek() {
        if (!isEmpty()) {
            return store[nItems - 1];
        } else {
            System.out.println("Error - Priority Queue is empty. Please add before deleting.");
            return -1;
        }
    }
}
