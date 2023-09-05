package lists;

public class OrderedList {
    private int[] store;
    private int currIdx = 0;
    private int currPtr = 0;

    public OrderedList(int size) {
        this.store = new int[size];
    }

    public int getSize() {
        return currIdx;
    }

    public int getNext() {
        if (!isEmpty()) {
            int temp = currPtr;
            currPtr = (currPtr + 1) % currIdx;

            return store[temp];
        }
        System.out.println("Array is currently empty; please add values first");
        return -1;
    }

    public void resetPtr() {
        currPtr = 0;
    }

    public boolean isEmpty() {
        return currIdx == 0;
    }

    public boolean isFull() {
        return currIdx == store.length;
    }

    public int find(int findItem) {
        int low = 0,
                high = currIdx - 1,
                mid;

        while (low <= high) {
            mid = (high + low) / 2;

            if (store[mid] == findItem) {
                return mid;
            } else if (store[mid] < findItem) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    private int findInsert(int newItem) {
        int i;

        for (i = 0; i < currIdx; i++) {
            if (store[i] > newItem) {
                break;
            }
        }

        return i;
    }

    public void insert(int newItem) {
        if (isEmpty()) {
            store[currIdx] = newItem;
            currIdx++;
        } else if (!isFull()) {
            // int currIdx = store[currIdx] = newItem;
            // currIdx++;
            int insertAt = findInsert(newItem);
            for (int i = currIdx; i > insertAt; i--) {
                store[i] = store[i - 1];
            }
            store[insertAt] = newItem;
            currIdx++;
        } else {
            System.out.println("Array is full; please remove before adding");
        }
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

    public OrderedList merge(OrderedList secondList) {
        int newSize = currIdx + secondList.getSize();
        OrderedList resList = new OrderedList(newSize);

        for (int i = 0; i < currIdx; i++) {
            resList.insert(getNext());
        }

        for (int i = 0; i < secondList.getSize(); i++) {
            resList.insert(secondList.getNext());
        }

        return resList;
    }
}