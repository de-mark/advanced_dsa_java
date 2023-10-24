package two_three_four;

public class Node {
    // Up to 3
    private int[] data;
    // Up to 4
    private Node[] children;
    private int numItems;
    private Node parent;

    public Node() {
        data = new int[3];
        children = new Node[4];
        numItems = 0;
    }

    public Node getParent() {
        return parent;
    }

    public boolean isLeaf() {
        return children[0] == null;
    }

    public boolean isFull() {
        return numItems == 3;
    }

    public int findItem(int key) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == key) {
                return i;
            } else if (data[i] == 0) {
                break;
            }
        }

        return -1;
    }

    public int removeItem() {
        // This is not an empty node
        // No node in a 2-3-4 tree is ever empty
        int temp = data[numItems - 1];
        data[numItems - 1] = 0;
        numItems--;
        return temp;
    }

    public int insertItem(int item) {
        for (int i = data.length - 1; i >= 0; i--) {
            if (data[i] == 0) {
                continue;
            } else if (item < data[i]) {
                data[i + 1] = data[i];
            } else {
                data[i + 1] = item;
                return i + 1;
            }
        }
        data[0] = item;
        numItems++;
        return 0;
    }

    public Node disconnectChild(int childIndex) {
        Node temp = children[childIndex];
        children[childIndex] = null;
        return temp;
    }

    public void connectChild(Node child, int index) {
        children[index] = child;

        if (child != null) {
            parent = this;
        }
    }

    public Node getChild(int index) {
        return children[index];
    }
}
