package two_three;

public class TwoThree {
    private Node root;

    public TwoThree() {
        root = new Node();
    }

    private void checkSpot(Node curr, int i) {
        Node spot = curr.getChild(i);
        if (spot == null) {
            Node newSpot = new Node();
            newSpot.setParent(curr);
            curr.connectChild(newSpot, i);
        }
    }

    public Node getNextChild(Node curr, int item) {
        int i;

        for (i = 0; i < curr.getNumItems(); i++) {
            if (item < curr.getData(i)) {
                // !!!
                checkSpot(curr, i);
                return curr.getChild(i);
            }
        }
        // !!!
        checkSpot(curr, i);
        return curr.getChild(i);
    }

    public int find(int key) {
        Node curr = root;
        int idx = curr.findItem(key);

        while (idx == -1) {
            curr = getNextChild(curr, key);
            idx = curr.findItem(key);

            if (idx != -1) {
                return idx;
            } else if (curr.isLeaf()) {
                return -1;
            }
        }

        return idx;
    }

    private void displayHelper(Node currNode) {
        if (currNode == null) {
            return;
        } else {
            displayHelper(currNode.getChild(0));
            if (currNode.getData(0) != 0) {
                System.out.println(currNode.getData(0));
            }
            displayHelper(currNode.getChild(1));
            if (currNode.getData(1) != 0) {
                System.out.println(currNode.getData(1));
            }
            displayHelper(currNode.getChild(2));
        }
    }

    public void display() {
        displayHelper(root);
    }

    public void insert(int item) {
        Node curr = root;

        while (true) {
            if (curr.isLeaf()) {
                break;
            } else {
                curr = getNextChild(curr, item);
            }
        }
        if (curr == root && curr.isFull()) {
            splitRoot(curr, item);
        } else if (curr.isFull()) {
            split(curr, item);
        } else {
            curr.insertItem(item);
        }
    }

    private void splitRoot(Node curr, int newItem) {
        Node newLeft = new Node();
        Node newRight = new Node();

        int data2 = curr.removeLast();
        int data1 = curr.removeLast();

        int A, B, C;

        if (newItem < data1) {
            A = newItem;
            B = data1;
            C = data2;
        } else if (newItem < data2) {
            A = data1;
            B = newItem;
            C = data2;
        } else {
            A = data1;
            B = data2;
            C = newItem;
        }

        Node child1 = curr.disconnectChild(0);
        Node child2 = curr.disconnectChild(1);

        if (child1 != null) {
            newLeft.connectChild(child1, 0);
        }
        if (child2 != null) {
            newRight.connectChild(child2, 0);
        }

        newLeft.insertItem(A);
        curr.insertItem(B);
        newRight.insertItem(C);

        curr.connectChild(newLeft, 0);
        curr.connectChild(newRight, 1);
        newLeft.setParent(curr);
        newRight.setParent(curr);
    }

    private void split(Node curr, int newItem) {
        if (curr.getParent().isFull()) {
            if (curr.getParent() == root) {
                splitRoot(curr.getParent(), newItem);
            } else {
                split(curr.getParent(), newItem);
            }
        }

        if (curr.isFull()) {
            Node rightSibling = new Node();
            Node parent = curr.getParent();

            int data2 = curr.removeLast();
            int data1 = curr.removeLast();

            if (newItem < data1) {
                // Item to add is less than both data entries
                rightSibling.insertItem(data2);
                parent.insertItem(data1);
                curr.insertItem(newItem);
            } else if (newItem > data1) {
                if (newItem > data2) {
                    // Item to add is greater than both data entries
                    rightSibling.insertItem(newItem);
                    parent.insertItem(data2);
                    curr.insertItem(data1);
                } else {
                    // Item to add is greater than 0 but less than 1
                    rightSibling.insertItem(data2);
                    parent.insertItem(newItem);
                    curr.insertItem(data1);
                }
            }

            rightSibling.setParent(parent);
            parent.connectChild(rightSibling, 1);
        }
    }
}
