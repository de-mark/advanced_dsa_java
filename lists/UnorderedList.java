package lists;

public class UnorderedList {
    private int[] store;
    private int currIdx = 0;

    public UnorderedList(int size) {
        this.store = new int[size];
    }

    public boolean isEmpty() {
        return currIdx == 0;
    }

    public boolean isFull() {
        return currIdx == store.length;
    }

    public void insert(int newItem) {
        if (!isFull()) {
            store[currIdx] = newItem;
            currIdx++;
        } else {
            System.out.println("Array is full; please remove before adding");
        }
    }

    public int find(int findItem) {
        int i;

        for (i = 0; i < currIdx; i++) {
            if (store[i] == findItem) {
                return i;
            }
        }

        return -1;
    }

    public boolean delete(int findItem) {
        if (!isEmpty()) {
            int itemIdx = find(findItem);

            if (itemIdx != -1) {
                for (int i = itemIdx; i < currIdx; i++) {
                    store[i] = store[i + 1];
                }
                currIdx--;
                return true;
            } else {
                System.out.printf("%d was not found in array\n", findItem);
                return false;
            }
        } else {
            System.out.println("Array is empty; please add before removing");
            return false;
        }
    }

    public void display() {
        for (int i = 0; i < currIdx; i++) {
            System.out.printf("%d ", store[i]);
        }

        System.out.print("\n");
    }
}