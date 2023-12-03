package two_three_four;

public class Node {
    int[] data;
    Node[] children;
    int numOfItems;
    Node parent;
    boolean isDeleted;

    public Node() {
        data = new int[3];
        children = new Node[4];
        numOfItems = 0;
        isDeleted = false;
    }

    public void delete() {
        isDeleted = true;
    }

    public Node getParent() {
        return parent;
    }

    public boolean isLeaf() {
        return children[0] == null;
    }

    public boolean isFull() {
        return numOfItems == 3;
    }

    public int findItem(int key) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == key)
                return i;
            else if (data[i] == 0)
                break;
        }
        return -1;
    }

    public int removeItem() {
        // this is not an empty node
        int temp = data[numOfItems - 1];
        data[numOfItems - 1] = 0;
        numOfItems--;
        return temp;
    }

    public int insertItem(int item) {
        numOfItems++;
        for (int i = data.length - 1; i >= 0; i--) {
            if (data[i] == 0)
                continue;
            else {
                if (item < data[i])
                    data[i + 1] = data[i];
                else {
                    data[i + 1] = item;
                    return i + 1;
                }
            }
        }
        data[0] = item;
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
            child.parent = this;
        } else {
            System.out.println("!!!!!!CHILD WAS NULL!!!!!!");
        }

    }

    public Node getChild(int index) {
        return children[index];
    }
}
