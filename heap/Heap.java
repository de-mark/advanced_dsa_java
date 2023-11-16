package heap;

public class Heap {
    private Node[] heap;
    private int numItems;

    public Heap(int size) {
        heap = new Node[size];
        numItems = 0;
    }

    public boolean isEmpty() {
        return numItems == 0;
    }

    public boolean isFull() {
        return numItems == heap.length;
    }

    private void trickleUp(int idx) {
        int parent = (idx - 1) / 2;
        Node temp = heap[idx];

        while (idx > 0 && heap[parent].getData() < temp.getData()) {
            heap[idx] = heap[parent];
            idx = parent;
            parent = (parent - 1) / 2;
        }
        heap[idx] = temp;
    }

    public void insert(int data) {
        if (!isFull()) {
            Node newNode = new Node(data);
            heap[numItems] = newNode;
            trickleUp(numItems);
            numItems++;
        } else {
            System.out.print("Heap is full; cannot insert.");
        }
    }
}
