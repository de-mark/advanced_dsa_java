package huffman_tree;

public class PriorityQueue {
    private int maxSize;
    private int[] store;
    private int size;

    public PriorityQueue(int pqSize) {
        maxSize = pqSize;
        store = new int[maxSize];
        size = 0;
    }

    public boolean isFull() {
        return size >= maxSize;
    }

    // getParent : Returns the intex of the parent node
    private int getParent(int i) {
        return (i - 1) / 2;
    }

    // getLeftChild ; Returns the index of the left child
    private int getLeftChild(int i) {
        return 2 * i + 1;
    }

    private int getRightChild(int i) {
        return 2 * i + 2;
    }

    public void enqueue(int data) {
        if (isFull()) {
            System.out.println("Queue is full; please remove before adding more");
        } else {
            store[size] = data;
            size++;

            int i = size - 1;

            while (i != 0 && store[getParent(i)] < store[i]) {
                int temp = store[i];
                store[i] = store[getParent(i)];
                store[getParent(i)] = temp;
                i = getParent(i);
            }
        }
    }

    // maxHeapify : Moves item at index i to the proper place
    public void maxHeapify(int i) {
        int left = getLeftChild(i);
        int right = getRightChild(i);
        int largest = i;

        if (left <= size && store[left] > store[largest]) {
            largest = left;
        }

        if (right <= size && store[right] > store[largest]) {
            largest = right;
        }

        // Swaps the largest node with the current node
        // This process is recursively repeated until
        // the currest node is larger than the right and left node
        if (largest != i) {
            int temp = store[i];
            store[i] = store[largest];
            store[largest] = temp;
            maxHeapify(largest);
        }
    }

    public int peek() {
        return store[0];
    }

    public int dequeue() {
        int maxItem = store[0];

        store[0] = store[size - 1];
        size--;

        maxHeapify(0);
        return maxItem;
    }
}
