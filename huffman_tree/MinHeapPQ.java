package huffman_tree;

import java.util.NoSuchElementException;

// When we implement this using an array we basically
// map each level of the heap to an array index, left to right

// This means when we do insertion, we can first place the element
// in the next free position of the heap and then secondly
// reorder to ensure each element is less than its children
public class MinHeapPQ {
    private static final int DEFAULT_MAX = 15;
    private static final int ROOT_IDX = 0;

    private Tree[] store;
    private int numElements;

    public MinHeapPQ() {
        this(DEFAULT_MAX);
    }

    public MinHeapPQ(int numElements) {
        if (numElements < 1) {
            throw new IllegalArgumentException("You need at least one element in a priority queue");
        }

        store = new Tree[numElements];
        numElements = 0;
    }

    private Tree elementAtHead() {
        Tree element = store[0];

        if (element == null) {
            throw new NoSuchElementException();
        }

        return element;
    }

    private Tree elementAt(int idx) {
        Tree element = (Tree) store[idx];
        return element;
    }

    private int parentOf(int idx) {
        return (idx - 1) / 2;
    }

    private boolean isNotRoot(int idx) {
        return idx != ROOT_IDX;
    }

    private Tree removeLastElement() {
        numElements--;
        Tree lastElement = elementAt(numElements);
        store[numElements] = null;
        return lastElement;
    }

    private boolean isParentGreater(int insertIdx, Tree newTree) {
        int parentIdx = parentOf(insertIdx);
        // Tree parent = elementAt(parentIdx);
        Tree parent = store[parentIdx];
        return parent.compareTo(newTree);
    }

    private boolean exists(int idx) {
        return idx < numElements;
    }

    private int leftChildIndex(int parentIdx) {
        return 2 * parentIdx + 1;
    }

    private int rightChildIndex(int parentIdx) {
        return 2 * parentIdx + 2;
    }

    private Tree leftChildElement(int parentIdx) {
        int leftChildIdx = leftChildIndex(parentIdx);
        return exists(leftChildIdx) ? store[leftChildIdx] : null;
    }

    private Tree rightChildElement(int parentIdx) {
        int rightChildIdx = rightChildIndex(parentIdx);
        return exists(rightChildIdx) ? store[rightChildIdx] : null;
    }

    private boolean isGreaterThanChildren(Tree element, int parentIdx) {
        Tree leftChild = leftChildElement(parentIdx);
        Tree rightChild = rightChildElement(parentIdx);

        return leftChild != null &&
                element.compareTo(leftChild) &&
                rightChild != null &&
                element.compareTo(rightChild);
    }

    private int smallerOf(int leftChildIdx, int rightChildIdx) {
        Tree leftChild = store[leftChildIdx];
        Tree rightChild = store[rightChildIdx];
        return leftChild.compareTo(rightChild) ? rightChildIdx : leftChildIdx;
    }

    private int smallestChildOf(int parentIdx) {
        int leftChildIdx = leftChildIndex(parentIdx);
        int rightChildIdx = rightChildIndex(parentIdx);

        if (!exists(rightChildIdx)) {
            return leftChildIdx;
        }

        return smallerOf(leftChildIdx, rightChildIdx);
    }

    private void copyParentDownTo(int insertIdx) {
        int parentIdx = parentOf(insertIdx);
        store[insertIdx] = store[parentIdx];
    }

    private void moveSmallestChildUpTo(int parentIdx) {
        int smallestChildIdx = smallestChildOf(parentIdx);
        store[parentIdx] = store[smallestChildIdx];
    }

    private void siftUp(Tree newTree) {
        int insertIndex = numElements;

        while (isNotRoot(insertIndex) &&
                isParentGreater(insertIndex, newTree)) {
            copyParentDownTo(insertIndex);
            insertIndex = parentOf(insertIndex);
        }

        store[insertIndex] = newTree;
    }

    private void siftDown(Tree newTree) {
        int lastElementidx = ROOT_IDX;
        while (isGreaterThanChildren(newTree, lastElementidx)) {
            moveSmallestChildUpTo(lastElementidx);
            lastElementidx = smallestChildOf(lastElementidx);
        }

        store[lastElementidx] = newTree;
    }

    public boolean isFull() {
        return numElements == store.length;
    }

    public boolean isEmpty() {
        return numElements == 0;
    }

    public int getNumItems() {
        return numElements;
    }

    public void enqueue(Tree newTree) {
        if (isFull()) {
            System.out.println("Priority Queue is full; please remove items before adding more");
        }
        siftUp(newTree);
        numElements++;
    }

    public Tree dequeue() {
        Tree res = elementAtHead();
        Tree lastElem = removeLastElement();
        siftDown(lastElem);
        return res;
    }

    public Tree peek() {
        return elementAtHead();
    }
}
