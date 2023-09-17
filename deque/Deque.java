package deque;

public class Deque {
    private int[] store;
    private int left;
    private int right;
    private int numItems;

    public Deque(int size) {
        store = new int[size];
        left = 0;
        right = 1;
        numItems = 0;
    }

    public boolean isFull() {
        return numItems == store.length;
    }

    public boolean isEmpty() {
        return numItems == 0;
    }

    private int wrapLeft(int numToDecrement) {
        return numToDecrement - 1 < 0 ? store.length - 1 : numToDecrement - 1;
    }

    private int wrapRight(int numToIncrement) {
        return (numToIncrement + 1) % store.length;
    }

    public boolean insertLeft(int newItem) {
        if (!isFull()) {
            store[left] = newItem;
            left = wrapLeft(left);
            numItems++;
            return true;
        } else {
            System.out.println("Error - Deque is full; delete before adding");
            return false;
        }
    }

    public boolean insertRight(int newItem) {
        if (!isFull()) {
            store[right] = newItem;
            right = wrapRight(right);
            numItems++;
            return true;
        } else {
            System.out.println("Error - Deque is full; delete before adding");
            return false;
        }
    }

    public int deleteLeft() {
        if (!isEmpty()) {
            int deletedItem = store[wrapRight(left)];
            left = wrapRight(left);
            numItems--;
            return deletedItem;
        } else {
            System.out.println("Error - Deque is empty; add before deleting");
            return -1;
        }
    }

    public int deleteRight() {
        if (!isEmpty()) {
            int deletedItem = store[wrapLeft(right)];
            right = wrapLeft(right);
            numItems--;
            return deletedItem;
        } else {
            System.out.println("Error - Deque is empty; add before deleting");
            return -1;
        }
    }

    public int peekLeft() {
        if (!isEmpty()) {
            return store[wrapRight(left)];
        } else {
            System.out.println("Error - Deque is empty; add before peeking");
            return -1;
        }
    }

    public int peekRight() {
        if (!isEmpty()) {
            return store[wrapLeft(right)];
        } else {
            System.out.println("Error - Deque is empty; add before peeking");
            return -1;
        }
    }
}
