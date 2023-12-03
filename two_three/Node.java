package two_three;

public class Node {
    private int[] data;
    private Node[] children;
    private Node parent;
    private int numItems;

    public Node() {
        this.data = new int[2];
        this.children = new Node[3];
        this.numItems = 0;
    }

    public boolean isLeaf() {
        return children[0] == null;
    }

    public boolean isFull() {
        return numItems == 2;
    }

    public void setParent(Node newParent) {
        this.parent = newParent;
    }

    public Node getParent() {
        return parent;
    }

    public Node getChild(int idx) {
        return children[idx];
    }

    public int getNumItems() {
        return numItems;
    }

    public int getData(int idx) {
        return data[idx];
    }

    public int insertItem(int item) {
        numItems++;

        for (int i = data.length - 1; i >= 0; i--) {
            if (data[i] == 0) {
                continue;
            } else {
                if (item < data[i]) {
                    data[i + 1] = data[i];
                } else {
                    data[i + 1] = item;
                    return i + 1;
                }
            }
        }

        data[0] = item;
        return 0;
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

    public int removeLast() {
        // Assuming node is not empty
        int temp = data[numItems - 1];
        data[numItems - 1] = 0;
        numItems--;
        return temp;
    }

    public Node disconnectChild(int childIdx) {
        Node temp = children[childIdx];
        children[childIdx] = null;
        return temp;
    }

    public void connectChild(Node child, int idx) {
        children[idx] = child;

        if (child != null) {
            child.setParent(this);
        }
    }
}
